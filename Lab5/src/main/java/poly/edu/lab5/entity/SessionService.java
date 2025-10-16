package poly.edu.lab5.entity;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    // Đọc giá trị attribute
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) session.getAttribute(name);
    }

    // Ghi giá trị vào session
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    // Xóa attribute khỏi session
    public void remove(String name) {
        session.removeAttribute(name);
    }
}
