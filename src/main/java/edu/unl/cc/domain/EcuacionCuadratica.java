package edu.unl.cc.ape.domain;

import java.util.Scanner;

public class EcuacionCuadratica {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcion;
        double a, b, c;
        double discriminante, x1, x2;

        do {
            System.out.println("\n====================================");
            System.out.println("       ECUACION CUADRATICA");
            System.out.println("====================================");
            System.out.println("1. Resolver ecuacion cuadratica");
            System.out.println("2. Mostrar formula general");
            System.out.println("3. Salir");
            System.out.println("====================================");

            System.out.print("Seleccione una opcion: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Error: Ingrese una opcion numerica.");
                entrada.next();
            }

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n--- RESOLVER ECUACION CUADRATICA ---");
                    System.out.println("Forma general: ax^2 + bx + c = 0");

                    System.out.print("Ingrese el valor de a: ");
                    while (!entrada.hasNextDouble()) {
                        System.out.print("Ingrese un numero valido: ");
                        entrada.next();
                    }
                    a = entrada.nextDouble();

                    if (a == 0) {
                        System.out.println("Error: a no puede ser cero.");
                        System.out.println("La ecuacion no seria cuadratica.");
                        break;
                    }

                    System.out.print("Ingrese el valor de b: ");
                    while (!entrada.hasNextDouble()) {
                        System.out.print("Ingrese un numero valido: ");
                        entrada.next();
                    }
                    b = entrada.nextDouble();

                    System.out.print("Ingrese el valor de c: ");
                    while (!entrada.hasNextDouble()) {
                        System.out.print("Ingrese un numero valido: ");
                        entrada.next();
                    }
                    c = entrada.nextDouble();

                    discriminante = (b * b) - (4 * a * c);

                    System.out.println("\n========== RESULTADOS ==========");
                    System.out.println("Ecuacion: " + a + "x^2 + " + b + "x + " + c + " = 0");
                    System.out.println("Discriminante: " + discriminante);

                    if (discriminante > 0) {

                        x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                        x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

                        System.out.println("La ecuacion tiene dos soluciones reales.");
                        System.out.printf("x1 = %.2f%n", x1);
                        System.out.printf("x2 = %.2f%n", x2);

                    } else if (discriminante == 0) {

                        x1 = -b / (2 * a);

                        System.out.println("La ecuacion tiene una solucion real doble.");
                        System.out.printf("x = %.2f%n", x1);

                    } else {

                        double parteReal = -b / (2 * a);
                        double parteImaginaria =
                                Math.sqrt(-discriminante) / Math.abs(2 * a);

                        System.out.println("La ecuacion tiene dos soluciones complejas.");
                        System.out.printf("x1 = %.2f + %.2fi%n",
                                parteReal, parteImaginaria);
                        System.out.printf("x2 = %.2f - %.2fi%n",
                                parteReal, parteImaginaria);
                    }

                    System.out.println("================================");
                    break;

                case 2:
                    System.out.println("\n--- FORMULA GENERAL ---");
                    System.out.println("ax^2 + bx + c = 0");
                    System.out.println("x = (-b +/- sqrt(b^2 - 4ac)) / (2a)");
                    System.out.println("Discriminante = b^2 - 4ac");
                    System.out.println("Si D > 0: Dos soluciones reales.");
                    System.out.println("Si D = 0: Una solucion real doble.");
                    System.out.println("Si D < 0: Dos soluciones complejas.");
                    break;

                case 3:
                    System.out.println("\nGracias por utilizar el programa.");
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("\nError: Opcion no valida.");
                    System.out.println("Seleccione una opcion del 1 al 3.");
                    break;
            }

        } while (opcion != 3);

        entrada.close();
    }
}