package com.techsofin.sdccpayment.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "org_permission", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Permission {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Size(min = 1, max = 80, message = "Name must be populated and no more than 80 characters")
    @Column(name = "name", length = 80, nullable = false, unique = true)
    private String name;

    @Size(min = 1, max = 80, message = "Description must be populated and no more than 80 characters")
    @Column(name = "description", length = 80)
    private String description;

    public Permission() {
    }

    public Permission(Integer id) {
        this.id = id;
    }

    public Permission(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
