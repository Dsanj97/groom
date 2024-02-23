package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    // 아이템 저장
    public void save(Item item){
        if (item.getId() == null){ // 아이템은 처음에 아이디가 없다???
            em.persist(item);
        } else {
            em.merge(item); // 업데이트 비슷한거
        }
    }

    // 아이템 한개 조회
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    // 아이템여러개 조회
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
