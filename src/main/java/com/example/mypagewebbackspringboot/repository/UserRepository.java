package com.example.mypagewebbackspringboot.repository;

import com.example.mypagewebbackspringboot.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}