package springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.project.main.employee;
import springboot.project.services.employeeservices;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeconstroller {

    @Autowired
    private employeeservices employeeservice;
    @PostMapping("/addone")
    public employee addoneemployee(@RequestBody  employee employe) {
        return employeeservice.insertone(employe);
    }
    @PostMapping("/addmultiple")
    public List<employee> addmultipleemployee(@RequestBody  List<employee> employee) {
        return employeeservice.addmultiple(employee);
    }
    @GetMapping("/getall")
    public List<employee> getallemployees() {
        return employeeservice.getall();
    }
    @GetMapping("/byid/{id}")
    public employee getone(@PathVariable int id) {
        return employeeservice.getone(id);
    }
    @PutMapping("/update/{id}")
    public employee updateone(@PathVariable int id, @RequestBody employee employee) {
        return employeeservice.update(id,employee);
    }
    @PatchMapping("/updateall")
    public List<employee> updateall(@RequestBody List<employee> employee) {
        return employeeservice.updateall(employee);
    }
}
