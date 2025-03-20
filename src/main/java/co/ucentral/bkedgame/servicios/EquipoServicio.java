package co.ucentral.bkedgame.servicios;

import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.persistencia.repositorios.EquipoRepositorio;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipoServicio {

    EquipoRepositorio equipoRepositorio;

    public List<Equipo> obtenerEquipos()
    {
        return equipoRepositorio.findAll();
    }
}
