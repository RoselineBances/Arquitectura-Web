package backend.project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="clientesxeventosp")

public class ClientexEventoP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AsientosDisponibles")
    private int AsientosDisponibles;

    @Column(name = "asistencia")
    private boolean asistencia;

    @ManyToOne
    @JoinColumn(name = "Cliente_id", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "EventoProgramado_", insertable = false, updatable = false)
    private EventoProgramado eventoProgramado;

}