package com.lab.springmvc.user.service;

import com.lab.springmvc.user.dao.UserDaoImpl;
import com.lab.springmvc.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDaoImpl userDao;

    @Override
    public void register(User user) {
        userDao.insertMember(user);
    }
}
