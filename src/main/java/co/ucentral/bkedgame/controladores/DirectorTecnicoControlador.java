package co.ucentral.bkedgame.controladores;

import co.ucentral.bkedgame.dto.DirectorTecnicoDto;
import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.servicios.DirectorTecnicoServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/directorest")
@CrossOrigin(origins = "*")
public class DirectorTecnicoControlador {
    DirectorTecnicoServicio directorTecnicoServicio;


    @PostMapping("/")
    public DirectorTecnico crear(@RequestBody DirectorTecnicoDto directorTecnicoDto){
        return directorTecnicoServicio.crear(directorTecnicoDto);
    }
    @PostMapping("/autenticar")
    public DirectorTecnicoDto autenticar(@RequestBody DirectorTecnicoDto directorTecnicoDto){
        return directorTecnicoServicio.autenticar(directorTecnicoDto);
    }

    @GetMapping("/")
    public List<DirectorTecnico> obtenerTodos(){
        return directorTecnicoServicio.obtenerTodos();
    }
}
