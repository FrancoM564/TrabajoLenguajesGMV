/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author franc
 */
public class Menu extends Cajero {

    @Override
    public void Operacion() {
        String aux[] = leerycrearruta().split(",");
        Validar(aux);
        int tipo = saberTipo(aux);
        int puerta = 0;
        int opcion = 0;
        do {
            System.out.println("\nBienvenido, ¿Que operacion desea hacer hoy?:");
            do {
                System.out.println("********************************************");
                System.out.println("1.Consultas");
                System.out.println("2.Retiro");
                System.out.println("3.Deposito");
                System.out.println("4.Salir");
                System.out.println("********************************************");
                System.out.println("Opcion:");
                opcion = scan.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    puerta = 1;
                } else {
                    System.out.println("Opción invalida, elija nuevamente");
                }
            } while (puerta == 0);
            if (opcion == 1) {
                Cajero pase = new Consulta(aux, tipo);
                pase.Operacion();
            } else if (opcion == 3) {
                Cajero pase = new Deposito(aux, tipo);
                pase.Operacion();
                aux = pase.actualizarDatos(aux);
                Sobreescribir(aux);
            } else if (opcion == 2) {
                Cajero pase = new Retiro(aux, tipo);
                pase.Operacion();
                aux = pase.actualizarDatos(aux);
                Sobreescribir(aux);
            } else {
                puerta = 2;
            }
        } while (puerta != 2);
        System.out.println("***********************************\n\n\nGracias por confiar en nosotro"
                + "s :3\n\n\n***********************************");
    }

}
