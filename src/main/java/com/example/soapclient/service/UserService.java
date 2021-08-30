package com.example.soapclient.service;

import example.spring.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    public final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void init(){
        User a = new User();
        a.setName("a");
        a.setAge(20);
        users.put(a.getName(), a);
    }

    public User getUser(String name){
        return users.get(name);
    }

}
