package com.example.demoforrohit.services;

import com.example.demoforrohit.Entity.App;
import com.example.demoforrohit.JPA.appInterface;
//import com.example.demoforrohit.repo.appRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class appService {

//    @Autowired
//    private appRepo appRepo;
//        private List<App> list = new ArrayList<>();


    @Autowired
    private  appInterface appInterface;

    @PostMapping
    public App create(App app){
        System.out.print(app);
        appInterface.save(app);
        return app;
    }

    @GetMapping
    public List<App> getList(){
//        System.out.print(list);
        return appInterface.findAll();
    }

}
