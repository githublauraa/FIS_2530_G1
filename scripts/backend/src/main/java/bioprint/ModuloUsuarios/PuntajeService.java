package bioprint.ModuloUsuarios;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PuntajeService {
    private final PuntajeRepository repo;
    private final UsuarioRepository usuarioRepo;

    public PuntajeService(PuntajeRepository repo, UsuarioRepository usuarioRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
    }

    public Puntaje registrarPuntaje(String nombreUsuario, double valor) {
        Usuario usuario = usuarioRepo.findByNombre(nombreUsuario);

        Puntaje p = new Puntaje();
        p.setUsuario(usuario);
        p.setValor(valor);
        p.setFecha(LocalDate.now());
        return repo.save(p);
    }

    public List<Puntaje> obtenerPuntajes(String nombreUsuario) {
        return repo.findByUsuarioNombre(nombreUsuario);
    }
}
