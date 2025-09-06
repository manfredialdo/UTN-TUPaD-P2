/*
* TP2 - UTN TUPAD - PROGRAMACION2
* consigna2 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;
public class ejerciciodos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("ingrese un nro: ");
        int nro1 = sc.nextInt();
        System.out.print("ingrese otro nro: ");
        int nro2 = sc.nextInt();
        System.out.print("ingrese otro nro: ");
        int nro3 = sc.nextInt();
        
        if (nro1 > nro2 && nro1>nro3) {
            System.out.println("el numero " + nro1 + " es el mayot de entre los tres numeros");
        } else if (nro2 > nro1 && nro2>nro3){
            System.out.println("el numero " + nro2 + " es el mayot de entre los tres numeros");
        } else if (nro3 > nro1 && nro3>nro2){
            System.out.println("el numero " + nro3 + " es el mayot de entre los tres numeros");
        } else {
            System.out.println("operacion invalida.. repita las entradas con distintos numeros");
        }
        sc.close();  
    }
}