package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EventoProgramado")
public class EventoProgramado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date Fecha;
    private int CantPasajeros;
    private double CostoTotal;

    @JsonIgnore
    @OneToMany(mappedBy = "eventoprogramado")
    private List<ClientexEventoP> clienteXEventoPs;

    @ManyToOne
    @JoinColumn(name = "Tours_Id")
    private Tour tour;

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + Actividad_Fa +
                ", Fecha='" + Fecha + '\'' +
                ", CantPasajeros='" + CantPasajeros + '\'' +
                ", CostoTotal='" + CostoTotal + '\'' +
                '}';
    }
}