
package Objetos;

public class CuentaAhorros extends Cuenta{
    
    private int saldo;

    public CuentaAhorros(int pin,String tipo, int dni, int saldo, int tarjeta, String nombre, String apellido) {
        super(nombre, apellido, dni, pin, tarjeta, tipo);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}
