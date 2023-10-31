package ma.gcdste.donsang.service;

import com.google.common.hash.Hashing;
import jakarta.transaction.Transactional;
import ma.gcdste.donsang.model.entities.User;
import ma.gcdste.donsang.model.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public int addUser(User user){
        String hashedPassword = Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString();
        user.setPassword(hashedPassword);
        if (findUser(user)==null) {
            userRepo.save(user);
            return 1;
        }
        else{
            return 0;
        }
    }

    public User findUser(User user){
        return userRepo.findUserByEmail(user.getEmail());
    }
    public List<User> listByBloodType(String groupe_sanguin){
        return userRepo.findUsersByGroupeSanguin(groupe_sanguin);
    }
    @Transactional
    public void deleteUser(String email){
        userRepo.deleteByEmail(email);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
    }

