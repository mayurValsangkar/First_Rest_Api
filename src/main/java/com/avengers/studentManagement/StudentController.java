package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // get information
    @GetMapping("/get_student") //Adding end point
    public Student getStudent(@RequestParam("q") int admissionNo){
        return studentService.getStudent(admissionNo);
    }

    // Adding the information
    @PostMapping("/add_student")  // Adding end point
    public String addStudent(@RequestBody Student student){
       return studentService.addStudent(student);
    }

    @GetMapping("/get_student_by_name/{name}")
    public Student getStudentByName(@PathVariable("name") String name){
        return studentService.getStudentByName(name);
    }

    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id, @RequestParam int age){
        return studentService.updateStudent(id, age);
    }
}
