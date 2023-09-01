package com.example.demo.repo;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "select * from user limit :size offset :pageNo" , nativeQuery = true)
    List<User> findUserByPage(@Param("size") int size , @Param("pageNo") int pageNo);
}
