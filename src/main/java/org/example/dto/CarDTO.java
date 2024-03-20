
package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {

    private String name;
    private Integer year;
    private Long category;


    public CarDTO(String name){
        this.name=name;
    }
}
