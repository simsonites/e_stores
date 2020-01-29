package com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    private int customerId;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String password;
    private Timestamp registerDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }

    @Column(name = "phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    @Column(name = "zipcode", nullable = false)
    public String getZipcode() {
        return zipcode;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "register_date", nullable = false)
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() &&
                getEmail().equals(customer.getEmail()) &&
                getPhone().equals(customer.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getEmail(), getPhone());
    }
}
