package springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.project.services.Studentservices;
import springboot.project.main.Student;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class studentcontroller {
    @GetMapping("displayall")
    public String display() {
        return("displaying tables");

    }

    @GetMapping("data")
    public String getdata(){
        return("getting data");
    }
    @GetMapping("marksdata")
    public String getmarksdata(){
            return ("getting marks details ");
    }

    @Autowired
    private Studentservices services;
    @PostMapping("insertonerecord")
    public Student insertonerecord(@RequestBody Student student){
        return services.insertonerecord(student);
    }


    @PostMapping("multiplerecords")
    public List<Student> multiplerecords(@RequestBody List<Student> student){
        return services.multiplerecords(student);
    }
    @GetMapping("getalldata")
    public List<Student> wholedata(){
        return services.wholedata();
    }
    @PutMapping("/{id}")
    public String updatestudent(@PathVariable int id,@RequestBody Student newstudent){
        return services.updatestudent(id,newstudent);
    }




}
