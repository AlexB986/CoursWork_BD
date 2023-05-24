package pojo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_Id;
    @Column(name = "role")
    private String role;
    @Column(name = "dt_update")
    @CreationTimestamp
    private LocalDateTime dateTimeUpdate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_Id")}
    )
    Set<Users> usersHashSet = new HashSet<>();

    public Role() {
        this.role = role;
    }


    public Role(String role) {
        this.role = role;
    }

    public Role(Set<Users> usersHashSet) {
        this.usersHashSet = usersHashSet;
    }

    public String getRole() {
        return this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getDateTimeUpdate() {
        return dateTimeUpdate;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_Id=" + role_Id +
                ", role='" + role + '\'' +
                ", dateTimeUpdate=" + dateTimeUpdate +
                ", usersHashSet=" + usersHashSet +
                '}';
    }
}
