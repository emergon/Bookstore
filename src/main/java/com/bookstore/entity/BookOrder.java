/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tasos
 */
@Entity
@Table(name = "book_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOrder.findAll", query = "SELECT b FROM BookOrder b")
    , @NamedQuery(name = "BookOrder.findByBoid", query = "SELECT b FROM BookOrder b WHERE b.boid = :boid")
    , @NamedQuery(name = "BookOrder.findByQuantity", query = "SELECT b FROM BookOrder b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "BookOrder.findByOrderDate", query = "SELECT b FROM BookOrder b WHERE b.orderDate = :orderDate")
    , @NamedQuery(name = "BookOrder.findByPaymentMethod", query = "SELECT b FROM BookOrder b WHERE b.paymentMethod = :paymentMethod")
    , @NamedQuery(name = "BookOrder.findByShippingAddress", query = "SELECT b FROM BookOrder b WHERE b.shippingAddress = :shippingAddress")
    , @NamedQuery(name = "BookOrder.findByStatus", query = "SELECT b FROM BookOrder b WHERE b.status = :status")
    , @NamedQuery(name = "BookOrder.findByTotal", query = "SELECT b FROM BookOrder b WHERE b.total = :total")
    , @NamedQuery(name = "BookOrder.findByRecipientName", query = "SELECT b FROM BookOrder b WHERE b.recipientName = :recipientName")
    , @NamedQuery(name = "BookOrder.findByRecipientPhone", query = "SELECT b FROM BookOrder b WHERE b.recipientPhone = :recipientPhone")})
public class BookOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "boid")
    private Integer boid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "recipient_name")
    private String recipientName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "recipient_phone")
    private String recipientPhone;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Customer cid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookOrder")
    private Collection<OrderDetails> orderDetailsCollection;

    public BookOrder() {
    }

    public BookOrder(Integer boid) {
        this.boid = boid;
    }

    public BookOrder(Integer boid, int quantity, Date orderDate, String paymentMethod, String shippingAddress, String status, float total, String recipientName, String recipientPhone) {
        this.boid = boid;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
        this.status = status;
        this.total = total;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
    }

    public Integer getBoid() {
        return boid;
    }

    public void setBoid(Integer boid) {
        this.boid = boid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public Customer getCid() {
        return cid;
    }

    public void setCid(Customer cid) {
        this.cid = cid;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boid != null ? boid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookOrder)) {
            return false;
        }
        BookOrder other = (BookOrder) object;
        if ((this.boid == null && other.boid != null) || (this.boid != null && !this.boid.equals(other.boid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bookstore.entity.BookOrder[ boid=" + boid + " ]";
    }
    
}
