package main.java.com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Data
@Entity
@Table(name = "product_order")
public class ProductOrder {
    @Id
    @GeneratedValue
    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(name = "recipient_phone", nullable = false)
    private String recipientPhone;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "total", nullable = false, precision = 0)
    private double total;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id",
            referencedColumnName = "customer_id", nullable = false)
    private Customer customer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrder)) return false;
        ProductOrder that = (ProductOrder) o;
        return orderId == that.orderId &&
                customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer);
    }
}
