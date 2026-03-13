package com.piyush.student_app.repo;

import com.piyush.student_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findByUsername(String username);
}
