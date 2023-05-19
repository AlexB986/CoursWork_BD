package pojo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usersId;

    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = " user_role")
    private Integer userRole;
    @Column(name = "dt_creation")
    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Role role;


    public Users() {
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
//        this.dateTimeCreate = LocalDateTime.now();
//        this.localTime = localTime;
    }

    public Users(String name, String login, String password, Integer userRole,Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.role= role;
//        this.dateTimeCreate = LocalDateTime.now();
//        this.localTime = localTime;

    }

    public Users(Integer usersId, String name, String login, String password, Integer userRole) {
        this.usersId = usersId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
//        this.dateTimeCreate = LocalDateTime.now();
//        this.localTime = localTime;
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
                "usersId=" + usersId +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
