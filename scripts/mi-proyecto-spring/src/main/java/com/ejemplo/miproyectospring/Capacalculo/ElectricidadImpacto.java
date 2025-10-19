package com.ejemplo.miproyectospring.Capacalculo;
// Subclases concretas
public class ElectricidadImpacto extends CategoriaImpacto {
    @Override
    public double calcularImpacto(RespuestasFormulario r) {
        double factor = 0.233; // kg CO2/kWh promedio
        return r.getConsumoElectricidad() * factor;
    }
}