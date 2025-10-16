package poly.edu.lab5.entity;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    // Doc Chuoi
    public String getString (String name , String defaultValue){
        String value = request.getParameter(name);
        return ( value != null ) ? value : defaultValue ;
    }

    // Doc so nguyen
    public  int getInt (String name , int defaultValue){
        try{
            return Integer.parseInt(request.getParameter(name));
        }catch (Exception e) {
            return defaultValue;
        }
    }

    // Doc so thuc
    public double getDouble (String name , double defaultValue){
        try{
            return Double.parseDouble(request.getParameter(name));
        }catch (Exception e) {
            return defaultValue;
        }
    }

    // Doc Boolean
    public boolean getBoolean (String name , boolean defaultValue){
        try{
            return Boolean.parseBoolean(request.getParameter(name));
        }catch (Exception e) {
            return defaultValue;
        }
    }

    // Doc Ngay
    public Date getDate (String name , String pattern){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(request.getParameter(name));
        }catch (Exception e) {
            return null;
        }
    }

    // Lua file upload
    public File save ( MultipartFile file , String path) throws IOException{
        if (file.isEmpty()) {
            File dir = new File(path);
            if (!dir.exists()) dir.mkdirs();
            File saveFile = new File(dir , file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile;
        }
        return null;
    }
}
