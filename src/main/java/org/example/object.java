package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class object {
    @Autowired
    MailHandlerBase obj;


    @GetMapping("api/v1/email")
    public MailHandlerBase get(){
        return obj;
    }
}
