package Objetos;

import java.io.*;
import java.util.*;


public abstract class Cajero {

    public boolean estado;
    public int intentos;
    public String ruta = "E:\\Drive\\Documentos\\2021-2\\Lenguajes de programación\\Trabajo\\CA_TrabajoIntegrador_Guerra-Marquez-Villanueva\\"; //Colocar la dirección donde se encuentran los archivos
    protected CuentaAhorros cuentaA;
    protected CuentaCredito cuentaC;
    public Scanner scan = new Scanner(System.in);
    public FileReader leer = null;
    public FileWriter datos = null;
    public PrintWriter escribir = null;

    public void Validar(String aux[]) {
        estado = true;
        intentos = 0;
        int pass = Integer.parseInt(aux[0]);
        while (intentos != 3) {
            if (intentos == 2) {
                System.out.println("Ingrese pin: ");
                int inten = scan.nextInt();
                if (pass == inten) {
                    System.out.println("Acceso permitido");
                } else {
                    System.out.println("Tarjeta bloqueada");
                    estado = false;
                }
                break;
            } else {
                System.out.println("Ingrese pin: ");
                int inten = scan.nextInt();
                if (pass == inten) {
                    System.out.println("Acceso permitido");
                    break;
                } else {
                    System.out.println("Pin incorrecto, intentelo nuevamente");
                    intentos += 1;
                }
            }
        }
        if (estado == false) {
            System.exit(0);
        }
    }

    public abstract void Operacion();


    public int saberTipo(String datos[]) {
        if (datos[1].equals("debito")) {
            return 1;
        } else {
            return 2;
        }
    }

    public String leerycrearruta() {
        String cadena = "";
        try {
            System.out.println("Ingrese tarjeta:");
            ruta = ruta + scan.nextLine() + ".txt";
            leer = new FileReader(ruta);
            int c;
            while ((c = leer.read()) != -1) {
                cadena += (char) c;
            }
        } catch (Exception e) {

        }
        return cadena;
    }
    
    public void Sobreescribir(String aux[]){
        try {
            datos = new FileWriter(ruta);
            escribir = new PrintWriter(datos);
            escribir.flush();
            escribir.write(aux[0]);
            for(int x = 1;x<aux.length;x++){
                escribir.write(","+aux[x]);
            }
            escribir.close();
        } catch (IOException e) {
 
        }
        
    }
    public String[] actualizarDatos(String aux[]){
        if (cuentaA != null){
            aux[3] = String.valueOf(cuentaA.getSaldo());
        }else{
            double doble = cuentaC.getConsumo();
            aux[2] = String.valueOf(doble);
        }
        return aux;
    }
}
