package com.lab.springmvc.user.dao;

import com.lab.springmvc.user.domain.User;

import java.util.List;

public interface UserDao {
    void insertMember(User user);
    List<User> selectUserFromIdPw(String email, String pw);
}
