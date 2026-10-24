package edu.unl.cc.domain;
/**
 * @author Jonathan Contento C.
 * Fracciones Matematicas.
 */
public class Fraccion {
    // ATRIBUTOS
    private int numerador;
    private int denominador;

    // 2. CONSTRUCTOR
    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException(
                    "El denominador no puede ser cero."
            );
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }
    //  MOSTRAR LA FRACCIÓN

    public void mostrarFraccion() {
        System.out.println(numerador + "/" + denominador);
    }

    //  OBTENER EL VALOR DECIMAL

    public double obtenerValorDecimal() {
        return (double) numerador / denominador;
    }
    // SUMAR DOS FRACCIONES


    public Fraccion sumar(Fraccion otro) {

        int nuevoNumerador =
                numerador * otro.denominador
                        + otro.numerador * denominador;

        int nuevoDenominador =
                denominador * otro.denominador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // RESTAR DOS FRACCIONES

    public Fraccion restar(Fraccion otro) {

        int nuevoNumerador =
                numerador * otro.denominador
                        - otro.numerador * denominador;
        int nuevoDenominador =
                denominador * otro.denominador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }



    // MULTIPLICAR DOS FRACCIONES
    public Fraccion multiplicar(Fraccion otro) {

        int nuevoNumerador = numerador * otro.numerador;
        int nuevoDenominador = denominador * otro.denominador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }



    //  DIVIDIR DOS FRACCIONES

    public Fraccion dividir(Fraccion otro) {

        if (otro.numerador == 0) {
            throw new IllegalArgumentException(
                    "No se puede dividir entre una fracción de valor cero."
            );
        }

        int nuevoNumerador = numerador * otro.denominador;
        int nuevoDenominador = denominador * otro.numerador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // OBTENER LA FRACCIÓN INVERSA
    public Fraccion obtenerInversa() {
        if (numerador == 0) {
            throw new IllegalStateException(
                    "Una fracción con numerador cero no tiene inversa."
            );
        }

        return new Fraccion(denominador, numerador);
    }

    // CALCULAR MCD
    private int calcularMCD(int a,int b){
        a= Math.abs(a);
        b= Math.abs(b);
        while(b!=0){
            int resto = a % b;
            a=b;
            b=resto;
        }
        return a;
    }
    //SIMPLIFICAR FRACCIONES
    //  SIMPLIFICAR LA FRACCIÓN

    public Fraccion simplificar() {

        int mcd = calcularMCD(numerador, denominador);

        return new Fraccion(
                numerador / mcd,
                denominador / mcd
        );
    }


    //  REPRESENTAR LA FRACCIÓN
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}
