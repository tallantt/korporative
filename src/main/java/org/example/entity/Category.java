
package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Setter
    @Getter
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    public Category(String model){
        this.model = model;
    }
    public Category(long id, String name, String model){
        this.id=id;
        this.name=name;
        this.model = model;
    }
    public Category() {

    }
    public List<Car> getCarlist() {
        return carList;
    }

    @Setter
    @OneToMany(mappedBy = "category")
    private  List<Car> carList;

}
