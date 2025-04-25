package co.ucentral.bkedgame.persistencia.repositorios;

import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorTecnicoRepositorio extends JpaRepository<DirectorTecnico, Long> {
    Optional<DirectorTecnico> findByUsuario(String usuario);

    Optional<DirectorTecnico> findByUsuarioAndClave(String usuario, String clave);
}
