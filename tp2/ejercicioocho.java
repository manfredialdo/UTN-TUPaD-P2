/*
* UTN TUPAD - PROGRAMACION2
* consigna8 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;
public class ejercicioocho {
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        double impuestoDecimal = impuesto / 100.0;
        double descuentoDecimal = descuento / 100.0;
        double precioFinal = precioBase + (precioBase * impuestoDecimal) - (precioBase * descuentoDecimal);
        return precioFinal;
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioBase;
        double impuesto;
        double descuento;
        System.out.println("Ingrese el precio base del producto: ");
        precioBase = sc.nextDouble();
        System.out.println("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        impuesto = sc.nextDouble();
        System.out.println("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        descuento = sc.nextDouble();
        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);
        System.out.println("El precio final del producto es: " + precioFinal);
        sc.close();
    }
}