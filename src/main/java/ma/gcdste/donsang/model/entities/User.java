package ma.gcdste.donsang.model.entities;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    //@NotNull(message = "L'email est obligatoire !")
    private String email;
    //@NotNull(message = "L'email est obligatoire")
    private String name;
    //@NotNull(message = "Veuillez entrer votre nom svp")
    private String password;
    //@NotNull(message = "Password est obligatoire !")
    private String groupeSanguin;
    //@NotNull(message = "Le groupe sanguin est obligatoire !")
    private Long age;
    //@NotNull(message = "Votre age est obligatoire !")


    public User(Long id, String email, String name, String password, String type_sang, Long age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.groupeSanguin = type_sang;
        this.age = age;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String type_sang) {
        this.groupeSanguin = type_sang;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
