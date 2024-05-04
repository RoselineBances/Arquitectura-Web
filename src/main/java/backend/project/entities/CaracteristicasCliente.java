package backend.project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="caracteristicas_clientes")

public class CaracteristicasCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "Cliente_id")
    private int clienteId;


    @ManyToOne
    @JoinColumn(name = "actividades_Actividad_Fav", insertable = false, updatable = false)
    private ActividadesFa actividadFa;
}