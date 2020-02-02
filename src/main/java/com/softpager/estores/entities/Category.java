package main.java.com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "name", nullable = false)
    private String name;

    public Category(String name) {
        this.name =name;
    }
    public Category() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }
}
