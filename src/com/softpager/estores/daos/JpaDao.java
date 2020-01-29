package com.softpager.estores.daos;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaDao<T> {
    protected EntityManager entityManager;
    public JpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T create(T t){
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.flush();
        entityManager.refresh(t);
        entityManager.getTransaction().commit();
        return  t;
    }

    public T update(T t){
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.refresh(t);
        entityManager.getTransaction().commit();
        return t;
    }


}
