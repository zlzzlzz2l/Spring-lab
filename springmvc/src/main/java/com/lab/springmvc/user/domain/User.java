package com.lab.springmvc.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String pw;

    private String birthDate;

    @OneToMany(mappedBy = "user")
    private List<User_Board> user_boards = new ArrayList<>();
}
