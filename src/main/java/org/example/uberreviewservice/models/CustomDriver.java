package org.example.uberreviewservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CustomDriver {
    private Long id;
    private String name;

    public CustomDriver(long id,String name){
        this.id=id;
        this.name=name;
    }

}
