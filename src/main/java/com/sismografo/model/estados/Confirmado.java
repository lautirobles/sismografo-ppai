package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("Confirmado")
@NoArgsConstructor
@Builder
public class Confirmado extends Estado {
    public Confirmado(String nombre){
        super(nombre);
    }
}
