package com.softpager.estores.daos;

import com.softpager.estores.entities.Users;

import javax.persistence.EntityManager;

public class UserDao extends JpaDao<Users> {

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Users create(Users users) {
        return super.create(users);
    }
    @Override
    public Users update(Users users) {
        return super.update(users);
    }
}
