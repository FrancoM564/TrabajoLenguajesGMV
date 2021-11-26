
package Objetos;

public class Deposito extends Cajero{
    public Deposito(String aux[],int tipo) {
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
        System.out.println("********************************************");
        System.out.println("Ingrese monto a depositar:");
        if (cuentaA!=null) {
            int monto = scan.nextInt();
            int suma = cuentaA.getSaldo() + monto;
            cuentaA.setSaldo(suma);
            System.out.println("Saldo actual: "+cuentaA.getSaldo());
            System.out.println("********************************************");
        }else{
            double monto = scan.nextDouble();
            double resta = cuentaC.getConsumo() - monto;
            System.out.println("Saldo a pagar restante: "+resta);
            cuentaC.setConsumo(resta); 
            System.out.println("********************************************");
        }
    }

    
}
