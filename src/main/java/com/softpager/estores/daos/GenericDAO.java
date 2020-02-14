package main.java.com.softpager.estores.daos;

import java.util.List;

public interface GenericDAO<T> {

    T create(T t);
    T update(T t);
    T find(Object id);
    long count();
    List<T> findAll();
    void delete(Object id);
}
