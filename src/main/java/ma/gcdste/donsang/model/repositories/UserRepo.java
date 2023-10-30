package ma.gcdste.donsang.model.repositories;

import ma.gcdste.donsang.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findUsersByEmailAndPassword(String email, String password);
    public User findUsersByEmail(String email);
    public List<User> findAll();
    void deleteByEmail(String email);
}
