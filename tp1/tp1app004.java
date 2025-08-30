package trabajopractico1programacion2;

/*
 * TP1 - UTN TUPADTP2- PROGRAMACION2 - 
 * consigna4 - trabajopractico1 programacion2 
 * @aldo manfredi 2025-2C
*/

import java.util.Scanner;
public class tp1app004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" tu nombre: ");
        String nombre = scanner.nextLine(); 
        System.out.print(" tu edad: ");
        int edad = scanner.nextInt();
        scanner.close();
        System.out.println("tu nombre es " + nombre + "!");
        System.out.println("y tenes " + edad + " años.");
    }
}