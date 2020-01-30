package com.softpager.estores.daos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaDao<E> {
    protected EntityManager entityManager;
    public JpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E create(E entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E update(E entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E get(Class<E> type, Object id){
     var entity =  entityManager.find(type, id);
     if (entity != null){
         entityManager.refresh(entity);
     }
        return entity;
    }

    public void delete(Class<E> type, Object id){
        entityManager.getTransaction().begin();
        var reference = entityManager.getReference(type, id);
        if (reference !=null){
            entityManager.remove(reference);
            entityManager.getTransaction().commit();
        }
    }

    public long count(){
        return 0;
    }

    public List<E> findAllByNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery("Users.FindAll");
        return query.getResultList();
    }

    public long countWithNamedQuery(String queryName){
        var query = entityManager.createNamedQuery(queryName);
        return (long) query.getSingleResult();
    }

}
