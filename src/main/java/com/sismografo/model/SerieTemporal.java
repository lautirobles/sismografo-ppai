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
@Table(name = "detalle_muestra_sismica")
public class SerieTemporal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_registro")
    private LocalDateTime fechaHoraRegistro;

    @OneToMany(mappedBy = "serieTemporal", fetch = FetchType.LAZY)
    private List<MuestraSismica> muestrasSismicas;
    


    public Map<String, Object> obtenerMuestras() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("fechaHoraRegistro", fechaHoraRegistro);
        List<Map<String, Object>> muestras = muestrasSismicas.stream()
                .map(MuestraSismica::obtenerDatos)
                .toList();

        datos.put("muestras", muestras);
        return datos;
    }
}
