package com.example.Lab4.entity;


import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StaffValidation {

    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    private String id;
    @NotBlank(message = "Chưa nhập họ và tên")
    private String fullname;
    @Builder.Default
    private String photo = "photo.jpg";
    @NotNull(message="Chưa chọn giới tính")
    private boolean gender;
    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;
    @Min(value = 1000,message = "Lương tối thiểu phải là 1000")
    @NotNull(message = "Chưa nhập lương")
    private Double salary;
    private Integer level;
}

