package edu.unl.cc.ape.view;
import edu.unl.cc.ape.domain.PlanillaElectrica;
/**
 * @author Ordoñez Andy N.
 * Ejecutar la planilla de luz
 */
public class PlanillaElectricaEjecutor {
    public static void main(String[] args) {
        // Caso de prueba 1: anterior = 1200, actual = 1350
        System.out.println("=== CASO DE PRUEBA 1 ===");
        try {
            PlanillaElectrica planilla1 = new PlanillaElectrica("MED-001", "Ana Torres", 1200.0, 1350.0);
            System.out.println(planilla1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Caso de prueba 2: anterior = 1000, actual = 1300
        System.out.println("\n=== CASO DE PRUEBA 2 ===");
        try {
            PlanillaElectrica planilla2 = new PlanillaElectrica("MED-002", "Luis Andrade", 1000.0, 1300.0);
            System.out.println(planilla2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Caso de prueba 3: actual = 1150 y anterior = 1200 (Mensaje de validación)
        System.out.println("\n=== CASO DE PRUEBA 3 (Validación de Error) ===");
        try {
            PlanillaElectrica planilla3 = new PlanillaElectrica("MED-003", "Carmen Mora", 1200.0, 1150.0);
            System.out.println(planilla3);
        } catch (IllegalArgumentException e) {
            System.out.println("[MENSAJE CAPTURADO]: " + e.getMessage());
        }
    }
}
