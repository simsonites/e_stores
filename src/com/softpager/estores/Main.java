package com.softpager.estores;

import com.softpager.estores.entities.Category;
import com.softpager.estores.entities.Users;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Users theUser = new Users("Sam","Morris","email@email.com","password");
        Category c = new Category("Mobile");
    var emf =  Persistence.createEntityManagerFactory("EStores");
     var em = emf.createEntityManager();

     em.getTransaction().begin();
     em.persist(c);
     em.getTransaction().commit();
     em.close();
     emf.close();
        System.out.println("Done....");
    }
}
