package service.impl;

import model.Customer;
import model.validate.Validate;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Map<String, String> insert(Customer customer) throws SQLException {
        Map<String, String> mapErrors = new HashMap<>();
        if (!customer.getName().isEmpty()) {
            if (!Validate.checkName(customer.getName())) {
                mapErrors.put("name", "*Nhập tên sai định dạng, tên không được chứa số và các ký tự đầu phải viết hoa");
            }
        } else {
            mapErrors.put("name", "*Vui lòng nhập tên");
        }

        if (!customer.getPhoneNumber().isEmpty()) {
            if (!Validate.checkPhoneNumber(customer.getPhoneNumber())) {
                mapErrors.put("phoneNumber", "*Nhập số điện thoại sai định dạng, phải bắt đầu 090 hoặc 091 và 10 số ");
            }
        } else {
            mapErrors.put("phoneNumber", "*Vui lòng nhập số điện thoại");
        }

        if (!customer.getEmail().isEmpty()) {
            if (!Validate.checkEmail(customer.getEmail())) {
                mapErrors.put("email", "*Nhập số email sai định dạng");
            }
        } else {
            mapErrors.put("email", "*Vui lòng nhập email");
        }

        if (!customer.getIdCard().isEmpty()) {
            if (!Validate.checkIdCard(customer.getIdCard())) {
                mapErrors.put("idCard", "*Nhập số CMND sai định dạng, CMND gồm 9 hoặc 12 số không chứa ký tự ");
            }
        } else {
            mapErrors.put("idCard", "*Vui lòng nhập số CMND");
        }

        if (!customer.getDateOfBirthday().isEmpty()) {
            mapErrors.put("dateOfBirthday", "*Vui lòng nhập ngày sinh");
        }

        if (!customer.getAddress().isEmpty()) {
            mapErrors.put("address", "*Vui lòng nhập số địa chỉ");
        }

        if (mapErrors.size()==0) {
            customerRepository.insert(customer);
        }
        return mapErrors;
    }

    @Override
    public Customer selectById(int id) throws SQLException {
        return customerRepository.selectById(id);
    }

    @Override
    public List<Customer> selectByName(String nameSearch) throws SQLException {
        return customerRepository.selectByName(nameSearch);
    }

    @Override
    public List<Customer> selectAll() throws SQLException {
        return customerRepository.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return customerRepository.update(customer);
    }
}
