package com.example.mypagewebbackspringboot.tdo;

import com.example.mypagewebbackspringboot.entity.Users;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "idUser can not null")
    private Long idUser;

    @NotNull(message = "username can not null")
    private String username;


    @NotNull(message = "username can not null")
    private String password;

    @NotNull(message = "username can not null")
    private Long active; //0:inactive, 1:active


    private List<Users> userVOList;

    public void setUsers(List<Users> all) {
        this.userVOList = all;

    }

    public List<Users> getUsers() {
        return userVOList;
    }


}
