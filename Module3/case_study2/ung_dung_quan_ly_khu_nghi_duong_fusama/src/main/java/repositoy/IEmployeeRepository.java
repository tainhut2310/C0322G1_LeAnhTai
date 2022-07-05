package repositoy;

import models.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> display();

    public void addNew(Employee employee);

    public Employee edit(int id);

    public void delete(int id);
}
