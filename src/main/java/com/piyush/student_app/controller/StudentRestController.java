package com.piyush.student_app.controller;

import com.piyush.student_app.model.StudentPost;
import com.piyush.student_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = " http://localhost:3000")
public class StudentRestController {

    @Autowired
    private StudentService service;

    @GetMapping("students")
    public List<StudentPost> getAllstudents(){
        return service.getAllstudents();
    }

    @PostMapping("students")
    public void addStudent(@RequestBody StudentPost student){
        service.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable int id,
                              @RequestBody StudentPost student) {
        service.updateStudent(id, student);
    }

    @DeleteMapping ("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }

}
