package poly.edu.lab5.dao;
// Bai 5
import poly.edu.lab5.entity.ItemShop;

import java.util.HashMap;
import java.util.Map;

public class DB {
    public static Map<Integer, ItemShop> items = new HashMap<>();

    static {
        items.put(1, new ItemShop(1, "Samsung", 10.0));
        items.put(2, new ItemShop(2, "Nokia 2021", 20.5));
        items.put(3, new ItemShop(3, "iPhone 20", 90.49));
        items.put(4, new ItemShop(4, "Motorola", 15.55));
        items.put(5, new ItemShop(5, "Seamen", 8.99));
    }
}
