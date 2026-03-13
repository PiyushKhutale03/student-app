package com.piyush.student_app.service;

import com.piyush.student_app.exception.StudentNotFoundException;
import com.piyush.student_app.model.StudentPost;
import com.piyush.student_app.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public List<StudentPost> getAllstudents() {
        return repo.findAll();
    }

    public void addStudent(StudentPost student) {
        repo.save(student);
    }

    public void updateStudent(int id, StudentPost student) {
        if (!repo.existsById(id)) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        student.setStudentId(id);
        repo.save(student);
    }

    public void deleteStudent(int id) {
        if (!repo.existsById(id)) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        repo.deleteById(id);
    }
}