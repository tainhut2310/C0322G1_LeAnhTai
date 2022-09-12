package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Facility;
import com.codegym.util.DateTimeUntil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class ContractDto implements Validator {
    private Integer id;
    @NotBlank(message = "*Không được để trống!")
    private String startDate;

    @NotBlank(message = "*Không được để trống!")
    private String endDate;

    @NotBlank(message = "*Không được để trống!")
    private String deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (!"".equals(contractDto.startDate) && !"".equals(contractDto.endDate)) {
            boolean result = DateTimeUntil.formatterDate(contractDto.startDate, contractDto.endDate);
            if (result) {
                errors.rejectValue("endDate",
                        "create.endDate",
                        "*Ngày kết thúc phải lớn hơn ngày bắt đầu!");

                errors.rejectValue("startDate",
                        "create.startDate",
                        "*Ngày bắt đầu phải bé hơn ngày kết thúc!");
            }
        }
        if (!contractDto.deposit.matches("^?\\d*(\\.\\d+)?$")) {
            errors.rejectValue("deposit",
                    "create.deposit",
                    "*Tiền đặt cọc phải là số nguyên hoặc số thập phân!");
        }

        if (contractDto.customer == null) {
            errors.rejectValue("customer",
                    "create.customer",
                    "*Không được để trống!");
        }

        if (contractDto.employee == null) {
            errors.rejectValue("employee",
                    "create.employee",
                    "*Không được để trống!");
        }

        if (contractDto.facility == null) {
            errors.rejectValue("facility",
                    "create.facility",
                    "*Không được để trống!");
        }
    }
}
