/*
* UTN TUPAD - PROGRAMACION2
* consigna13 - trabajopractico2
* @aldo manfredi 2025-2C
*/
public class ejerciciotrece {
    private static double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
    public static void main(String[] args) {
        System.out.println("Precios originales:");
        mostrarArrayRecursiva(precios.length - 1);
        precios[2] = 129.99;
        System.out.println("\nPrecios modificados:");
        mostrarArrayRecursiva(precios.length - 1);
    }
    private static void mostrarArrayRecursiva(int i) {
        if (i < 0) {
            return;
        }
        mostrarArrayRecursiva(i - 1);
        System.out.println("Precio: $" + precios[i]);
    }
}