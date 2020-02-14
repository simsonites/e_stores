package test.java;

import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;
import main.java.com.softpager.estores.services.UserService;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class UsersTest {

  private static EntityManagerFactory emf;
    private static EntityManager em;
    private static UsersDao usersDao;
    private static UserService userService;
    private static HttpServletRequest request;
    private static HttpServletResponse response;

    @BeforeClass
    public static void setUpClass() {
      emf = Persistence.createEntityManagerFactory("EStores");
      em = emf.createEntityManager();
      usersDao = new UsersDao();
      userService = new UserService(request, response);
    }

    @Test
    public void testCreate(){

    }

    @Test
    public void testUpdateUser(){
        Users theUser = new Users();
       /* theUser.setUserId(9);
        theUser.setFirstName("Twilight Sparkle");
        theUser.setLastName("Morning Star");
        theUser.setEmail("twilight@email.com");
        theUser.setPassword("new pass");*/
        usersDao.update(theUser);
        String expected = "Twilight Sparkle";
        assertEquals(expected,theUser.getFirstName());
    }

    @Test
    public void testGet() {
        var id = 6;
        var theUser = usersDao.find(id);
        if (theUser != null) {
            System.out.println("User found!  " + theUser);
        }
        assertNotNull(theUser);
    }

    @Test
    public void testFindAll() {
        var allUsers = userService.findAll();
        if (allUsers != null) {
            System.out.println("\n*** Getting all users****");
            allUsers.forEach(System.out::println);
        }
        assertNotNull(allUsers);
    }

    @Test
    public void testDelete() {
        var id = 15;
        usersDao.delete(id);
        var getUser = usersDao.find(id);
        if (getUser == null) {
            System.out.println("User not found");
        }
        assertNull(getUser);
    }

    @Test
    public void testCountAllUsers() {
        var count = usersDao.count();
        if (count > 0) {
            System.out.println("There are  " + count + "  user in the database");
        }
        assertEquals(9, count);
    }

    @Test
    public void testFindByEmail(){
        String email = "montague@email.com";
        var userFound = usersDao.findByEmail(email.trim());
        if (userFound){
            System.out.println("User found : "+ true);
        }
        assertTrue(email, true);
    }
}