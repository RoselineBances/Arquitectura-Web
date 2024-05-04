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
@Table(name = "Reseña")
public class Reseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int coment;
    private int puntuacion;
    @ManyToOne
    @JoinColumn(name = "Cliente_Id")
    private Cliente cliente;

    @JsonIgnore
    @OneToOne(mappedBy = "reseña")
    private ClientexEventoP clienteXEventoP;


    @Override
    public String toString() {
        return "Reseña{" +
                "id=" + id +
                ", Coment='" + coment + '\'' +
                ", Puntuacion='" + puntuacion + '\'' +
                '}';
    }
}