package com.example.netflixprojext.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getAll();

    T add(T dto);

    T getById(Long id);

    T removeById(Long id);


}
