package edu.unl.cc.view;

import edu.unl.cc.domain.Fraccion;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Fraccion f1 = null;
        int opcion;

        do {
            System.out.println("\n===== MENU DE FRACCIONES =====");
            System.out.println("1. Ingresar fraccion");
            System.out.println("2. Mostrar fraccion simplificada");
            System.out.println("3. Mostrar valor decimal");
            System.out.println("4. Sumar fracciones");
            System.out.println("5. Restar fracciones");
            System.out.println("6. Multiplicar fracciones");
            System.out.println("7. Dividir fracciones");
            System.out.println("8. Mostrar fraccion original");
            System.out.println("9. Mostrar fraccion inversa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1: {
                    System.out.print("Ingrese el numerador: ");
                    int numerador = entrada.nextInt();

                    int denominador;

                    do {
                        System.out.print("Ingrese el denominador: ");
                        denominador = entrada.nextInt();

                        if (denominador == 0) {
                            System.out.println(
                                    "Error: el denominador no puede ser cero."
                            );
                        }
                    } while (denominador == 0);

                    f1 = new Fraccion(numerador, denominador);

                    System.out.println("Fraccion ingresada: " + f1);
                    break;
                }

                case 2: {
                    if (f1 == null) {
                        System.out.println(
                                "Primero debe ingresar una fraccion."
                        );
                    } else {
                        System.out.println(
                                "Fraccion simplificada: " + f1.simplificar()
                        );
                    }
                    break;
                }

                case 3: {
                    if (f1 == null) {
                        System.out.println(
                                "Primero debe ingresar una fraccion."
                        );
                    } else {
                        System.out.printf(
                                "Valor aproximado: %.4f%n",
                                f1.obtenerValorDecimal()
                        );
                    }
                    break;
                }

                case 4:
                case 5:
                case 6:
                case 7: {

                    if (f1 == null) {
                        System.out.println(
                                "Primero debe ingresar la primera fraccion."
                        );
                        break;
                    }

                    System.out.println(
                            "Ingrese la segunda fraccion:"
                    );

                    System.out.print("Numerador: ");
                    int numerador2 = entrada.nextInt();

                    int denominador2;

                    do {
                        System.out.print("Denominador: ");
                        denominador2 = entrada.nextInt();

                        if (denominador2 == 0) {
                            System.out.println(
                                    "Error: el denominador no puede ser cero."
                            );
                        }
                    } while (denominador2 == 0);

                    Fraccion f2 = new Fraccion(
                            numerador2, denominador2
                    );

                    Fraccion resultado = null;

                    switch (opcion) {

                        case 4:
                            resultado = f1.sumar(f2);
                            break;

                        case 5:
                            resultado = f1.restar(f2);
                            break;

                        case 6:
                            resultado = f1.multiplicar(f2);
                            break;

                        case 7:
                            if (f2.obtenerValorDecimal() == 0) {
                                System.out.println(
                                        "Error: no se puede dividir "
                                                + "entre una fraccion de valor cero."
                                );
                            } else {
                                resultado = f1.dividir(f2);
                            }
                            break;
                    }

                    if (resultado != null) {
                        resultado = resultado.simplificar();

                        System.out.println(
                                "Resultado simplificado: " + resultado
                        );

                        System.out.printf(
                                "Valor aproximado: %.4f%n",
                                resultado.obtenerValorDecimal()
                        );
                    }

                    break;
                }

                case 8: {
                    if (f1 == null) {
                        System.out.println(
                                "Primero debe ingresar una fraccion."
                        );
                    } else {
                        System.out.println(
                                "Fraccion original: " + f1
                        );
                    }
                    break;
                }
                case 9: {
                    if (f1 == null) {
                        System.out.println("Primero debe ingresar una fraccion.");
                    } else if (f1.obtenerValorDecimal() == 0) {
                        System.out.println(
                                "Error: una fraccion con valor cero no tiene inversa."
                        );
                    } else {
                        System.out.println(
                                "Fraccion inversa: " + f1.obtenerInversa()
                        );
                    }
                    break;
                }
                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println(
                            "Opcion no valida. Intente nuevamente."
                    );
            }

        } while (opcion != 0);

        entrada.close();
    }
}


