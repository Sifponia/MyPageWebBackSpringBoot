package com.example.mypagewebbackspringboot.service;

import com.example.mypagewebbackspringboot.entity.Users;
import com.example.mypagewebbackspringboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDetailsService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Users user = userRepository.findByUsername(username);

        if (user == null) {
            LOGGER.error("Usuario no encontrado con el nombre: " + username);
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username);

        }


        List<GrantedAuthority> authorities = user.getRoles()
                .stream().map(roles -> new SimpleGrantedAuthority(roles.getNombre()))
                .collect(Collectors.toList());


        return new User(user.getUsername(), user.getPassword(),
                user.getActive() == 1, true, true, true,
                authorities);


    }
}





