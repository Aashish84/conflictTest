package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity
                .ok(userService.getUser());
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveData(userDTO));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/users/page")
    public ResponseEntity<?> findUserByPage(
            @RequestParam(name ="size" , required = false , defaultValue = "10") int size ,
            @RequestParam(name = "pageNo" , required = false , defaultValue = "0") int pageNo
    ){
        return ResponseEntity.ok(userService.getUserByPage(size,pageNo));
    }
}
