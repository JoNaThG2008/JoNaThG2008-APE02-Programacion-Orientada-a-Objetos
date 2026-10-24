package edu.unl.cc.view;

import edu.unl.cc.domain.CuentaBancaria;
import java.util.Scanner;

public class CuentaBancariaExecutor {

    // AYUDANTE 1: pide un entero y repite hasta que sea válido
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                // Si escribió letras, cae aquí en vez de romper el programa
                System.out.println("Error: ingrese solo números enteros.");
            }
        }
    }

    // AYUDANTE 2: pide un decimal y repite hasta que sea válido
    public static double leerDecimal(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido (ejemplo: 100.50).");
            }
        }
    }

    // AYUDANTE 3: pide el número de cuenta (exactamente 10 dígitos)
    public static String leerNumeroCuenta(Scanner sc) {
        System.out.print("Número de cuenta (10 dígitos): ");
        String numero = sc.nextLine().trim();
        while (!numero.matches("[0-9]{10}")) {
            System.out.print("Error, ingrese exactamente 10 dígitos: ");
            numero = sc.nextLine().trim();
        }
        return numero;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = null; // todavía no existe ninguna cuenta
        int opcion;

        do {
            // Menú con printf
            System.out.printf("%n===== MENÚ =====%n");
            System.out.printf("1. Crear cuenta%n");
            System.out.printf("2. Depositar / Retirar%n");
            System.out.printf("3. Consultar saldo e historial%n");
            System.out.printf("4. Salir%n");
            opcion = leerEntero(sc, "Elija una opción: ");

            switch (opcion) {

                case 1:
                    String numero = leerNumeroCuenta(sc);

                    System.out.print("Nombre del titular: ");
                    String titular = sc.nextLine().trim();
                    // El titular solo puede tener letras y espacios
                    while (!titular.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
                        System.out.print("Error, solo letras. Nombre del titular: ");
                        titular = sc.nextLine().trim();
                    }

                    double saldoInicial = leerDecimal(sc, "Saldo inicial: ");
                    while (saldoInicial < 0) {
                        System.out.println("Error: el saldo inicial no puede ser negativo.");
                        saldoInicial = leerDecimal(sc, "Saldo inicial: ");
                    }

                    cuenta = new CuentaBancaria(numero, titular, saldoInicial);
                    System.out.println("Cuenta creada con éxito.");
                    break;

                case 2:
                    if (cuenta == null) {
                        System.out.println("Primero debe crear una cuenta.");
                    } else {
                        System.out.printf("1. Depositar%n2. Retirar%n");
                        int tipo = leerEntero(sc, "Elija: ");

                        if (tipo == 1 || tipo == 2) {
                            double monto = leerDecimal(sc, "Monto: ");
                            if (tipo == 1) {
                                cuenta.depositar(monto);
                            } else {
                                cuenta.retirar(monto);
                            }
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    }
                    break;

                case 3:
                    if (cuenta == null) {
                        System.out.println("Primero debe crear una cuenta.");
                    } else {
                        cuenta.consultarSaldo();
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}