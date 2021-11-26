# -*- coding: utf-8 -*-
"""
Created on Mon Nov 15 23:04:09 2021

@author: Matias
"""

import csv
import sys
    
def validar(lista, intentos):
    pin = int(input("Ingrese su contraseña: "))
    if pin == int(lista[0]):
        print("Acceso permitido")
    else:
        print("Pin incorrecto, intentelo nuevamente ")
        intentos = intentos + 1
        if intentos == 3:
            print("Tarjeta bloqueada")
            sys.exit()
        return validar(lista, intentos)

def menu(lista,archivo,opcion=-1):
    print("\n\n\t....:MENU:....")
    print("1. Ingresar dinero en la cuenta")
    print("2. Retirar dinero de la cuenta")
    print("3. Consultar por los datos")
    print("4. Salir")
    opcion = int(input("Digite una opcion de menu: "))
    if opcion >=1 and opcion <=4:
        if opcion!=4:
            if opcion==1:
                deposito(archivo,lista)
            elif opcion==2:
                retiro(archivo,lista)
            elif opcion==3:
                consultas(lista)
            menu(lista,archivo)
    else:
        print("Opcion invalida, intente otra vez")
        menu(lista,archivo)
    
               

def menuPrin():
    i = input("Ingrese su tarjeta: ")
    with open(i) as f:
        line = csv.reader(f, delimiter=',')
        l = list(line)[0]
    validar(l,0)
    menu(l,i) 
    print("\n\n\t\tGracias por confiar en nosotros :3\t\t\n\n")

def retiro(file, lista):
    if lista[1] == "debito":
        ret = int(input("Cuanto desea retirar de su saldo?: "))
        if ret > int(lista[3]):
            print("Usted no cuenta con esta cantidad para retirar")
        else:
            lista[3] = int(lista[3]) - ret
            print("Ha retirado: ", ret)
            print("Su saldo actual es: ",lista[3])
    
            
    else:
        ret = int(input("Cuanto desea retirar?: "))
        lim = int(lista[4])/2
        cobro = ret* 1.05
        if ret > lim:
            print("El monto solicitado es mayor de lo que su cuenta le permite")
        else:
            lista[2] = float(lista[2]) + cobro
            print("Ha retirado: ", ret)
            print("Se cobro un 5%: ",cobro)
            print("Su consumo actual es: ",lista[2])
    sobreescribir(file,lista)
        
def deposito(file, lista):
    if lista[1] == "debito":
        dep = int(input("Cuanto desea depositar?: "))
        lista[3] = int(lista[3]) + dep    
        print("Ha Depositado: ", dep)
        print("Su saldo actual es: ",lista[3])
                
    else:
        dep = int(input("Cuanto desea depositar?: "))
        lista[2] = float(lista[2]) - dep
        if  int(lista[2]) < 0:
            lista[2] = 0
        print("Ha Depositado: ", dep)
        print("Su saldo a pagar restante es: ",lista[2])
    sobreescribir(file,lista)  

def sobreescribir(a,lista):
    archivo = open(a,'w')
    with archivo:
        writer = csv.writer(archivo)
        writer.writerow(lista)   
        
def consultas(lista):
    if lista[1] == "debito":
        print("Nombre:",lista[5],lista[6])
        print("DNI:",lista[2])
        print("Numero de Tarjeta: ",lista[4])
        print("Saldo:",lista[3])
    else:
        print("Nombre:",lista[6],lista[7])
        print("DNI:",lista[3])
        print("Numero de Tarjeta: ",lista[5])
        print("Su linea de credito es:",lista[4])
        print("Consumo:",lista[2])


def main():
    menuPrin()
if __name__ == "__main__":
    main()