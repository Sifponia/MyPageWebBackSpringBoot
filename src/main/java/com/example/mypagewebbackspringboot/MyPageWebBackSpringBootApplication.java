package com.example.mypagewebbackspringboot;

import com.example.mypagewebbackspringboot.repository.UserRepository;
import com.example.mypagewebbackspringboot.service.UserService;
import com.example.mypagewebbackspringboot.tdo.UserVO;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

//@ComponentScan("com.example.mypagewebbackspringboot.repository")


public class MyPageWebBackSpringBootApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    private static final Logger LOG =
            LoggerFactory.getLogger(MyPageWebBackSpringBootApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(MyPageWebBackSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Method insert user
        //insert("user2");


        //Method delete user
        //delete();

        //Method all user
        //allUser();

    }


    //Method insert user
    public void insert(String name) {

        try {


            UserVO user = new UserVO();
            user.setUsername(name);
            Long userId = userService.save(user);

            LOG.info("Users id: " + userId);

            allUser();

        } catch (Exception dsa) {
            LOG.error(" >>>>>>>>>>>  DataBindingException: ", dsa.getMessage());
        }


    }


    //Method delete user
    public void delete() {

        Long userId = 2L;
        userService.delete(userId);

        LOG.info("Users deleted id: ", userId);

    }


    //Method all user
    public void allUser() {

        userService.allUser().forEach(System.out::println);

    }


    //Method delete user
    public void deleteUser(Long userId) {

        userId = 2L;
        userService.delete(userId);

        LOG.info("Users deleted id: ", userId);

    }
}
