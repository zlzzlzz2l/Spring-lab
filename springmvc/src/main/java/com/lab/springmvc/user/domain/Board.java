package com.lab.springmvc.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "board")
    private List<User_Board> user_boards = new ArrayList<>();
}
