package poly.edu.lab5.controller;
// Bai 4
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import poly.edu.lab5.service.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ShoppingCartService cart;

    @GetMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("items", cart.getItems());
        model.addAttribute("total", cart.getAmount());
        model.addAttribute("count", cart.getCount());
        return "cart/view";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/cart/view";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    @GetMapping("/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestParam("qty") int qty) {
        cart.update(id, qty);
        return "redirect:/cart/view";
    }
}
