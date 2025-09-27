public class Main {
    public static void main(String[] args) {
        // 1. Crear el Titular (puede existir independientemente del Pasaporte)
        Titular juan = new Titular("Juan Pérez", "30.123.456");

        // 2. Crear el Pasaporte:
        //    - Esto crea automáticamente el objeto Foto (Composición).
        //    - Esto establece la relación bidireccional con el Titular.
        Pasaporte pasaporteJuan = new Pasaporte(
            "ABC12345", 
            "2025-09-26", 
            "imagen_escaneada_con_fondo_blanco", 
            "JPG", 
            juan
        );

        // Verificación de las relaciones
        System.out.println("--- PRUEBA DE RELACIONES ---");
        
        // Pasaporte -> Foto (Composición Unidireccional)
        System.out.println("Pasaporte creado: " + pasaporteJuan);

        // Pasaporte -> Titular (Asociación Bidireccional)
        System.out.println("Titular asociado: " + pasaporteJuan.titular.getNombre());
        
        // Titular -> Pasaporte (Asociación Bidireccional - Enlace inverso)
        // El Titular puede acceder a la información de su Pasaporte.
        System.out.println("Titular conoce su Pasaporte: " + juan.toString());
    }
}
