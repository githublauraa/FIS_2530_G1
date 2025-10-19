package com.ejemplo.miproyectospring.Capacalculo;
// Clase de datos
public class RespuestasFormulario {
    private double consumoElectricidad;
    private double consumoAgua;
    private int tipoTransporte;
    private double distanciaDiaria;
    private int diasPorSemana;
    private int tipoDieta;

    public double getConsumoElectricidad() { return consumoElectricidad; }
    public void setConsumoElectricidad(double consumoElectricidad) { this.consumoElectricidad = consumoElectricidad; }

    public double getConsumoAgua() { return consumoAgua; }
    public void setConsumoAgua(double consumoAgua) { this.consumoAgua = consumoAgua; }

    public int getTipoTransporte() { return tipoTransporte; }
    public void setTipoTransporte(int tipoTransporte) { this.tipoTransporte = tipoTransporte; }

    public double getDistanciaDiaria() { return distanciaDiaria; }
    public void setDistanciaDiaria(double distanciaDiaria) { this.distanciaDiaria = distanciaDiaria; }

    public int getDiasPorSemana() { return diasPorSemana; }
    public void setDiasPorSemana(int diasPorSemana) { this.diasPorSemana = diasPorSemana; }

    public int getTipoDieta() { return tipoDieta; }
    public void setTipoDieta(int tipoDieta) { this.tipoDieta = tipoDieta; }
}