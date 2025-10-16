package poly.edu.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.lab5.entity.ParamService;

@Controller
public class UploadController {
    @Autowired
    ParamService paramService;

    @GetMapping("/form")
    public String formUpload() {
        return "/form";
    }

    @PostMapping("/form")
    public String handleUpload(@RequestParam("photo") MultipartFile file) {
        try {
            String path = "src/main/resources/static/images"; // nơi lưu file
            paramService.save(file, path);
            System.out.println("Lưu file thành công: " + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/form";
    }
}
