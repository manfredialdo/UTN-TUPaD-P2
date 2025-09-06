/*
* UTN TUPAD - PROGRAMACION2
* consigna9 - trabajopractico2
* @aldo manfredi 2025-2C
*/
import java.util.Scanner;

public class ejercicionueve {
    
    public static double calcularCostoEnvio(double peso, String zona) {
        double costoBase = 0.0;
        if (zona.equalsIgnoreCase("Nacional")) {
            costoBase = 5.0;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            costoBase = 10.0;
        } else {
            System.out.println("Zona de envío no válida. El costo de envío será 0.");
            costoBase = 0.0;
        }
        
        return peso * costoBase;
    }
    
    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double peso;
        double precio;
        String zona;
        double costoEnvio;
        double totalCompra;
        
        System.out.println("Ingrese el precio del producto: ");
        precio = sc.nextDouble();        
        System.out.println("Ingrese el peso del paquete en kg: ");
        peso = sc.nextDouble();        
        sc.nextLine();         
        System.out.println("Ingrese la zona de envío (Nacional/Internacional): ");
        zona = sc.nextLine();
        
        costoEnvio = calcularCostoEnvio(peso, zona);
        totalCompra = calcularTotalCompra(precio, costoEnvio);
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + totalCompra);
        sc.close();
    }
}