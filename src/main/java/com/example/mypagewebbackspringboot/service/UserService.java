package com.example.mypagewebbackspringboot.service;

import com.example.mypagewebbackspringboot.entity.Message;
import com.example.mypagewebbackspringboot.entity.Users;
import com.example.mypagewebbackspringboot.repository.UserRepository;
import com.example.mypagewebbackspringboot.tdo.UserDTO;
import com.example.mypagewebbackspringboot.tdo.UserQueryVO;
import com.example.mypagewebbackspringboot.tdo.UserUpdateVO;
import com.example.mypagewebbackspringboot.tdo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
;
import org.springframework.stereotype.Service;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.UnsupportedEncodingException;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<Users> allUser() {
        UserVO userVO = new UserVO();
        userVO.setUsers(userRepository.findAll());
        return userVO.getUsers();
    }

    public Long save(UserVO vO) {
        Users bean = new Users();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getIdUser();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(Long id, UserUpdateVO vO) {
        Users bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    public UserDTO getById(Long id) {
        Users original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserDTO toDTO(Users original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Users requireOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }


    //Metodo JavaMailSender
    @Autowired
    private JavaMailSender mailSender;

    //Metodo send
    public void send(Message message) throws MessagingException,
            UnsupportedEncodingException {


        //Cuerpo del correo
        String mailContent = "<h3> My name is:  " + message.getName() + ", </h4> <br>" +
                "<h4> My email is for contact:  " + message.getEmailAddress() + ", </h4>";
        mailContent += "<h4> " + message.getMessage() + ", </h4>";


        //Saludos
        mailContent += "<p> Gracias </p> <br> <h5>Team Das Kind</h5>";

        //Object para enviar los datos añadidos anteriormente
        MimeMessage messagee = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messagee);


        helper.setText("<h1>Hola</h1>", true);
        //  helper.setFrom("DASkIND@GMAIL.COM", "DASkIND");
        helper.setTo("diegomauricio15@hotmail.com");
        helper.setSubject(message.getSubject());
        helper.setText(mailContent, true);
        //Enviar correo
        mailSender.send(messagee);
    }

}
