package poly.edu.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.lab5.entity.CookieService;
import poly.edu.lab5.entity.ParamService;
import poly.edu.lab5.entity.SessionService;

@Controller

public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    // Hien thi form login
    @GetMapping("/login")
    public String login1(){
        return "/login";
    }

    // su ly khi submit form login
    @PostMapping("/login")
    public String loginPost(){
        // Lay du lieu tu form
        String  username = paramService.getString("username","");
        String  password = paramService.getString("password","");
        boolean rememberMe = paramService.getBoolean("rememberMe",false);

        // Kiem tra Login
        if (username.equals("poly") || password.equals("123")){
            // Lua username vao Session da tao
            sessionService.set("username",username);

            // Nếu chọn RememberMe → lưu cookie 10 tiếng
            if (rememberMe){
                cookieService.add("user", username , 10);
            }else  {
                cookieService.remove("user");
            }
            return "redirect:/home";  // tu tao home neu can khi login thanh cong
        }
        return "/login";
    }
}
