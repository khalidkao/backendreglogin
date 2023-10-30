package ma.gcdste.donsang.controller;

import ma.gcdste.donsang.model.entities.User;
import ma.gcdste.donsang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findUser/{email}/{password}")
    public User findUser(@PathVariable("email") String email, @PathVariable("password")String password){
        return userService.findUser(email,password);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAllUsers();
    }

    @PostMapping("/register")
    public int register(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{email}")
    public void delete(@PathVariable String email){
        userService.deleteUser(email);
    }
}
