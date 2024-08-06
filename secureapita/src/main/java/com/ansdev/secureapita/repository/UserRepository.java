package com.ansdev.secureapita.repository;

import com.ansdev.secureapita.domain.User;

import java.util.Collection;

public interface UserRepository <T extends User> {
    /*Basic Crud operations*/
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /*More Complex Crud operations*/

}
