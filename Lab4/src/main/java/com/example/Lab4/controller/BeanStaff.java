package com.example.Lab4.controller;

import com.example.Lab4.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BeanStaff {

    @GetMapping("/staff-create/form")
    public String createForm(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "staff-create"; // => templates/staff-create.html
    }

    @PostMapping("/staff/create/save")
    public String createSave(Model model,
                             @ModelAttribute("staff") Staff staff,
                             @RequestPart(value = "photo_file", required = false) MultipartFile photoFile) {

        if (photoFile != null && !photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        model.addAttribute("message", "Xin chào " + staff.getFullname());
        model.addAttribute("staff", staff);

        return "staff-create";
    }
}
