package com.techsofin.sdccpayment.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "org_collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double amount;

    @Column
    private Date colectionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getColectionDate() {
        return colectionDate;
    }

    public void setColectionDate(Date colectionDate) {
        this.colectionDate = colectionDate;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", amount=" + amount +
                ", colectionDate=" + colectionDate +
                '}';
    }
}
