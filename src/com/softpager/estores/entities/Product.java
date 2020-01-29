package com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "product")
public class Product {
    private int productId;
    private String name;
    private String description;
    private byte[] image;
    private double price;
    private Category category;


    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    @Column(name = "image", nullable = false)
    public byte[] getImage() {
        return image;
    }

    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId() &&
                getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName());
    }
}
