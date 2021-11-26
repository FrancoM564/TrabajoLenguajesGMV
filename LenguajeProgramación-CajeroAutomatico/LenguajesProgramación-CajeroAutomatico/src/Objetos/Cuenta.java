package Objetos;

/*
Esta clase sirve de padre para las cuentas de ahorros y de crédito, las cuales
serán objetos que permitirán el trabajo más facil de las clases con las transacciones.
 */
public class Cuenta {
    private String nombre;
    private String apellido;
    private int dni;
    private int pin;
    private int tarjeta;
    private String tipo;

    public Cuenta(String nombre, String apellido, int dni, int pin, int tarjeta, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.pin = pin;
        this.tarjeta = tarjeta;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
