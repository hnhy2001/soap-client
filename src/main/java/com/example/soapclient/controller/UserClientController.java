package com.example.soapclient.controller;

import com.example.soapclient.client.SoapUserClient;
import example.spring.GetUserRequest;
import example.spring.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientController {
    @Autowired
    SoapUserClient soapUserClient;

    @PostMapping("/get")
    public ResponseEntity<GetUserResponse> call(@RequestBody GetUserRequest getUserRequest){
        return new ResponseEntity<>(soapUserClient.getUserResponse(getUserRequest), HttpStatus.OK);
    }

}
