package com.sistemamonitoreovigilanciasaludpublica.pe;

// OBJETOS LEIDOS DESDE LA DDBB
/*
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MortalityRate {
    private int id;
    private int year;
    private String department;
    private String gender;
    private String disease;
    private int numberDeath;
    private float grossRate;
    private float adjusmentRate;
    private float error;
    private float lowerLimit;
    private float upperLimit;
    private int cluster;
    private String createdAt;
    private String updatedAt;
}
*/

// PARA LA LECTURA DEL ARCHIVO CSV SE MODIFICA LA CLASE
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MortalityRate {
    private int year;
    private String department;
    private String gender;
    private String disease;
    private int numberDeath;
    private float grossRate;
    private float adjusmentRate;
    private float error;
    private float lowerLimit;
    private float upperLimit;
    private int cluster;
}