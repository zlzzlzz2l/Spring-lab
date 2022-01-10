package com.lab.springmvc.user.dao;

import com.lab.springmvc.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{

    private final EntityManager em;

    @Override
    public void insertMember(User user) {
        em.persist(user);
    }

    @Override
    public List<User> selectUserFromIdPw(String email, String pw) {
        List<User> result = em.createQuery("SELECT u FROM User u " +
                        "WHERE u.email = :email AND u.pw = :pw", User.class)
                .setParameter("email", email)
                .setParameter("pw", pw)
                .getResultList();
        return result;
    }
}
