package test.java.test;

import main.java.com.softpager.estores.daos.CategoryDAO;
import main.java.com.softpager.estores.entities.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest extends BaseTestClass {
    private static CategoryDAO categoryDAO;

    @BeforeClass
    public static void setUpBeforeClass() {
        BaseTestClass.setUpBeforeClass();
        categoryDAO = new CategoryDAO();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        BaseTestClass.tearDownAfterClass();
    }

    @Test
    public void testCreate(){
        var category =  new Category("Laptop");
        var createdCategory = categoryDAO.create(category);
        assertTrue(createdCategory !=null && createdCategory.getCategoryId() >0);
    }

    @Test
    public void testFindAll(){
        var category = categoryDAO.findAll();
        assert category != null;
        var actual = category.size();
        assertEquals(3, actual);
    }

    @Test
    public void testFindById(){
        var id = 3;
        var category = categoryDAO.findById(id);
        assertTrue(category == null);
    }

    @Test
    public void testDelete(){
        var id = 3;
        categoryDAO.delete(id);
        var deletedCategory = categoryDAO.findById(id);
        assertNull(deletedCategory);
    }

    @Test
    public void testUpdate(){
        var category = new Category();
        category.setCategoryId(11);
        category.setName("Booster");
       var updatedCategory =  categoryDAO.update(category);
       assertEquals("Booster",category.getName());
    }

    @Test
    public void testFindByName(){
        var name = "Mobile";
      var categoryFound = categoryDAO.findByName(name);
      assertTrue(categoryFound!=null);
    }
    @Test
    public void countTest(){
        var count = categoryDAO.count();
        assertEquals(2,count);
    }
}
