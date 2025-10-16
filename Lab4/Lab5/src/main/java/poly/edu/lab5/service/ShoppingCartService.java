package poly.edu.lab5.service;
// Bai 4
import poly.edu.lab5.entity.Item;

import java.util.Collection;

public interface ShoppingCartService {
    Item add(Integer id);                   // Thêm 1 sản phẩm vào giỏ
    void remove(Integer id);                // Xóa sản phẩm khỏi giỏ
    Item update(Integer id, int qty);       // Cập nhật số lượng
    void clear();                           // Xóa toàn bộ giỏ
    Collection<Item> getItems();            // Lấy tất cả sản phẩm trong giỏ
    int getCount();                         // Tổng số lượng
    double getAmount();                     // Tổng tiền
}
