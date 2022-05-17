package com.example.mypagewebbackspringboot.tdo;

import com.example.mypagewebbackspringboot.entity.User;
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


    private List<User> userVOList;

    public void setUsers(List<User> all) {
        this.userVOList = all;

    }

    public List<User> getUsers() {
        return userVOList;
    }


}
