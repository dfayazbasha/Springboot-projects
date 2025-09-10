package springboot.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.project.repository.Studentrepostiry;
import springboot.project.main.Student;

import java.util.List;
import java.util.Optional;


@Service

public class Studentservices {

    @Autowired
    private Studentrepostiry studentrepostiry;

    public  String  updatestudent(int id, Student newstudent) {
        Optional<Student> optionlastudent=studentrepostiry.findById(id);
        if(optionlastudent.isPresent()){
            Student oldstudent=optionlastudent.get();
            oldstudent.setName(newstudent.getName());
            oldstudent.setPercentage(newstudent.getPercentage());
            studentrepostiry.save(oldstudent);
            return "studentupdated successfully";

        }else{
            return "student not found!";
        }
    }


    public Student insertonerecord(Student student){
        return studentrepostiry.save(student);
    }

    public List<Student> multiplerecords(List<Student> student) {
        return studentrepostiry.saveAll(student);
    }
    public List<Student> wholedata(){
        return studentrepostiry.findAll();
    }

}
