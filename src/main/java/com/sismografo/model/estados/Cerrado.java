package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Cerrado")
public class Cerrado extends Estado{
    
}
