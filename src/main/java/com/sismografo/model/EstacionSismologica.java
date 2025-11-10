import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "estacion_sismologica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionSismologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentoCertificado;
    private Double longitud;
    private Double latitud;
    private String codigoAdquisicion;

    // Relación One-to-Many con Sismografo
    @OneToMany(mappedBy = "estacionSismologica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sismografo> sismografos;
}