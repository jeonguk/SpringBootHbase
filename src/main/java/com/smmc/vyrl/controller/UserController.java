package com.smmc.vyrl.controller;

import com.smmc.vyrl.domain.User;
import com.smmc.vyrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public void createTabel() throws Exception {
        userService.createTable();
    }

    @GetMapping("/save")
    public void save() {
        userService.saveUpdate();
    }

    @GetMapping("{rowkey}")
    public User getUser(final @PathVariable String rowkey) {
        return userService.query(rowkey);
    }
}
