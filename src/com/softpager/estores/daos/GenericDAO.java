package com.softpager.estores.daos;

import java.util.List;

public interface GenericDAO<T> {

    T create(T t);
    T update(T t);
    T get(Object id);
    void count();
    List<T> getAll();
    void delete(Object id);
}
