/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author franc
 */
public class CuentaCredito extends Cuenta{
    
    private int lineacredito;
    private double consumo;

    public CuentaCredito(int pin, String tipo,double consumo, int dni, int lineacredito, int tarjeta, String nombre, String apellido) {
        super(nombre, apellido, dni, pin, tarjeta, tipo);
        this.lineacredito = lineacredito;
        this.consumo = consumo;
    }

    public int getLineacredito() {
        return lineacredito;
    }

    public void setLineacredito(int lineacredito) {
        this.lineacredito = lineacredito;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    
    
    
}
