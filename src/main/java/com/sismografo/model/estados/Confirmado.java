package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Confirmado")
public class Confirmado extends Estado {
    
}
