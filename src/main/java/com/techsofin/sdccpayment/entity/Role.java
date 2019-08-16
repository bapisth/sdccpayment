package com.techsofin.sdccpayment.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "org_role", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Size(min = 1, max = 80, message = "Name must be populated and no more than 80 characters")
    @Column(name = "name", length = 80)
    private String name;

    @Size(min = 1, max = 80, message = "Description must be populated and no more than 80 characters")
    @Column(name = "description", length = 80)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", length = 19)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified", length = 19)
    private Date lastModified;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<RolePermission> rolePermissions = new HashSet<RolePermission>(0);

    @PrePersist
    public void createdAtTrigger() {
        Date now = new Date();
        this.createdOn = now;
        this.lastModified = now;
    }

    @PreUpdate
    public void updatedAtTrigger() {
        Date now = new Date();
        if (this.createdOn == null) {
            this.createdOn = now;
        }
        this.lastModified = now;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Set<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
