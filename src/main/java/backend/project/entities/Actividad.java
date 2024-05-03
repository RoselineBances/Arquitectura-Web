package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Actividad_Fa;

    @JsonIgnore
    @OneToMany(mappedBy = "actividad")
    private List<CaracteristicasCliente> caracteristicasClientes;

    @JsonIgnore
    @OneToMany(mappedBy = "actividad")
    private List<CaracteristicaTours> caracteristicaTours;

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + Actividad_Fa +

                '}';
    }
}