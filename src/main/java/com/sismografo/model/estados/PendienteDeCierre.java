package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PendienteDeCierre")
public class PendienteDeCierre extends Estado {
    
}
