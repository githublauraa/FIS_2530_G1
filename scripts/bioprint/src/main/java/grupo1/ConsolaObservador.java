package grupo1;

public class ConsolaObservador implements Observador {
    @Override
    public void actualizar(double total) {
        System.out.println(" [Notificación] Nueva huella calculada: " + total + " kgCO₂");
    }
}   