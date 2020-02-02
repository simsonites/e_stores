package main.java.com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "review")
public class Review {
    private int reviewId;
    private int rating;
    private String headline;
    private String comment;
    private Timestamp reviewTime;
    private Product product;
    private Customer customer;

    public Review() {}


    @Id
    @GeneratedValue
    @Column(name = "review_id", nullable = false)
    public int getReviewId() {
        return reviewId;
    }

    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    @Column(name = "headline", nullable = false, length = 128)
    public String getHeadline() {
        return headline;
    }

    @Column(name = "comment", nullable = false, length = 500)
    public String getComment() {
        return comment;
    }

    @Column(name = "review_time", nullable = false)
    public Timestamp getReviewTime() {
        return reviewTime;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getReviewId() == review.getReviewId() &&
                getProduct().equals(review.getProduct()) &&
                getCustomer().equals(review.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), getProduct(), getCustomer());
    }
}
