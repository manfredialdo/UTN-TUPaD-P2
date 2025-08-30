package trabajopractico1programacion2;

/*
 * TP1 - UTN TUPADTP2- PROGRAMACION2 - 
 * consigna5 - trabajopractico1 programacion2 
 * @aldo manfredi 2025-2C
*/

import java.util.Scanner;
public class tp1app005 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" ingrese primer nro: ");
        int nro1 = scanner.nextInt();

        System.out.print(" ingrese segundo nro: ");
        int nro2 = scanner.nextInt();

        System.out.println("la suma es " + (nro1 + nro2));
        System.out.println("la resta es " + (nro1 - nro2));
        System.out.println("la multi es " + (nro1 * nro2));
        System.out.println("la divi es " + (nro1 / nro2));
    }
}