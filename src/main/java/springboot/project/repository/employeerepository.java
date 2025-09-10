package springboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.project.main.employee;

public interface employeerepository extends JpaRepository<employee, Integer> {
}
