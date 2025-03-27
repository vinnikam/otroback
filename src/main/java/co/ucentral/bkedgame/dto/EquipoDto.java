package co.ucentral.bkedgame.dto;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record EquipoDto(@NotBlank String nombre, String nombreCorto, LocalDateTime fechaCreacion) {
}
