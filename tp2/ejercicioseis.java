/*
* UTN TUPAD - PROGRAMACION2
* consigna6 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;
public class ejercicioseis {
    public static void main(String[] args) {
        int nroIngresado = 0;
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i<=10; i++){
            System.out.print("Ingrese número " + i + ": ");
            nroIngresado = sc.nextInt();
            if (nroIngresado>0) {
                positivos = positivos+1;
            } else if (nroIngresado<0){
                negativos = negativos+1;
            } else if (nroIngresado==0){
                ceros = ceros+1;
            }
        }
        System.out.print("positivos: " + positivos + "\n");
        System.out.print("negativos: " + negativos + "\n");
        System.out.print("ceros: " + ceros);
        sc.close();
    }
}