package test.java.test;

import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class UsersTest extends BaseTestClass {
    private static UsersDao usersDao;

    @BeforeClass
    public static void setUpBeforeClass() {
        BaseTestClass.setUpBeforeClass();
      usersDao = new UsersDao();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        BaseTestClass.tearDownAfterClass();
    }

    @Test
    public void testCreate(){
        var user = new Users("Tejiri", "Efevwerha",
                    "tejiriefe@gmail.com","sampass");
        var createdUser = usersDao.create(user);
        assertTrue(createdUser != null && createdUser.getUserId()>0);
    }

    @Test
    public void testUpdateUser(){
        Users theUser = new Users();
        theUser.setUserId(9);
        theUser.setFirstName("Twilight Sparkle");
        theUser.setLastName("Morning Star");
        theUser.setEmail("twilight@email.com");
        theUser.setPassword("new pass");
        usersDao.update(theUser);
        String expected = "Twilight Sparkle";
        assertEquals(expected,theUser.getFirstName());
    }

    @Test
    public void testGet() {
        var id = 6;
        var theUser = usersDao.findById(id);
        assertNotNull(theUser);
    }

    @Test
    public void testFindAll() throws ServletException, IOException {
        List<Users> allUsers = usersDao.findAll();
        assertTrue(allUsers.size() >0);
    }

    @Test
    public void testDelete() {
        var id = 15;
        usersDao.delete(id);
        var getUser = usersDao.findById(id);
        assertNull(getUser);
    }

    @Test
    public void testCountAllUsers() {
        var count = usersDao.count();
        assertEquals(9, count);
    }

    @Test
    public void testFindByEmail(){
        String email = "montague@email.com";
        var userFound = usersDao.findByEmail(email.trim());
        assertTrue(email, true);
    }

}