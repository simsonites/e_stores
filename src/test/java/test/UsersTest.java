package test.java.test;

import com.softpager.estores.daos.UserDao;
import com.softpager.estores.entities.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class UsersTest {
  private static UserDao userDao;
  private static EntityManager em;
  private static EntityManagerFactory emf;

  @BeforeClass
  public static void setUpClass(){
      emf = Persistence.createEntityManagerFactory("EStores");
      em = emf.createEntityManager();
      userDao = new UserDao(em);
  }

    @Test
    public void testCreateUser(){
        Users user = new Users("Annie", "Sam","annie@email.com","pass");
       var createdUser = userDao.create(user);
       var userId = createdUser.getUserId();
       assertNotNull("The user Id is : ",userId);
    }

    @Test
    public void testUpdateUser(){
      Users theUser = new Users();
      theUser.setUserId(4);
      theUser.setFirstName("Mosh");
      theUser.setLastName("Master");
      theUser.setEmail("mosh@email.com");
      theUser.setPassword("password");
      userDao.update(theUser);
      String expected = "password";
      assertEquals(expected,theUser.getPassword());
    }

    @Test
    public void testGetUser(){
      Object id = 4;
     var user =  userDao.get(id);
     if (user != null){
         System.out.println(user.getEmail());
     }
     assertNotNull(user);
    }
    @Test
    public void testDeleteUser(){
      var id = 5;
      userDao.delete(id);
      var getUser = userDao.get(id);
      if (getUser == null){
          System.out.println("User not found");
      }
      assertNull(getUser);
    }

    @Test
    public void testCountAllUsers(){
     var count =  userDao.count();
     if (count > 0){
         System.out.println("There are  "+count+"  user in the database" );
     }
     assertNotNull(count);
    }

    @Test
    public void testGetAllUsers(){
      var usersList = userDao.getAll();
      if (usersList != null){
          usersList.forEach(System.out::println);
      }
      assertNotNull(usersList);
    }

    @AfterClass
    public static void tearDownClass(){
      em.close();
      emf.close();
    }

}
