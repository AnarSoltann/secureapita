package com.ansdev.secureapita.repository.implementation;

import com.ansdev.secureapita.domain.Role;
import com.ansdev.secureapita.exception.ApiException;
import com.ansdev.secureapita.mapper.RoleRowMapper;
import com.ansdev.secureapita.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import static java.util.Map.of;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static com.ansdev.secureapita.enumeration.RoleType.ROLE_USER;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository<Role> {

    private static final String INSERT_ROLE_TO_USER_QUERY ="" ;
    private static final String SELECT_ROLE_BY_NAME_QUERY ="" ;
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public Role create(Role data) {
        return null;
    }

    @Override
    public Collection list(int page, int pageSize) {
        return List.of();
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Role update(Role data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public void addRoleToUser(Long userId, String roleName) {
        log.info("Adding role to user with userId: {} and roleName: {}", userId, roleName);
        try {
            Role role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, of("roleName", roleName), new RoleRowMapper());
            jdbc.update(INSERT_ROLE_TO_USER_QUERY, of("userId", userId, "roleId",requireNonNull(role).getId()));
        } catch (EmptyResultDataAccessException e) {
            throw new ApiException("No role found by name: " + ROLE_USER.name());
        } catch (Exception e) {
            throw new ApiException("An error occurred while creating user");
        }

    }

    @Override
    public Role getRoleByUserId(Long userId) {
        return null;
    }

    @Override
    public Role getRoleByUserEmail(String email) {
        return null;
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {

    }
}
