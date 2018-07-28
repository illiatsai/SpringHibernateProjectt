package by.htp.main.entity;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_role", nullable = false)
    private int id;

    @Column(name="role", nullable = false)
    private String role;

    public Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
