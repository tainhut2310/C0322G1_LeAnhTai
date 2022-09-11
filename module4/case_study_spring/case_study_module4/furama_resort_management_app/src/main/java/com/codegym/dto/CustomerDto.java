package com.codegym.dto;

import com.codegym.model.CustomerType;
import com.codegym.util.DateTimeUntil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.format.DateTimeFormatter;

public class CustomerDto implements Validator {
    private Integer id;
    @NotBlank(message = "*Không được để trống!")
    @Pattern(regexp = "^([A-Z\\\\P{L}]{1}[a-z\\\\p{L}]*)+(\\\\s([A-Z\\\\P{L}]{1}[a-z\\\\p{L}]*))*$",
            message = "*Tên không được chứa số và mỗi ký tự đầu phải viết hoa!")
    private String name;

    @NotBlank(message = "*Không được để trống!")
    private String dateOfBirthday;

    private Integer gender;

    @Pattern(regexp = "\\d{9}|\\d{11}", message = "*CMND gồm 9 đến 11 số!")
    @NotBlank(message = "*Không được để trống")
    private String idCard;

    @Pattern(regexp = "^09[0|1][0-9]{7}$", message = "*Số điện thoại bắt đầu 090xxxxxxx hoặc 091xxxxxxx!")
    @NotBlank(message = "*Không được để trống!")
    private String phoneNumber;

    @NotBlank(message = "*Không được để trống!")
    @Email(message = "*Nhập email đúng định dạng ***@gmail.com!")
    private String email;

    @NotBlank(message = "*Không được để trống!")
    private String address;

    private CustomerType customerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!"".equals(customerDto.dateOfBirthday)) {
            boolean result = DateTimeUntil.formatterAge(customerDto.dateOfBirthday, formatter);
            if (result) {
                errors.rejectValue("dateOfBirthday",
                        "create.dateOfBirthday",
                        "*Bạn chưa đủ 18 tuổi!");
            }
        }
        if (customerDto.gender == null) {
            errors.rejectValue("gender",
                    "create.gender",
                    "*Không được để trống!");
        }

        if (customerDto.customerType == null) {
            errors.rejectValue("customerType",
                    "create.customerType",
                    "*Không được để trống!");
        }
    }
}
