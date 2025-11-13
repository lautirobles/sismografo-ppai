package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("RevisionAExperto")
@NoArgsConstructor
@Builder
public class RevisionAExperto extends Estado {
    
    public RevisionAExperto(String nombre){
        super(nombre);
    }
}
