package Objetos;

public class Retiro extends Cajero {

    public int Nretiro, transacción, limite;
    public double descuento;

    public Retiro(String aux[], int tipo) {
        if (tipo == 1) {
            int a = Integer.parseInt(aux[0]);
            int b = Integer.parseInt(aux[2]);
            int c = Integer.parseInt(aux[3]);
            int d = Integer.parseInt(aux[4]);
            this.cuentaA = new CuentaAhorros(a, aux[1], b, c, d, aux[5], aux[6]);
        } else {
            int a = Integer.parseInt(aux[0]);
            double b = Double.parseDouble(aux[2]);
            int c = Integer.parseInt(aux[3]);
            int d = Integer.parseInt(aux[4]);
            int e = Integer.parseInt(aux[5]);
            this.cuentaC = new CuentaCredito(a, aux[1], b, c, d, e, aux[6], aux[7]);
        }
    }

    @Override
    public void Operacion() {
        //Verificar si cuenta con el saldo suficiente
        System.out.println("********************************************");
        if (cuentaA != null) {
            System.out.println("Cuanto deseas retirar?");
            Nretiro = scan.nextInt();
            if (Nretiro <= this.cuentaA.getSaldo()) {
                transacción = cuentaA.getSaldo();
                cuentaA.setSaldo(transacción - Nretiro);
                System.out.println("Retiraste: " + Nretiro
                        + "\nTu saldo actual es: " + cuentaA.getSaldo());

            } else {
                System.out.println("El monto indicado para retirar supera el saldo de la cuenta de ahorro");
            }
        } else {
            //descontar un 5% del total retirado, y los montos retirados deben ser menor al 50% de la linea base
            System.out.println("Cuanto deseas retirar");
            Nretiro = scan.nextInt();
            limite = (cuentaC.getLineacredito()) / 2;
            if (Nretiro <= limite) {
                descuento = Nretiro * 0.05;
                transacción = cuentaC.getLineacredito();
                cuentaC.setLineacredito(transacción - Nretiro);
                cuentaC.setConsumo(Nretiro + descuento + cuentaC.getConsumo());
                System.out.println("Retiraste: " + Nretiro
                        + "\nTu consumo actual es: " + cuentaC.getConsumo()
                        + "\nSe te desconto: " + descuento);
                System.out.println("********************************************");
            } else{
                System.out.println("El monto solicitado es mayor de lo que su cuenta le permite");
                System.out.println("********************************************");
            }

        }
    }
}
