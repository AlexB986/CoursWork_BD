package pojo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "role")
    private String role;
    @Column(name = "dt_update")
    private LocalDateTime dateTimeUpdate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Users> usersList;

    public Role() {
        this.role = role;
        this.dateTimeUpdate = LocalDateTime.now();
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
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                ", dateTimeUpdate=" + dateTimeUpdate +
                ", usersList=" + usersList +
                '}';
    }
}
