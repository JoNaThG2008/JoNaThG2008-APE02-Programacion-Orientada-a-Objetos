package edu.unl.cc.ape;
/**
 * @author Jonathan Contento C.
 * Fraccion Matematica.
 */
public class Fracccion {
    //Atributos:
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException(
                    "El denominador no puede ser cero."
            );
        }

        this.numerador = numerador;
        this.denominador = denominador;
    }


}