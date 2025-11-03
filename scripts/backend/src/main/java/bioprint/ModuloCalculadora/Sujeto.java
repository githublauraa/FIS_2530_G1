package bioprint.ModuloCalculadora;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {
    private List<Observador> observadores = new ArrayList<>();

    public void addObservador(Observador o) {
        observadores.add(o);
    }

    public void notificar(double total) {
        for (Observador o : observadores)
            o.actualizar(total);
    }
}