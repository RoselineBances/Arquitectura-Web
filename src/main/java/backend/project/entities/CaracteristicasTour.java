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
    @JoinColumn(name = "Tours_Id")
    private Tours tours;
    @ManyToOne
    @JoinColumn(name = "actividades_Actividad_F")
    private ActividadesFa actividadesFa;
    @Override
    public String toString() {
        return "CaracteristicaTours{" +
                "id=" + id +
                ", tours='" + tours + '\'' +
                ", actividadesFa='" + actividadesFa + '\'' +
                '}';
    }
}