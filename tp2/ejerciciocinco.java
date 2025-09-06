/*
* UTN TUPAD - PROGRAMACION2
* consigna5 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;

public class ejerciciocinco {
    public static void main(String[] args) {
        int nroIngresado = 0;
        int acumulador = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número (0 para terminar): ");
        nroIngresado = sc.nextInt();
        while (nroIngresado != 0) {
            if (nroIngresado % 2 == 0) {
                acumulador = acumulador + nroIngresado;
            }
            System.out.print("Ingrese otro número (0 para terminar): ");
            nroIngresado = sc.nextInt();
        }
        System.out.println("La suma de los números pares ingresados es: " + acumulador);
        sc.close();
    }
}