package kata2;
public class Main {

    public static void main(String[] args) {
        Mascota mascota1 = new Mascota();
        mascota1.setNombre("leopoldo");
        mascota1.setEspecie("gato");
        mascota1.setEdad(3);
        mascota1.mostrarInfo();
        
        mascota1.cumplirAnios();
        mascota1.mostrarInfo();        
        
    }
}
