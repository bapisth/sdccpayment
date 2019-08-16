package com.techsofin.sdccpayment.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "org_role_permission",
        uniqueConstraints = @UniqueConstraint(columnNames = {"org_role_id", "org_permission_id"})
)
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "org_role_id", nullable = false)
    private Role role;

    @Column(name = "deny_flag", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean denyFlag;

    @ManyToOne(optional = false)
    @JoinColumn(name = "org_permission_id", nullable = false)
    private Permission permission;

    public RolePermission() {
    }

    public RolePermission(RolePermission other) {
        permission = other.getPermission();
        role = null;
        denyFlag = other.isDenyFlag();
    }

    public RolePermission(Role role, Permission permission, boolean denyFlag) {
        this.role = role;
        this.permission = permission;
        this.denyFlag = denyFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isDenyFlag() {
        return denyFlag;
    }

    public void setDenyFlag(boolean denyFlag) {
        this.denyFlag = denyFlag;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
