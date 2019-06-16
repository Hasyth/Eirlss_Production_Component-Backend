package com.apiit.eirlss.productioncomponent.eirlss_production.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name="order_item_id")
    private String orderItem_ID;

    @Column(name="quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "orderItems")
    @JsonIgnoreProperties("orderItems")
    private Set<WorkSchedule> workSchedules;

    @OneToMany(mappedBy = "orderItems")
    @JsonIgnoreProperties("orderItems")
    private Set<RejectionNotice> rejectionNotices;


    @ManyToOne
    @JoinColumn
    private SalesOrder salesOrders;

    @ManyToOne
    @JoinColumn
    private Product products;

    public String getOrderItem_ID() {
        return orderItem_ID;
    }

    public void setOrderItem_ID(String orderItem_ID) {
        this.orderItem_ID = orderItem_ID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SalesOrder getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(SalesOrder salesOrders) {
        this.salesOrders = salesOrders;
    }
}