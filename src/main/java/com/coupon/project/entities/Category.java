package com.coupon.project.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private int id;
     private String name;

     public Category() {}
     public Category(String name) {
          this.name = name;
     }
     public Category(int id, String name) {
          this.id = id;
          this.name = name;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Category category = (Category) o;
          return id == category.id;
     }

     @Override
     public int hashCode() {
          return Objects.hash(id);
     }

     @Override
     public String toString() {
          return "Category{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  '}';
     }
}
