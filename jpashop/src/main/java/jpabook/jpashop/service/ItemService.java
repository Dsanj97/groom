package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional // 읽기전용이 아니라서 있어야 한다
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // dirty checking
    // 변경감지 기능
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity ) {
        Item findItem = itemRepository.findOne(itemId);// 아이템을 찾고  ==> 디비에서 찾아옴 영속상태의 아이템

        //findItem.change(name,price,stockQuantity);
        //이런 매서드를 만들어서 변경할것

        findItem.setName(name);
        findItem.setPrice(price); // 넘겨받은 Param 에서 꺼내오면됨
        findItem.setStockQuantity(stockQuantity);
        // 기타 다른 내용들
        // 저정코드를 굳이 쓸필요 없다  트랜잭션널이 걸려있어 자동으로 커밋
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
