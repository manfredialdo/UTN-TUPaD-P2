package trabajopractico1programacion2;

/*
 * TP1 - UTN TUPADTP2- PROGRAMACION2 - 
 * consigna9 - trabajopractico1 programacion2 
 * @aldo manfredi 2025-2C
*/
import java.util.Scanner;
public class ErrorEjemplo {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Ingresa tu nombre: ");
String nombre = scanner.nextLine(); // es nextLine()
System.out.println("Hola, " + nombre);
}
}
