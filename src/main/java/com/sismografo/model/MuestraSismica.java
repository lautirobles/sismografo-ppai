package com.sismografo.model;

import lombok.*;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "muestra_sismica")
public class MuestraSismica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_muestra")
    private LocalDateTime fechaHoraMuestra;

    @OneToMany(mappedBy = "muestraSismica" , fetch = FetchType.LAZY)
    private List<DetalleMuestraSismica> detalleMuestraSismica;
    

    @ManyToOne
    @JoinColumn(name = "serie_temporal", referencedColumnName = "id")
    private SerieTemporal serieTemporal;


    public Map<String, Object> obtenerDatos() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("fechaHoraMuestra", fechaHoraMuestra);

        List<Map<String, Object>> detalles = detalleMuestraSismica.stream()
                .map(DetalleMuestraSismica::getDatos)
                .toList();

        datos.put("detalles", detalles);
        return datos;
    }
}
