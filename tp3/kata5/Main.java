package kata5;
public class Main {
    public static void main(String[] args) {
        // Tarea: Crear una nave. Java usa el constructor por defecto.
        NaveEspacial miNave = new NaveEspacial();
        miNave.setNombre("lucrecia");
        miNave.mostrarEstado();
        miNave.avanzar(60);
        miNave.recargarCombustible(50);
        miNave.avanzar(60);
        miNave.recargarCombustible(20);
        miNave.mostrarEstado();
    }
}

