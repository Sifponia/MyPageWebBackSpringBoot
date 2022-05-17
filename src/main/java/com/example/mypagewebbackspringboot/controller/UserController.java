package com.example.mypagewebbackspringboot.controller;


import com.example.mypagewebbackspringboot.entity.Message;
import com.example.mypagewebbackspringboot.mail.MessageSend;
import com.example.mypagewebbackspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import javax.mail.MessagingException;
import javax.validation.Valid;
;import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService userService;


    private MessageSend message;


    //Method send email
    @GetMapping("/users")
    public ResponseEntity<?> allUsers() {

        return ResponseEntity.status(HttpStatus.OK).
                allow(HttpMethod.GET)
                .body(userService.allUser());

    }

    //Method send email
    @PostMapping("/menssage")
    public void sendEmail(@RequestBody @Valid Message message)
            throws MessagingException, UnsupportedEncodingException{





        System.out.println(message.toString());

        userService.send(message);


    }


}















