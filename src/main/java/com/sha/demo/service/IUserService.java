package com.sha.demo.service;

import com.sha.demo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 14.05.2021
 * @time 19:11
 */
public interface IUserService
{
    User saveUser(User user);

    void makeAdmin(Long userId);

    Optional<User> findByUsername(String username);
}
