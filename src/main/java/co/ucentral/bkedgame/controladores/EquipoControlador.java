package co.ucentral.bkedgame.controladores;

import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.servicios.EquipoServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/equipos")
@CrossOrigin(origins = "*")
public class EquipoControlador {
    EquipoServicio equipoServicio;

    @GetMapping("/")
    public List<Equipo> obtenerEquipos(){
        return equipoServicio.obtenerEquipos();
    }

}
