package test.java.test;

import com.softpager.estores.daos.UserDao;
import com.softpager.estores.entities.Users;
import org.junit.Test;

import javax.persistence.EntityManager;

public class UsersTest {
  private UserDao userDao;
  private EntityManager em;

    @Test
    public void testCreate(){
        Users user = new Users("Mosh", "Hamedani","email.com","pass");
        em.getTransaction().begin();


    }
}
