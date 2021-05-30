package com.sha.demo.controller;

import com.sha.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author sa
 * @date 16.05.2021
 * @time 19:41
 */
@RestController
@RequestMapping("api/internal")//pre-path
public class InternalApiController
{
    @Autowired
    private IUserService userService;

    @PutMapping("make-admin/{userId}") //api/internal/make-admin/{userId}
    public ResponseEntity<?> makeAdmin(@PathVariable Long userId)
    {
        userService.makeAdmin(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
