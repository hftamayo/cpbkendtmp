package com.example.restservice.controllers;

import com.example.restservice.dao.UserDao;
import com.example.restservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable int id){
        return userDao.getUserById(id);
    }

    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/users",method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.createUser(user);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "api/users",method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.updateUser(user);
    }

    @RequestMapping(value = "api/users/{email}",method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable String email){
        return userDao.getUserByEmail(email);
    }

}
