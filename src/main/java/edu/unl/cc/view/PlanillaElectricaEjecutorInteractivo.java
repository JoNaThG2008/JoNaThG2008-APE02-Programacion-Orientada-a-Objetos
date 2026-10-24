package edu.unl.cc.ape.view;
/**
 * @author Ordoñez Andy N.
 * Ejecutar la planilla de luz interactivo
 */

import edu.unl.cc.ape.domain.PlanillaElectrica;
import java.util.Scanner;

public class PlanillaElectricaEjecutorInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println(" SISTEMA INTERACTIVO DE PLANILLA ELÉCTRICA");
        System.out.println("========================================");

        try {
            // Solicitar datos por consola de forma interactiva
            System.out.print("Ingrese el número de medidor: ");
            String medidor = scanner.nextLine();

            System.out.print("Ingrese el nombre del titular: ");
            String titular = scanner.nextLine();

            System.out.print("Ingrese la lectura anterior (kWh): ");
            Double lecturaAnterior = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la lectura actual (kWh): ");
            Double lecturaActual = Double.parseDouble(scanner.nextLine());

            // Creación del objeto (Aquí se dispara la validación si la lectura actual es menor)
            PlanillaElectrica planilla = new PlanillaElectrica(medidor, titular, lecturaAnterior, lecturaActual);

            // Mostrar el resultado final mediante toString()
            System.out.println("\n[DATOS PROCESADOS CON ÉXITO]");
            System.out.println(planilla);

        } catch (NumberFormatException e) {
            System.out.println("\n[ERROR]: Debe ingresar valores numéricos válidos para las lecturas.");
        } catch (IllegalArgumentException e) {
            System.out.println("\n[MENSAJE DE VALIDACIÓN CAPTURADO]: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}