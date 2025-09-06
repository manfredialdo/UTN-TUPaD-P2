/*
* UTN TUPAD - PROGRAMACION2
* consigna4 - trabajopractico2
* @aldo manfredi 2025-2C
*/

import java.util.Scanner;

public class ejerciciocuatro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("precio del producto: ");
        double precioOri = sc.nextDouble(); 
        
        System.out.print("categoria (A, B o C): ");
        char cate = sc.next().charAt(0);
        
        double descu = 0.0;
        
        switch (cate) {
            case 'A':
            case 'a':
                descu = 0.10;
                break;
            case 'B':
            case 'b':
                descu = 0.15;
                break;
            case 'C':
            case 'c':
                descu = 0.20;
                break;
            default:
                System.out.println("Cate no valida.");
                break;
        }
        double precioFinal = precioOri - (precioOri * descu);
        
        System.out.println("Precio original: " + precioOri);
        System.out.println("Descuento aplicado: " + (descu * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
        
        sc.close();
    }
}