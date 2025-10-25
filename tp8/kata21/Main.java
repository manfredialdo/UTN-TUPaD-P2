import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Solicita dos números al usuario y realiza la división, manejando
     * ArithmeticException (división por cero) y InputMismatchException 
     * (entrada no numérica).
     */
    public static void divisionSegura() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("\n--- INICIO: División Segura ---");
            System.out.print("Introduce el numerador (entero): ");
            int numerador = scanner.nextInt(); // Puede lanzar InputMismatchException
            
            System.out.print("Introduce el divisor (entero): ");
            int divisor = scanner.nextInt(); // Puede lanzar InputMismatchException

            // Bloque donde puede ocurrir la excepción verificada (ArithmeticException)
            int resultado = numerador / divisor; 
            
            System.out.println("Resultado de la división: " + resultado);

        } catch (ArithmeticException e) {
            // Manejo de la excepción de división por cero
            System.err.println("Error: ¡No se puede dividir un número entre cero!");
            System.err.println("Detalles del error: " + e.getMessage());
            
        } catch (InputMismatchException e) {
            // Manejo de la excepción si el usuario ingresa algo que no es un entero
            System.err.println(" Error: Entrada inválida. Debes ingresar un número entero.");
            scanner.nextLine(); // Limpiar el buffer del scanner
            
        } finally {
            // El bloque finally se ejecuta siempre, pero cerraremos el scanner 
            // solo al final de toda la aplicación para evitar problemas.
            // Para fines de la demostración del método, solo mostramos el fin.
            System.out.println("--- FIN: División Segura ---");
        }
    }

    public static void main(String[] args) {
        // Ejecutamos la función de división
        divisionSegura();
        
        System.out.println("\nEl programa principal continúa su ejecución.");
    }
}
