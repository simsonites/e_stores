package test.java.test;

import main.java.com.softpager.estores.daos.CategoryDAO;
import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.services.CategoryService;
import main.java.com.softpager.estores.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class BaseTestClass {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;


    public static void setUpBeforeClass() {
        emf = Persistence.createEntityManagerFactory("EStores");
        em = emf.createEntityManager();
    }

    public static void tearDownAfterClass(){
        em.close();
        emf.close();
    }
}
