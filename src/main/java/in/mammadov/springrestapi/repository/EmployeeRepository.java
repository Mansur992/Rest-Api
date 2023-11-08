package in.mammadov.springrestapi.repository;

import in.mammadov.springrestapi.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
        List<Employee> findByName (String name);

        //select * from employee where name="Mansur" and location="Azerbaijan"

        List<Employee> findByNameAndLocation(String name,String location);

        List<Employee> findByNameContaining(String keyword, Sort sort);

}
