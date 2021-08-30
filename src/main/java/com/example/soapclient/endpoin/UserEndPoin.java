package com.example.soapclient.endpoin;

import com.example.soapclient.service.UserService;
import example.spring.GetUserRequest;
import example.spring.GetUserResponse;
import example.spring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoin {

    @Autowired
    UserService userService;

    @PayloadRoot(namespace = "http://example/spring", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = userService.getUser(request.getName());
        if (user == null) {
            return null;
        }
        response.setUser(user);
        return response;
    }
}
