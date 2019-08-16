package com.techsofin.sdccpayment.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "org_user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"org_user_id", "org_role_id"}))
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "org_user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "org_role_id", nullable = false)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
