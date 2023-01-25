package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // get information
    @GetMapping("/get_student") //Adding end point
    public ResponseEntity getStudent(@RequestParam("q") int admissionNo){
        Student student = studentService.getStudent(admissionNo);
        if(student==null){
            return new ResponseEntity<>("Invalid request", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    // Adding the information
    @PostMapping("/add_student")  // Adding end point
    public ResponseEntity addStudent(@RequestBody Student student){
       String response =  studentService.addStudent(student);
       return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/get_student_by_name/{name}")
    public ResponseEntity getStudentByName(@PathVariable("name") String name){
        Student student = studentService.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentService.deleteStudent(id);
        if(response.equals(("Entry does not exist in db"))){
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
    }

    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id, @RequestParam int age){
        String response = studentService.updateStudent(id, age);
        if(response==null){
            return new ResponseEntity("Invalid request", HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity("updated", HttpStatus.ACCEPTED);
    }
}
