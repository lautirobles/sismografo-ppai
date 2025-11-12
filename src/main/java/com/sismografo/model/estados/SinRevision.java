package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SinRevision")
public class SinRevision extends Estado{
    
}
