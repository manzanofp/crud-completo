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

    @GetMapping(value = "/findUser")
    public ResponseEntity<Optional<User>> findById(@RequestParam Integer iduser) {
        Optional<User> user = userRepository.findById(iduser);
        return  ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/saveUser")
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User obj = userRepository.save(user);
        return new ResponseEntity<User>(obj, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateUser")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestBody User user){
        if (user.getId() == null){
            return new ResponseEntity<String>("Está faltando o atributo Id",HttpStatus.NOT_FOUND);
        }
        User obj = userRepository.saveAndFlush(user);
        return  new ResponseEntity<User>(obj, HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteUser")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestParam Integer iduser){
        userRepository.deleteById(iduser);
        return  new ResponseEntity<String>("User successfully deleted",HttpStatus.OK);
    }

    @GetMapping(value = "/findByName")
    @ResponseBody
    public ResponseEntity<List<User>> findByName(@RequestParam(name = "name") String name) {
        List<User> obj = userRepository.findByName(name.trim().toUpperCase());
        return new  ResponseEntity<List<User>>(obj,HttpStatus.OK);
    }
}
