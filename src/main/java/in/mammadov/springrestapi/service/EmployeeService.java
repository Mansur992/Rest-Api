package in.mammadov.springrestapi.service;

import in.mammadov.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name,String location);

    List<Employee> getEmployeeByKeyword(String keyword);
}
