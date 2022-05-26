package com.example.mypagewebbackspringboot.entity;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class Message {

    @NotBlank(message = "Name is required")
    private String name;
    private String message;
    @NotBlank
    @Email
    private String emailAddress;
    private String subject;


}
