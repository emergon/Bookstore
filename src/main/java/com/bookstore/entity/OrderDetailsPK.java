/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tasos
 */
@Embeddable
public class OrderDetailsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "bid")
    private int bid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boid")
    private int boid;

    public OrderDetailsPK() {
    }

    public OrderDetailsPK(int bid, int boid) {
        this.bid = bid;
        this.boid = boid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBoid() {
        return boid;
    }

    public void setBoid(int boid) {
        this.boid = boid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bid;
        hash += (int) boid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetailsPK)) {
            return false;
        }
        OrderDetailsPK other = (OrderDetailsPK) object;
        if (this.bid != other.bid) {
            return false;
        }
        if (this.boid != other.boid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bookstore.entity.OrderDetailsPK[ bid=" + bid + ", boid=" + boid + " ]";
    }
    
}
