package edu.unl.cc.domain;

/*
 *@Author Lady Guamán
 */
import java.util.ArrayList;
public class CuentaBancaria {
    //Atributos
    private String numeroCuenta;
    private String nombreTitular;
    protected double saldo;
    private ArrayList<String>  historial;

    //Métodos
    public CuentaBancaria(String  numeroCuenta, String nombreTitular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();

    }
    public void  depositar(double monto) {

        if (monto > 0) {
            saldo += monto;
            historial.add( "Déposito: " + monto );
            System.out.println("Depósito exitoso");
        } else {
            System.out.println("El monto debe ser mayor a O");
        }
    }
    public void retirar(double monto){
        if (monto <0) {
            System.out.println("El monto debe ser mayor a O");

        } else if(monto>saldo) {
            System.out.println("fondos insufiecientes");
        }else{
            saldo-= monto;
            historial.add("Retiro:- " + monto + "\n");
            System.out.println("Retiro exitoso");

        }
    }

    //Motrar los datos de la cuenta
    public void mostrarDatos(){
        System.out.println("Numero de cuenta:"+numeroCuenta);
        System.out.println("Titular:"+nombreTitular);
        System.out.println("Saldo actual:"+saldo);
    }
    // Mostrar el historial de movimientos
    public void mostrarHistorial(){
        if (historial.isEmpty()) {
            System.out.println("No hay movimientos todavia");
        }else{
            for(String  movimiento : historial){
                System.out.println(movimiento);
            }
        }
    }
    public void consultarSaldo(){
        System.out.println("==Datos de la cuenta==");
        mostrarDatos();
        System.out.println("== Historial==");
        mostrarHistorial();
    }
}
