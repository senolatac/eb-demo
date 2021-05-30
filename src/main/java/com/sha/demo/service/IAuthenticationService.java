package com.sha.demo.service;

import com.sha.demo.model.User;

/**
 * @author sa
 * @date 15.05.2021
 * @time 00:10
 */
public interface IAuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
