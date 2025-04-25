package co.ucentral.bkedgame.servicios;

import co.ucentral.bkedgame.dto.EquipoDto;
import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.persistencia.repositorios.EquipoRepositorio;
import lombok.AllArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class EquipoServicio {

    EquipoRepositorio equipoRepositorio;

    public List<Equipo> obtenerTodos()
    {
        return equipoRepositorio.findAll();
    }

    public EquipoDto crear(EquipoDto equipoDto){


        Equipo equipo = Equipo.builder()
                .nombre(equipoDto.nombre())
                .nombreCorto(equipoDto.nombreCorto())
                .fechaCreacion(equipoDto.fechaCreacion())
                .build();
        if (equipoDto.directorTecnico() != null){
            DirectorTecnico directorTecnico = DirectorTecnico.builder()
                    .nombreCompleto(equipoDto.directorTecnico().getNombreCompleto())
                    .nacionalidad(equipoDto.directorTecnico().getNacionalidad())
                    .fechaIngreso(LocalDateTime.now())
                    .disponible(false)
                    .build();
            equipo.setDirectorTecnico(directorTecnico);
        }
        if (equipoRepositorio.save(equipo).getId() > 0)
            return equipoDto;
        else return null;

    }
    public Equipo obtenerXNombre(String nombre){
        return  equipoRepositorio.findByNombre(nombre);
    }
    public Equipo obtenerXPK(Long pk){
        /*Optional<Equipo> equipo =  equipoRepositorio.findById(pk);
        if (equipo.isPresent())
            return equipo.get();
        return null;*/
        return equipoRepositorio.findById(pk).orElseThrow(null);
    }



}
