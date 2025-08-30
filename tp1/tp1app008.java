package trabajopractico1programacion2;

/*
 * TP1 - UTN TUPADTP2- PROGRAMACION2 - 
 * consigna8 - trabajopractico1 programacion2 
 * @aldo manfredi 2025-2C
*/
import java.util.Scanner;
public class tp1app008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" ingrese primer nro: ");
        double nro1 = scanner.nextDouble();

        System.out.print(" ingrese segundo nro: ");
        double nro2 = scanner.nextDouble();

        System.out.println("la divi es " + (nro1 / nro2));
    }
}