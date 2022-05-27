package com.example.mypagewebbackspringboot.repository;

import com.example.mypagewebbackspringboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {


    public Users findByUsername(String username);

}