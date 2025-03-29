package co.ucentral.bkedgame.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "equipos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String nombreCorto;
    private LocalDateTime fechaCreacion;

    @OneToOne(cascade = CascadeType.ALL) // Relación 1 a 1
    @JoinColumn(name = "directorTecnico_id") // Llave foránea del DT
    private DirectorTecnico directorTecnico;

}
