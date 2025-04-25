package co.ucentral.bkedgame.dto;

import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record EquipoDto(@NotBlank String nombre,
                        String nombreCorto,
                        LocalDateTime fechaCreacion,
                        DirectorTecnico directorTecnico) {
}
