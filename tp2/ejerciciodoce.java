/*
* UTN TUPAD - PROGRAMACION2
* consigna12 - trabajopractico2
* @aldo manfredi 2025-2C
*/
public class ejerciciodoce {
    public static void main(String[] args) {
        double [] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        for (int i = 1; i<=precios.length; i++){
            System.out.println("Precio: $"+ precios[i-1]);
        }
        precios[2] = 129.99;
        System.out.println("Precios modificados:");
        for (int i = 1; i<=precios.length; i++){
            System.out.println("Precio: $"+ precios[i-1]);
        }
    }
}