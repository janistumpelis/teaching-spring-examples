package io.codelex.firstsample.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeById(Integer id);

    @Query("SELECT e FROM Employee e WHERE e.name like ('%' || :name || '%')")
    List<Employee> searchByName(@Param("name") String namePhrase);

}
