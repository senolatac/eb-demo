package com.sha.demo.repository;

import com.sha.demo.model.Role;
import com.sha.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author sa
 * @date 14.05.2021
 * @time 18:46
 */
public interface IUserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role = :role where id = :userId")
    void updateUserRole(@Param("userId") Long userId, @Param("role") Role role);
}
