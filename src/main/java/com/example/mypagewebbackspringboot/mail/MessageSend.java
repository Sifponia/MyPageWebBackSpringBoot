package com.example.mypagewebbackspringboot.mail;

import com.example.mypagewebbackspringboot.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Service
public class MessageSend {
    //Metodo JavaMailSender
    @Autowired
    private JavaMailSender mailSender;

    //Metodo send
    public void send(Message message) throws MessagingException,
            UnsupportedEncodingException {


        //Cuerpo del correo
        String mailContent = "<h4> My email is for contact:  " + message.getEmailAddress() + ", </h4>";
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


        //Cuerpo del correo
       /* String mailContent = "<h4> My email is for contact:  " + message.getEmailAddress() + ", </h4>";
        mailContent += "<h4> " + message.getMessage() + ", </h4>";


        //Saludos
        mailContent += "<p> Gracias </p> <br> <h5>Team Das Kind</h5>";

        //Object para enviar los datos añadidos anteriormente
        MimeMessage messagee = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messagee);


        helper.setTo("diegomauricio15@hotmail.com");
        helper.setSubject(message.getSubject());
        helper.setText(mailContent, true);
        //Enviar correo
        mailSender.send(messagee);*/
    }
}
