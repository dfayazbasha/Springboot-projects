package springboot.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.project.main.employee;
import springboot.project.repository.employeerepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.awt.AWTEventMulticaster.add;

@Service
public class  employeeservices {
    @Autowired
    private employeerepository employeerepositorye;
    public employee insertone(employee employee) {
        return employeerepositorye.save(employee);
    }

    public List<employee> getall() {
        return employeerepositorye.findAll();
    }

    public employee getone(int id) {
        return employeerepositorye.findById(id).get();
    }

    public employee update(int id, employee employee) {
        employee result=employeerepositorye.findById(id).get();
        result.setName(employee.getName());
        result.setSalary(employee.getSalary());
        result.setId(employee.getId());
        return employeerepositorye.save(result);
    }

    public List<employee> updateall(List<employee> employee) {
        List<employee> result=employeerepositorye.findAll();
        List<employee> fial=new ArrayList<>();
        for(employee emp:employee){
            Optional<employee> e=employeerepositorye.findById(emp.getId());
            if(e.isPresent()){
                employee existing =e.get();
                existing.setName(emp.getName());
                existing.setSalary(emp.getSalary());
                existing.setId(emp.getId());
                fial.add(existing);
            }
        }
        return employeerepositorye.saveAll(fial);
    }

    public List<employee> addmultiple(List<employee> employee) {
        return employeerepositorye.saveAll(employee);
    }
}
