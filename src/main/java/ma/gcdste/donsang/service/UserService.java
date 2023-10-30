package ma.gcdste.donsang.service;

import jakarta.transaction.Transactional;
import ma.gcdste.donsang.model.entities.User;
import ma.gcdste.donsang.model.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public int addUser(User user){
        if (findUser(user.getEmail(),user.getPassword())==null) {
            userRepo.save(user);
            return 1;
        }
        else{
            return 0;
        }
    }

    public User findUser(String email,String password){
        return userRepo.findUsersByEmailAndPassword(email,password);
    }
    @Transactional
    public void deleteUser(String email){
        userRepo.deleteByEmail(email);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
    }

