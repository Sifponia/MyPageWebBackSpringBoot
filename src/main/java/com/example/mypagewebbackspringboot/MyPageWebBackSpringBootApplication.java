package com.example.mypagewebbackspringboot;

import com.example.mypagewebbackspringboot.entity.User;
import com.example.mypagewebbackspringboot.repository.UserRepository;
import com.example.mypagewebbackspringboot.service.UserService;
import com.example.mypagewebbackspringboot.tdo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyPageWebBackSpringBootApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;


    private static final Logger LOG =
            LoggerFactory.getLogger(MyPageWebBackSpringBootApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(MyPageWebBackSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Method insert user
        // insert();


        //Method delete user
        //delete();

        //Method all user
        //allUser();

    }


    //Method insert user
    public void insert() {

        UserVO user = new UserVO();
        user.setUsername("Sifponia194");
        Long userId = userService.save(user);

        LOG.info("User id: " + userId);

    }


    //Method delete user
    public void delete() {

        Long userId = 2L;
        userService.delete(userId);

        LOG.info("User deleted id: ", userId);

    }


    //Method all user
    public void allUser() {

        userService.allUser().forEach(System.out::println);


    }
}
