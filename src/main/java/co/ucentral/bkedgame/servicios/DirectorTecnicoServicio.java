package co.ucentral.bkedgame.servicios;

import co.ucentral.bkedgame.dto.DirectorTecnicoDto;
import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import co.ucentral.bkedgame.persistencia.repositorios.DirectorTecnicoRepositorio;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class DirectorTecnicoServicio {
    DirectorTecnicoRepositorio directorTecnicoRepositorio;

    public DirectorTecnico crear(DirectorTecnicoDto directorTecnicoDto) {
        DirectorTecnico directorTecnico = DirectorTecnico.builder()
                .nombreCompleto(directorTecnicoDto.nombreCompleto())
                .nacionalidad(directorTecnicoDto.nacionalidad())
                .disponible(false)
                .build();
        return directorTecnicoRepositorio.save(directorTecnico);
    }
    public List<DirectorTecnico> obtenerTodos() {
        return directorTecnicoRepositorio.findAll();
    }
    public DirectorTecnicoDto autenticar(DirectorTecnicoDto directorTecnicoDto) {
        Optional<DirectorTecnico> optional = this.directorTecnicoRepositorio.findByUsuario(directorTecnicoDto.usuario());
        if (optional.isPresent() && optional.get().getClave().equals(directorTecnicoDto.clave())) {

            return new DirectorTecnicoDto(
                    optional.get().getNombreCompleto(),
                    optional.get().getNacionalidad(),
                    optional.get().getUsuario(),
                    optional.get().getClave());
        }else
            return null;

    }

}
