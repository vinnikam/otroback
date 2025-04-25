package co.ucentral.bkedgame.servicios;

import co.ucentral.bkedgame.dto.DirectorTecnicoDto;
import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import co.ucentral.bkedgame.persistencia.repositorios.DirectorTecnicoRepositorio;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class DirectorTecnicoServicio {
    private static final Logger log4jLog = LogManager.getLogger(DirectorTecnicoServicio.class);

    DirectorTecnicoRepositorio directorTecnicoRepositorio;
    BCryptPasswordEncoder passwordEncoder;
    public DirectorTecnico crear(DirectorTecnicoDto directorTecnicoDto) {
        DirectorTecnico directorTecnico = DirectorTecnico.builder()
                .nombreCompleto(directorTecnicoDto.nombreCompleto())
                .nacionalidad(directorTecnicoDto.nacionalidad())
                .usuario(directorTecnicoDto.usuario())
                .clave(passwordEncoder.encode(directorTecnicoDto.clave()))
                .disponible(false)
                .build();
        return directorTecnicoRepositorio.save(directorTecnico);
    }
    public List<DirectorTecnico> obtenerTodos() {
        return directorTecnicoRepositorio.findAll();
    }
    public DirectorTecnicoDto autenticar(DirectorTecnicoDto directorTecnicoDto) {
        Optional<DirectorTecnico> optional = this.directorTecnicoRepositorio.findByUsuario(directorTecnicoDto.usuario());
        log4jLog.info("Verificando ");
        log4jLog.debug("message {}", 1);

        log4jLog.log(Level.DEBUG," Esto es un mensaje {}", optional.get().getClave());
        if (optional.isPresent() && optional.get().getClave().equals(directorTecnicoDto.clave())) {
            return new DirectorTecnicoDto(
                    optional.get().getNombreCompleto(),
                    optional.get().getNacionalidad(),
                    optional.get().getUsuario(),
                    "");
        }else
            return null;

    }
    public DirectorTecnicoDto autenticar2(DirectorTecnicoDto directorTecnicoDto) {
        Optional<DirectorTecnico> optional =
                this.directorTecnicoRepositorio.findByUsuarioAndClave(directorTecnicoDto.usuario(), directorTecnicoDto.clave());
        if (optional.isPresent() ) {
            return new DirectorTecnicoDto(
                    optional.get().getNombreCompleto(),
                    optional.get().getNacionalidad(),
                    optional.get().getUsuario(),
                    "");
        }else
            return null;

    }

}
