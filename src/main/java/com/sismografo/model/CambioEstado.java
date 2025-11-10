import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cambio_estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    // Relación Many-to-One con EventoSismico
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_sismico_id", nullable = false)
    private EventoSismico eventoSismico;

    // Estado desde el que se cambió
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_actual_id", nullable = false)
    private Estado estadoActual;

    // Estado al que se cambió
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_siguiente_id")
    private Estado estadoSiguiente;
}