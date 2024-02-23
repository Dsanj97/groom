package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 가격
    private int count; // 주문 수량

    // protected OrderItem(){} // 생성자 쓰지 말라는뜻!

    //==생성 매서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item); // 아이템을 설정하고
        orderItem.setOrderPrice(orderPrice); //아에탬의 가격을 정하고
        orderItem.setCount(count); // 갯수를 정하고

        item.removeStock(count); // 갯수만큼 재고 차감하고
        return orderItem;
    }

    //==조회 로직==//
    public void cancel(){ //취소시 취소 수량만큼 재고수를 늘려줘야함
        getItem().addStock(count);
    }

    /*
     * 주문 상품 전체 가격 조회
     */
    public int getTotalPrice() { // 주문 수량과 주문 가격을 곱해야함
        return getOrderPrice() * getCount();
    }
}
