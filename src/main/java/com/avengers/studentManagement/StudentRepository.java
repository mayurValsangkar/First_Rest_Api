package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer, Student> db = new HashMap<>();


    public String addStudent(Student student){
        if(student==null){
            return "Invalid Student";
        }
        int admissionNo = student.getAdmissionNo();
        db.put(admissionNo, student);

        return "Student added successfully";
    }

    public Student getStudent(int id){
       return db.get(id);
    }

    public String deleteStudent(int id){
        if(db.containsKey(id)){
            db.remove(id);
            return "Entry Deleted";
        }else{
            return "Entry does not exist in db";
        }
    }

    public String updateStudent(int id, int age){
        if(!db.containsKey(id)){
            return "Entry does not exist in db";
        }else{
            db.get(id).setAge(age);
            return "Entry Updated successfully";
        }
    }

    public Student getStudentByName(String name){
        for(Student s : db.values()){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

}
