package backend.project.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="caracteristicas_clientes")

public class CaracteristicasCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Cliente_id")
    private int clienteId;

    @Column(name = "actividades_Actividad_Fav")
    private int actividadesActividadFav;

    @Column(name = "Asientos Disponibles")
    private int asientosDisponibles;

    @ManyToOne
    @JoinColumn(name = "Cliente_id", insertable = false, updatable = false)
    private Cliente cliente;
}