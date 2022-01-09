package com.lab.springmvc.user.dao;

import com.lab.springmvc.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{

    private final EntityManager em;

    @Override
    public void insertMember(User user) {
        em.persist(user);
    }
}
