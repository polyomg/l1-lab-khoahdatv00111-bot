package poly.edu.lab5.service;
//Bai5
import org.springframework.stereotype.Service;
import poly.edu.lab5.dao.DB;
import poly.edu.lab5.entity.ItemShop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService2 {
    Map<Integer, ItemShop> cart = new HashMap<>();

    public void add(Integer id) {
        ItemShop item = cart.get(id);
        if (item == null) {
            item = DB.items.get(id);
            item.setQty(1);
            cart.put(id, item);
        } else {
            item.setQty(item.getQty() + 1);
        }
    }

    public void remove(Integer id) {
        cart.remove(id);
    }

    public void update(Integer id, int qty) {
        ItemShop item = cart.get(id);
        if (item != null) {
            item.setQty(qty);
        }
    }

    public void clear() {
        cart.clear();
    }

    public Collection<ItemShop> getItems() {
        return cart.values();
    }
}
