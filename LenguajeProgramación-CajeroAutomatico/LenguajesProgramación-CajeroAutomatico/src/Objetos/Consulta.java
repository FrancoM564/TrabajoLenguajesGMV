package Objetos;

public class Consulta extends Cajero {

    public Consulta(String aux[],int tipo) {
        if (tipo == 1){
            int a = Integer.parseInt(aux[0]);
            int b = Integer.parseInt(aux[2]);
            int c = Integer.parseInt(aux[3]);
            int d = Integer.parseInt(aux[4]);
            this.cuentaA = new CuentaAhorros(a, aux[1], b, c, d, aux[5],aux[6]);
        }else{
            int a = Integer.parseInt(aux[0]);
            double b = Double.parseDouble(aux[2]);
            int c = Integer.parseInt(aux[3]);
            int d = Integer.parseInt(aux[4]);
            int e = Integer.parseInt(aux[5]);
            this.cuentaC = new CuentaCredito(a, aux[1],b, c, d, e, aux[6], aux[7]);
        }
    }

    @Override
    public void Operacion() {
        System.out.println("********************************");
        if (cuentaA != null) {
            System.out.println("Nombre: "+cuentaA.getNombre()+" "+cuentaA.getApellido());
            System.out.println("DNI: "+cuentaA.getDni());
            System.out.println("N° de tarjeta: "+cuentaA.getTarjeta());
            System.out.println("Su saldo es :" + cuentaA.getSaldo());
            System.out.println("********************************");
        } else {
            System.out.println("Nombre: "+cuentaC.getNombre()+" "+cuentaC.getApellido());
            System.out.println("DNI: "+cuentaC.getDni());
            System.out.println("N° de tarjeta: "+cuentaC.getTarjeta());
            System.out.println("Su linea de credito es :" + cuentaC.getLineacredito());
            System.out.println("Su consumo es :" + cuentaC.getConsumo());
            System.out.println("Saldo restante :" + (cuentaC.getLineacredito() - cuentaC.getConsumo()));
            System.out.println("********************************");
        }
    }

}
