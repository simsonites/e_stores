package main.java.com.softpager.estores.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public E findById(Class<E> type, Object id){
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

    public List<E> findWithNamedQuery(String queryName){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }

    public List<E> findWithNamedQuery(String queryName, String paramName,
                                      Object paramValue){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        List<E> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public long countWithNamedQuery(String queryName){
        EntityManager entityManager = emf.createEntityManager();
        var query = entityManager.createNamedQuery(queryName);
        long singleResult = (long) query.getSingleResult();
        entityManager.close();
        return singleResult;
    }

    public List<E> findWithNamedQuery(String queryName,
                                      Map<String, Object> userInfo) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        Set<Map.Entry<String, Object>> setParameters = userInfo.entrySet();
        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List<E> result = query.getResultList();
        entityManager.close();
        return result;
    }

}
