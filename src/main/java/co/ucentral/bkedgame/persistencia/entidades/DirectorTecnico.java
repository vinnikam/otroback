package co.ucentral.bkedgame.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "directores_tecnicos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DirectorTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombreCompleto;

    private String nacionalidad;
    private LocalDateTime fechaIngreso;
    private boolean disponible;


}
