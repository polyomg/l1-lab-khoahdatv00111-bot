package poly.edu.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import poly.edu.lab5.dao.DB;

//Bai 5
@Controller
public class ItemController     {
    @RequestMapping("/item/index")
    public String index(Model model) {
        model.addAttribute("items", DB.items.values());
        return "item/index";
    }
}
