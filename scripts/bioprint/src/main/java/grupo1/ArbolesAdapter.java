package grupo1;

public class ArbolesAdapter implements Equivalencia {
    @Override
    public String mostrar(double kgCO2) {
        int arboles = (int) (kgCO2 / 20); // 1 árbol ≈ 20 kg CO₂/año
        return " Equivale a plantar " + arboles + " árboles.";
    }
}