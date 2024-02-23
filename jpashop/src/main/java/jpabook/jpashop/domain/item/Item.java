package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속관계전략을 지정해야하고 부모클래스에서 지정할것임 한테이블에 때려박는 싱글테이블
@DiscriminatorColumn(name = "dtype") //
@Getter  @Setter // 세터를 사용하지 않고 핵심 비즈니스 로직을 이용하여 데이터에 접근할것
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==//
    // 데이터를 가지고 있는쪽에 서 비즈니스 로직을 가지고 있는것이 제일 좋다
    // 응집력이있다

    /*
     * 재고수량 늘리기
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /*
     * 재고수량 줄이기
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
