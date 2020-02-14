package main.java.com.softpager.estores.daos;

import main.java.com.softpager.estores.entities.Users;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersDao extends JpaDao<Users> implements GenericDAO<Users> {

    public UsersDao() {}

    @Override
    public Users create(Users theUser){
        return super.create(theUser);
    }

    @Override
    public Users update(Users theUser){
        return super.update(theUser);
    }

    @Override
    public Users find(Object id) {
        Users theUser = super.find(Users.class, id);
        return theUser;
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Users.Count");
    }

    @Override
    public List<Users> findAll() {
        return super.findByNamedQuery(
                "Users.FindAll");
    }

    @Override
    public void delete(Object id) {
        super.delete(Users.class, id);
    }

    public boolean findByEmail(String email){
      var foundUser = super.findByNamedQuery("Users.findByEmail",
                            "email",email);
      if (foundUser != null){
          return true;
      }
      return false;
    }

}
