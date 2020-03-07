package main.java.com.softpager.estores.daos;

import java.util.List;

public interface GenericDAO<E> {

    E create(E e);
    E update(E e);
    E findById(Object id);
    long count();
    List<E> findAll();
    void delete(Object id);
}
