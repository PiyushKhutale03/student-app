package com.piyush.student_app.repo;

import com.piyush.student_app.model.StudentPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentPost, Integer> {
}