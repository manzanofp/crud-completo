package com.manzanofp.CrudCompleto.controllers;

import com.manzanofp.CrudCompleto.model.User;
import com.manzanofp.CrudCompleto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(value = "/listAllUser")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/listUser/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/saveUser")
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User obj = userRepository.save(user);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


}
