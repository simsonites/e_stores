package main.java.com.softpager.estores.daos;

import main.java.com.softpager.estores.entities.Users;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersDao extends JpaDao<Users> implements GenericDAO<Users> {

    public UsersDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Users create(Users theUser){
        return super.create(theUser);
    }

    @Override
    public Users update(Users theUser){
        return super.update(theUser);
    }

    @Override
    public Users get(Object id) {
        Users theUser = super.get(Users.class, id);
        return theUser;
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Users.Count");
    }

    @Override
    public List<Users> getAll() {
        return super.findAllByNamedQuery("Users.FindAll");
    }

    @Override
    public void delete(Object id) {
        super.delete(Users.class, id);
    }

    public Users findByEmail(String email){
        return super.findByEmailNamedQuery(email);
    }
}
