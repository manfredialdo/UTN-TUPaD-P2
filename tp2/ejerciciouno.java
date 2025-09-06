/*
* TP2 - UTN TUPAD - PROGRAMACION2
* consigna1 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;

public class ejerciciouno {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese un año: ");
        int anio = sc.nextInt();
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("el año " + anio + " es bisiesto");
        } else {
            System.out.println("el año " + anio + " no es bisiesto");
        }
        sc.close();
    }
}