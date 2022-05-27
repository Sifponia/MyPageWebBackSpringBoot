package com.example.mypagewebbackspringboot.controller;


import com.example.mypagewebbackspringboot.entity.Message;
import com.example.mypagewebbackspringboot.entity.Users;
import com.example.mypagewebbackspringboot.repository.UserRepository;
import com.example.mypagewebbackspringboot.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.mail.MessagingException;
import javax.validation.Valid;
;import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {

    // private static final Logger LG = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;


   /* @Autowired
    private MessageSend message;*/


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder   bCryptPasswordEncoder;





    //Method send email
    @GetMapping("/users")
    public ResponseEntity<?> allUsers() {

        return ResponseEntity.status(HttpStatus.OK).
                allow(HttpMethod.GET)
                .body(userService.allUser());

    }


    @PostMapping("/users")
    public ResponseEntity<?> addUser(@Valid @RequestBody Users user, BindingResult result) throws MessagingException, UnsupportedEncodingException {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }





      String securityKey = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(securityKey);

        userRepository.save(user);


        return ResponseEntity.status(HttpStatus.OK).
                allow(HttpMethod.GET)
                .body(userService.allUser());

    }


    @PostMapping("/message")
    public void sendEmail(@RequestBody @Valid Message message,
                          BindingResult bindingResult)
            throws MessagingException, UnsupportedEncodingException {


        userService.send(message);


    }


}















