package edu.unl.cc.ape.domain;
/**
 * @author Ordoñez Andy N.
 * Representar una planilla de luz
 */
public class PlanillaElectrica {
    private String numeroMedidor;
    private String nombreTitular;
    private Double lecturaAnterior;
    private Double lecturaActual;

    // Constructor
    public PlanillaElectrica(String numeroMedidor, String nombreTitular, Double lecturaAnterior, Double lecturaActual) {
        this.numeroMedidor = numeroMedidor;
        this.nombreTitular = nombreTitular;
        this.lecturaAnterior = lecturaAnterior;
        setLecturaActual(lecturaActual); // Valida mediante el setter
    }

    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public Double getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(Double lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public Double getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(Double lecturaActual) {
        // Validación: la lectura actual debe ser mayor o igual que la anterior[cite: 1]
        if (lecturaActual < this.lecturaAnterior) {
            throw new IllegalArgumentException("Error de validación: La lectura actual (" + lecturaActual +
                    ") no puede ser menor que la lectura anterior (" + this.lecturaAnterior + ").");
        }
        this.lecturaActual = lecturaActual;
    }

    // Cálculo del consumo del periodo en kWh
    public Double calcularConsumo() {
        return this.lecturaActual - this.lecturaAnterior;
    }

    // Cálculo del subtotal por bloques de tarifas
    public Double calcularSubtotal() {
        Double consumo = calcularConsumo();
        Double subtotal = 0.0;

        if (consumo <= 100) {
            subtotal = consumo * 0.10;
        } else if (consumo <= 200) {
            subtotal = (100 * 0.10) + ((consumo - 100) * 0.15);
        } else {
            subtotal = (100 * 0.10) + (100 * 0.15) + ((consumo - 200) * 0.20);
        }
        return Math.round(subtotal * 100.0) / 100.0;
    }

    // Cálculo del IVA (15%) usando Double y Math.round
    public Double calcularIva() {
        Double subtotal = calcularSubtotal();
        Double iva = subtotal * 0.15;
        return Math.round(iva * 100.0) / 100.0;
    }

    // Cálculo del total general redondeado a dos decimales
    public Double calcularTotal() {
        Double subtotal = calcularSubtotal();
        Double iva = calcularIva();
        Double total = subtotal + iva;
        return Math.round(total * 100.0) / 100.0;
    }

    // Visualización del estado con toString()
    @Override
    public String toString() {
        return "========================================\n" +
                "PLANILLA DE CONSUMO ELÉCTRICO DOMÉSTICO\n" +
                "========================================\n" +
                "Medidor          : " + numeroMedidor + "\n" +
                "Titular          : " + nombreTitular + "\n" +
                "Lectura Anterior : " + lecturaAnterior + " kWh\n" +
                "Lectura Actual   : " + lecturaActual + " kWh\n" +
                "Consumo Periodo  : " + calcularConsumo() + " kWh\n" +
                "Subtotal         : $" + calcularSubtotal() + "\n" +
                "IVA (15%)        : $" + calcularIva() + "\n" +
                "Total a Pagar    : $" + calcularTotal() + "\n" +
                "========================================";
    }
}
