package main.java.com.softpager.estores.daos;

import main.java.com.softpager.estores.entities.Category;

import java.util.List;


public class CategoryDAO extends JpaDao<Category>implements GenericDAO<Category> {

   @Override
   public Category create(Category category){
       return super.create(category);
   }

    @Override
    public List<Category> findAll() {
        return super.findWithNamedQuery("Category.findAll");
    }

    @Override
    public Category findById(Object id) {
        return super.findById(Category.class, id);
   }

    @Override
    public Category update(Category category){
        return super.update(category);
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Category.count");
    }

    @Override
    public void delete(Object id) {
       super.delete(Category.class, id);
    }

  public Category findByName(String categoryName){
        var category =super.findWithNamedQuery(
                "Category.findByName","name",categoryName);
        if (category != null && category.size()>0){
            return category.get(0);
        }
        return null;
   }

}
