package backend.project.entities;


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

    @Column(name = "cliente_id")
    private int cliente_id;

    @Column(name = "evento_programado")
    private String eventoProgramado;

    @Column(name = "asientos_disponibles")
    private int AsientosDisponibles;

    @Column(name = "asistencia")
    private boolean Asistencia;

    @ManyToOne
    @JoinColumn(name = "cliente_id", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "evento_programado", insertable = false, updatable = false)
    private EventoProgramado eventoProgramado;


}