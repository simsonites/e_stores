package com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "subtotal", nullable = false, precision = 0)
    private double subtotal;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return quantity == that.quantity &&
                Double.compare(that.subtotal, subtotal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, subtotal);
    }
}
