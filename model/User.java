package model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @Size ( max = 20, message = "username can be not more 20 symbols")
    @NotBlank(message = "usernames field must be filled in")
    private String userName;

    @Column(name = "password")
    @Size (min=6, max = 8, message = "password must be from 6 and before 8 symbols")
    @NotBlank(message = "Passwords field  must be filled in")
    private String password;

    @Transient
    @Size (min=6, max = 8, message = "password must be from 6 and before 8 symbols")
    @NotBlank(message = "Passwords field  must be filled in")
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        if (roles != null){
            return roles;
    }
return new HashSet <>();
}

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", roles=" + roles +
                '}';
    }
}
