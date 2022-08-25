package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 45, message = "Vui lòng không để trống.Tên có độ dài không dưới 5 ký tự và không quá 45 ký tự")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "Vui lòng không để trống.Họ có độ dài không dưới 5 ký tự và không quá 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^09[0|1][0-9]{7}$", message = "Số điện thoại bắt đầu 090 hoặc 091 gồm 10 số")
    private String phoneNumber;
    @NotBlank(message = "Không được để trống")
    private String age;
    @Email(message = "Vui lòng nhập mail đúng định dạng")
    private String email;

    public UserDto() {
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

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(userDto.age, formatter);
        int current = Period.between(LocalDate.now(), localDate).getDays();
        if(current < 18) {
            errors.rejectValue("age",
                    "age.file",
                    "Tuổi phải lớn hơn hoặc bằng 18");
        }
    }
}
