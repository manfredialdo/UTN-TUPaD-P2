package kata1;
public class Main {
    public static void main(String[] args) {

        Estudiante p1 = new Estudiante();
        p1.setNombre("juan");
        p1.setApellido("zamora");
        p1.setCurso("bbdd");
        p1.setCalificacion(7.5);
        // funciones: Métodos requeridos: mostrarInfo(), subirCalificacion(puntos), bajarCalificacion(puntos).
        p1.mostrarInfo();
        
        p1.subirCalificacion(2.2);
        p1.mostrarInfo();

        p1.bajarCalificacion(5.2);
        p1.mostrarInfo();
        
    }
}
