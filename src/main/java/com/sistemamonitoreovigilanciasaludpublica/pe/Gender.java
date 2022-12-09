package com.sistemamonitoreovigilanciasaludpublica.pe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Gender {
    private int id;
    private String name;
    private String createdAt;
    private String updatedAt;

}
