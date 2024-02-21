package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item", // <== 다대다 중간에 있는 테이블
            joinColumns = @JoinColumn(name = "category_id"), // <== category 쪽 매핑
            inverseJoinColumns = @JoinColumn(name = "item_id") // <== item 쪽 매필
    )
    private List<Item> items = new ArrayList<>();

    // 카테고리의 계층 구조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    // 자식의경우 여러가지의 카테고리를 가짐
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // 연관관계 메서드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

}
