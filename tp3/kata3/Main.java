package kata3;
public class Main {
    public static void main(String[] args) {
        Libro miLibro = new Libro();
        miLibro.setTitulo("rayuela");
        miLibro.setAutor("cortazar");
        miLibro.setAñoPublicacion(1934);
        miLibro.mostrarInfo();
        
        System.out.println("\n--- Probando validación del año ---");
        miLibro.setAñoPublicacion(2050); // Intento de valor inválido
        miLibro.mostrarInfo();
    }
}
