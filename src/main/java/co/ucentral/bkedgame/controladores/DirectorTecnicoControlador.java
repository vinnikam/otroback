package co.ucentral.bkedgame.controladores;

import co.ucentral.bkedgame.dto.DirectorTecnicoDto;
import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.servicios.DirectorTecnicoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DirectorTecnicoDto>  autenticar(@RequestBody DirectorTecnicoDto directorTecnicoDto){
        directorTecnicoDto = directorTecnicoServicio.autenticar(directorTecnicoDto) ;
        if (directorTecnicoDto != null)
        {
            return ResponseEntity.ok().body(directorTecnicoDto);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/")
    public List<DirectorTecnico> obtenerTodos(){
        return directorTecnicoServicio.obtenerTodos();
    }
}
