package in.mammadov.springrestapi.controller;

import in.mammadov.springrestapi.model.Employee;
import in.mammadov.springrestapi.service.EmployeeService;
import in.mammadov.springrestapi.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){

            return new ResponseEntity<Employee>(employeeService.getEmployee(id),HttpStatus.OK);
    }

    @PostMapping("/employees")
    public  ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){

            return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
            employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with ID " + id + " has been deleted", HttpStatus.OK);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name),HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name,@RequestParam String location){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name,location),HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String keyword){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployeeByKeyword(keyword),HttpStatus.OK);
    }

}
