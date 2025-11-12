package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Rechazado")
@NoArgsConstructor
public class Rechazado extends Estado {


    public Rechazado(String nombre){
        super(nombre);
    }
    
}
