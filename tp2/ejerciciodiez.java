/*
* UTN TUPAD - PROGRAMACION2
* consigna10 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;
public class ejerciciodiez {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int StockActual;
        int CantidadVendida;
        int CantidadRecibida;
        
        System.out.println("Ingrese el stock actual del producto: ");
        StockActual = sc.nextInt();
        System.out.println("Ingrese la cantidad vendida: ");
        CantidadVendida = sc.nextInt();
        System.out.println("Ingrese la cantidad recibida: ");
        CantidadRecibida = sc.nextInt();

        int nuevoStock = actualizarStock(StockActual, CantidadVendida, CantidadRecibida);
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
        sc.close();
    }
    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        int nuevoStock = stockActual - cantidadVendida + cantidadRecibida;
        return nuevoStock;
    }
}