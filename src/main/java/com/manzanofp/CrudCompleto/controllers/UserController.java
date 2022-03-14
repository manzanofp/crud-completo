package com.manzanofp.CrudCompleto.controllers;

import com.manzanofp.CrudCompleto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/listNames/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public  String listNames (@PathVariable String name){
        return "Deu certo" + name;
    }

}
