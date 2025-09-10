package springboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.project.main.Student;

public interface Studentrepostiry  extends JpaRepository <Student,Integer>{

}
