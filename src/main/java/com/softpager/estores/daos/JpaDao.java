package main.java.com.softpager.estores.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JpaDao<E> {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("EStores");
    }

    public JpaDao() {}

    public E create(E entity){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E update(E entity){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E find(Class<E> type, Object id){
     EntityManager entityManager = emf.createEntityManager();
     var entity =  entityManager.find(type, id);
     if (entity != null){
         entityManager.refresh(entity);
     }
        return entity;
    }

    public void delete(Class<E> type, Object id){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        var reference = entityManager.getReference(type, id);
        if (reference !=null){
            entityManager.remove(reference);
            entityManager.getTransaction().commit();
        }
    }

    public List<E> findByNamedQuery(String queryName){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }

    public List<E> findByNamedQuery(String queryName, String paramName,
                                    Object paramValue){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        return query.getResultList();
    }

    public long countWithNamedQuery(String queryName){
        EntityManager entityManager = emf.createEntityManager();
        var query = entityManager.createNamedQuery(queryName);
        return (long) query.getSingleResult();
    }

}
