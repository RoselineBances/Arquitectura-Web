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
@Table(name="clientes")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<CaracteristicasCliente> caracteristicasClientes;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<ClientexEventoP> clientexEventoPS;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Reseña> reseñas;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario usuario;
}