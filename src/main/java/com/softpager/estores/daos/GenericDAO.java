package main.java.com.softpager.estores.daos;

import java.util.List;

public interface GenericDAO<T> {

    T create(T t);
    T update(T t);
    T get(Object id);
    long count();
    List<T> getAll();
    void delete(Object id);
}
