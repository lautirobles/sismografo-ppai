package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PendienteDeRevision")
public class PendienteDeRevision extends Estado {
    
}
