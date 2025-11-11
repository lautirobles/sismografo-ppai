package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AutoConfirmado")
public class AutoConfirmado extends Estado {
    
}
