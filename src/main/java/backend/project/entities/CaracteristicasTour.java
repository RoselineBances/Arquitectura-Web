package backend.project.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "caracteristicas_tour")
public class CaracteristicasTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tours_id")
    private Tours tours;
    @ManyToOne
    @JoinColumn(name = "actividad_Fa_id")
    private ActividadesFa actividadesFa;
    @Override
    public String toString() {
        return "Destino{" +
                "id=" + id +
                ", tours='" + tours + '\'' +
                ", actividadesFa='" + actividadesFa + '\'' +
                '}';
    }
}