package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // 연관 관계의 주인
    @ManyToOne(fetch = FetchType.LAZY)// 다대1관계
    @JoinColumn(name = "member_id") // 외래키라고 보면됨
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderdate; // 주문 시간

    @Enumerated(EnumType.STRING) // string 이 아니면 나중에 꼬일수 있음
    private OrderStatus status; // 주문 상태 [ORDER, CANCEL]

    // 연관관계 매서드 양방향일때 쓰면 좋다
    public void setMember(Member member){
        this.member = member;
        member.getOrdeers().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }


    //==생성 매서드==//
    //주문이 생성만 한다고 끝나는게 아니라 좀더 복잡한 로직을 가지고 있다
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order(); // 주문 만들어주고
        order.setMember(member); // 맴버 세팅해주고
        order.setDelivery(delivery); // 주소 설정해주고
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        } // 아이템들 넣기
        order.setStatus(OrderStatus.ORDER); // 상태 설정
        order.setOrderdate(LocalDateTime.now()); // 주문시간 설정
        return order;
    }

    //==비즈니스 로직==//
    /*
     * 주문 취소
     */
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP){ // 배송이 끝나버림
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능 합니다");
        }

        this.setStatus(OrderStatus.CANCEL); // 주문의 상태를 취소로 변경
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel(); // 취소 로직
        }
    }

    //==조회 로직==//

    /*
     * 전체 주문 가격 조회
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
