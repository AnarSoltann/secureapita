package com.ansdev.secureapita.repository;

import com.ansdev.secureapita.domain.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role> {
    /*Basic Crud operations*/
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /*More Complex Crud operations*/
    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByUserEmail(String email);
    void updateUserRole(Long userId, String roleName);

}