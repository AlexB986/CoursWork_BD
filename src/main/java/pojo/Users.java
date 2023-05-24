package pojo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
public class Users {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer users_Id;

    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "user_role")
    private Integer userRole;
    @Column(name = "dt_creation")
    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToMany()
    private  Set<Role>roleSet = new HashSet<>();

    public Users() {
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.roleSet = roleSet;
    }



    public Users(String name, String login, String password, Integer userRole) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.roleSet = roleSet;

    }


    public Users(Integer users_Id, String name, String login, String password, Integer userRole) {
        this.users_Id = users_Id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.roleSet = roleSet;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Users{" +
                "users_Id=" + users_Id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", localDateTime=" + localDateTime +
                ", roleSet=" + roleSet +
                '}';
    }
}
