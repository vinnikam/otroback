package co.ucentral.bkedgame;

import co.ucentral.bkedgame.persistencia.entidades.DirectorTecnico;
import co.ucentral.bkedgame.persistencia.entidades.Equipo;
import co.ucentral.bkedgame.persistencia.repositorios.DirectorTecnicoRepositorio;
import co.ucentral.bkedgame.persistencia.repositorios.EquipoRepositorio;
import co.ucentral.bkedgame.servicios.DirectorTecnicoServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BkedgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BkedgameApplication.class, args);
	}
	@Bean
	CommandLineRunner init(EquipoRepositorio equipoRepositorio,
						   DirectorTecnicoRepositorio directorTecnicoRepositorio,
						   BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			//String laclave = passwordEncoder.encode("123456");
			String laclave = "123456";
			System.out.println(laclave);
			DirectorTecnico directorTecnico = DirectorTecnico.builder()
					.nombreCompleto("Gamero")
					.disponible(true)
					.nacionalidad("Colombiano")
					.usuario("gmero")
					.clave(laclave)
					.build();

			directorTecnicoRepositorio.save(directorTecnico);

			Equipo equipo1 = Equipo.builder()
					.nombre("Barcelona")
					.nombreCorto("Barca")
					.build();
			Equipo equipo2 = Equipo.builder()
					.nombre("Real Madrid")
					.nombreCorto("Real")
					.build();
			Equipo equipo3 = Equipo.builder()
					.nombre("Atletico")
					.nombreCorto("Aletic")
					.build();

			equipoRepositorio.saveAll(List.of(equipo1, equipo2, equipo3));
		};
	}
}
