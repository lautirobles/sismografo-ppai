package com.sismografo.model;

import lombok.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import com.sismografo.dto.DatosSismosDto;

@Entity
@Table(name = "evento_sismico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoSismico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @JoinColumn(name = "fecha_hora_ocurrencia")
    private LocalDateTime fechaHoraOcurrencia;

    @JoinColumn(name = "latitud_epicentro")
    private BigDecimal latitudEpicentro;

    @JoinColumn(name = "longitud_epicentro")
    private BigDecimal longitudEpicentro;

    @JoinColumn(name = "latitud_hipocentro")
    private BigDecimal latitudHipocentro;

    @JoinColumn(name = "longitud_hipocentro")
    private BigDecimal longitudHipocentro;

    @JoinColumn(name = "valor_magnitud")
    private float valorMagnitud;

    private int magnitud;

    @JoinColumn(name = "fecha_hora_revision")
    private LocalDateTime fechaHoraRevision;
    
    @ManyToOne
    @JoinColumn(name = "serie_temporal", referencedColumnName = "id")
    private SerieTemporal serieTemporal;

    @ManyToOne
    @JoinColumn(name = "clasificacion_sismo", referencedColumnName = "id")
    private ClasificacionSismo clasificacionSismo;

    @ManyToOne
    @JoinColumn(name = "alcance_sismico", referencedColumnName = "id")
    private AlcanceSismico alcanceSismico;

    @ManyToOne
    @JoinColumn(name = "origen_generacion", referencedColumnName = "id")
    private OrigenGeneracion origenGeneracion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoSismico",fetch = FetchType.EAGER)
    private List<CambioEstado> cambioEstado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_actual", referencedColumnName = "id")
    private Estado estadoActual;
    

    public void agregarCambioEstado(CambioEstado nuevoCE){
        this.cambioEstado.add(nuevoCE);
    }

    public boolean esAutoDetectado(){
        return this.estadoActual.esAutoDetectado();
    }


    public void bloquearEvSismico(LocalDateTime fechaHoraActual){
        this.estadoActual.bloquearEvento(this, fechaHoraActual);
    }

    public DatosSismosDto buscarDatosSismicos(){
        String alcance = this.getAlcanceSismico().getNombre();
        String clasificacion = this.getClasificacionSismo().getNombre();
        String origen = this.getOrigenGeneracion().getNombre();

        var muestras = this.serieTemporal.obtenerMuestras();

        return new DatosSismosDto(alcance, origen, clasificacion);
    }

    public void confirmarEvento(LocalDateTime fechaHoraActual, Empleado empleado){
        this.estadoActual.confirmarEvento(this, fechaHoraActual, empleado);
    }

    public void rechazarEvento(LocalDateTime fechaHoraActual,Empleado empleado){
        this.estadoActual.rechazarEvento(this, fechaHoraActual, empleado);
    }

    public void solicitarRevisionExperto(LocalDateTime fechaHoraActual, Empleado empleado){
        this.estadoActual.solicitarRevisionExperto(this, fechaHoraActual, empleado);
    }

    
}
