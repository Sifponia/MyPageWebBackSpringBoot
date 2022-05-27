package com.example.mypagewebbackspringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "username", nullable = false)
    private String username;


    //@Column(name = "password", nullable = false)
    private String password;

    //@Column(name = "active", nullable = false)
    private Long active;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;


    public void agregar(Role tempPerfiles) {
        if (roles == null) {
            roles = new LinkedList<Role>();
        }

        roles.add(tempPerfiles);

    }


    @PrePersist
    public void prePersist() {
        /*Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.dateCreate = formatter.format(date);*/

        Role roles = new Role();
        roles.setId(2L);

        agregar(roles);
    }


    //constructor
    public Users(String username) {
        this.username = username;

    }


    public Users() {


        this.active = 1L;
    }

}
