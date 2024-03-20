
package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Table(name = "cars")
@Entity
public class Car {
    @Getter
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Getter
    @Column(name = "name")
    private String CarName;
    @Column(name = "year")
    @Getter
    private Integer year;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cat_id")
    private Category category;
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", carName='" + CarName + '\'' +
                '}';
    }
}
