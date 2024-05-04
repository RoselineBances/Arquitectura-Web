package com.example.proyect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "caracteristicas_tours")
public class CaracteristicasTours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tours_id")
    private Tours tours;
    @ManyToOne
    @JoinColumn(name = "actividad_Fa_id")
    private ActividadesFa actividadesFa;
}
