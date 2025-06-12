package com.example.demoforrohit.controller;


import com.example.demoforrohit.Entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demoforrohit.services.appService;

import java.util.List;

@RestController
@RequestMapping("/rohit")
public class appController {

    @Autowired  
    private appService appService;

    @GetMapping
    public List<App> getAll(){;
        return appService.getList();
    }

    @PostMapping
    public App create(@RequestBody App app){
        System.out.print(app);
        return appService.create(app);
    }

}
