package test.java;

import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class UsersTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static UsersDao usersDao;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("EStores");
        em = emf.createEntityManager();
        usersDao = new UsersDao(em);
    }

    @Test
    public void testCreate() {
        Users theUser = new Users("Sally", "montague",
                "montague@email.com", "moore");
        var createdUser = usersDao.create(theUser);
        if (createdUser != null) {
            System.out.println("***User created*****");
            System.out.println(createdUser);
        }
        assertNotNull(createdUser);
    }

    @Test
    public void testUpdateUser(){
        Users theUser = new Users();
        theUser.setUserId(9);
        theUser.setFirstName("Twilight");
        theUser.setLastName("Morning Star");
        theUser.setEmail("pinky@email.com");
        theUser.setPassword("new pass");
        usersDao.update(theUser);
        String expected = "new pass";
        assertEquals(expected,theUser.getPassword());
    }

    @Test
    public void testGet() {
        var id = 6;
        var theUser = usersDao.get(id);
        if (theUser != null) {
            System.out.println("User found!  " + theUser);
        }
        assert theUser != null;
        assertEquals(6, theUser.getUserId());
    }

    @Test
    public void testGetAll() {
        var allUsers = usersDao.getAll();
        if (allUsers != null) {
            System.out.println("\n*** Getting all users****");
            allUsers.forEach(System.out::println);
        }
        assertNotNull(allUsers);
    }

    @Test
    public void testDelete() {
        var id = 10;
        usersDao.delete(id);
        var getUser = usersDao.get(id);
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
        assertEquals(8, count);
    }

    @Test
    public void testFindByEmail(){
        String email = "pinky@email.com";
        var theUser = usersDao.findByEmail(email);
        if (theUser != null){
            System.out.println("User found : "+theUser);
        }
        assert theUser != null;
        assertEquals(email, theUser.getEmail());
    }
}