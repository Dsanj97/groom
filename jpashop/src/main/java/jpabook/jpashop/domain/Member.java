package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 연관 관계의 주인이 아님 order에 의해 매핑된것 뿐이야
    @OneToMany(mappedBy = "member") // 1대 다 관계
    private List<Order> ordeers = new ArrayList<>();

}
