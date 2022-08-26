package com.codegym.dto;

import com.codegym.until.DateTimeUntil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.format.DateTimeFormatter;

public class UserDto implements Validator {
    private Integer id;

    @Size(min = 5, max = 45, message = "*Tên có độ dài không dưới 5 ký tự và không quá 45 ký tự!")
    @NotBlank(message = "*Không được để trống")
    private String firstName;

    @Size(min = 5, max = 45, message = "*Họ có độ dài không dưới 5 ký tự và không quá 45 ký tự!")
    @NotBlank(message = "*Không được để trống")
    private String lastName;

    @Pattern(regexp = "^09[0|1][0-9]{7}$", message = "*Số điện thoại bắt đầu 090xxxxxxx hoặc 091xxxxxxx!")
    private String phoneNumber;

    @NotBlank(message = "*Không được để trống")
    private String age;

    @Email(message = "*Vui lòng nhập mail đúng định dạng")
    @NotBlank(message = "*Không được để trống")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;

    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (!"".equals(userDto.age)) {
            boolean result = DateTimeUntil.formatterAge(userDto.age, formatter);
            if (result) {
                errors.rejectValue("age", "age.file");
            }
        }
    }
}
