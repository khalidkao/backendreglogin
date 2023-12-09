package ma.gcdste.donsang.controller;

import ma.gcdste.donsang.model.entities.User;
import ma.gcdste.donsang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
//@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findUser")
    public User findUser(@RequestBody User user){
        return userService.findUser(user);
    }
    @GetMapping("/listByBloodType/{blood_type}")
    public List<User> listUsersByBloodType(@PathVariable("blood_type") String groupe_sanguin){
        return userService.listByBloodType(groupe_sanguin);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/login/{email}/{password}")
    public int find(@PathVariable("email")String email,@PathVariable("password")String password){
        if(userService.findUserByEmailAndPassword(email, password)==null)
            return 0;
        else return 1;
    }

    @PostMapping("/register")
    public int register(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/findUserByName/{nom}")
    public User findUserByName(@PathVariable("nom") String nom){
        return userService.findUserByName(nom);
    }

    @DeleteMapping("/deleteUser/{email}")
    public void delete(@PathVariable String email){
        userService.deleteUser(email);
    }
}
