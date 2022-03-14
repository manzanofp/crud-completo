package com.manzanofp.CrudCompleto.controllers;

import com.manzanofp.CrudCompleto.model.User;
import com.manzanofp.CrudCompleto.repositories.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/listName/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String listName(@PathVariable String name) {
        return "Deu certo" + name;
    }

    @GetMapping(value = "/listAllUser")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


}
