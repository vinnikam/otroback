package co.ucentral.bkedgame.servicios;

import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.persistencia.repositorios.EquipoRepositorio;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EquipoServicio {

    EquipoRepositorio equipoRepositorio;

    public List<Equipo> obtenerTodos()
    {
        return equipoRepositorio.findAll();
    }

    public Equipo crear(Equipo equipo){
        return  equipoRepositorio.save(equipo);
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
