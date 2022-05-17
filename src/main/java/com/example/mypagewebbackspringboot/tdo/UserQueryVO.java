package com.example.mypagewebbackspringboot.tdo;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idUser;

    private String username;

}
