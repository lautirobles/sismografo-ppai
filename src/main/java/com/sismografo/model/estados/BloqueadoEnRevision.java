package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BloqueadoEnRevision")
public class BloqueadoEnRevision extends Estado {
    
    public BloqueadoEnRevision(String nombre){
        super(nombre);
    }


}
