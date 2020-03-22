package main.java.com.softpager.estores.daos;

import main.java.com.softpager.estores.entities.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Users findById(Object id) {
        Users theUser = super.findById(Users.class, id);
        return theUser;
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Users.Count");
    }

    @Override
    public List<Users> findAll() {
        return super.findWithNamedQuery(
                "Users.FindAll");
    }

    @Override
    public void delete(Object id) {
        super.delete(Users.class, id);
    }

    public Users findByEmail(String email){
      var foundUser = super.findWithNamedQuery(
              "Users.findByEmail","email",email);
      if (foundUser != null){
          return foundUser.get(0);
      }
      return null;
    }

    public boolean checkLogin(String email, String password){
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("email", email);
        loginInfo.put("password", password);
        List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", loginInfo);

        if (listUsers.size() == 1) {
            return true;
        }
        return false;
    }

}
