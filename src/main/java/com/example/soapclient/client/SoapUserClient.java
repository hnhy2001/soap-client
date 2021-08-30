package com.example.soapclient.client;

import example.spring.GetUserRequest;
import example.spring.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapUserClient {
    @Autowired
    public Jaxb2Marshaller marshaller;

    WebServiceTemplate template;

    public GetUserResponse getUserResponse(GetUserRequest request){
        template = new WebServiceTemplate(marshaller);
        GetUserResponse response = (GetUserResponse) template.marshalSendAndReceive("http://localhost:9005/ws", request);
        return  response;


    }

}
