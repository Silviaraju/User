package com.example.userFormManupulation.Repository;

import com.example.userFormManupulation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Integer>{
}
