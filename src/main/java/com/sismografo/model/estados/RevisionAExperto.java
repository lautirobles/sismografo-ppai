package com.sismografo.model.estados;

import com.sismografo.model.Estado;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RevisionAExperto")
public class RevisionAExperto extends Estado {
    
}
