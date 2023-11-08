package in.mammadov.springrestapi.service;

import in.mammadov.springrestapi.model.Employee;
import in.mammadov.springrestapi.repository.EmployeeRepository;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
         Optional<Employee> employeeOptional = employeeRepository.findById(id);
         if (employeeOptional.isPresent()){
             return employeeOptional.get();
         }
         throw new RuntimeException("Employee is not found for the id " + id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee> getEmployeeByKeyword(String keyword) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        return employeeRepository.findByNameContaining(keyword,sort);
    }


}
