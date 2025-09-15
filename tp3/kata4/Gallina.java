package kata4;
public class Gallina {
    // Atributos: idGallina, edad, huevosPuestos
    private String idGallina;
    private int edad;
    private int huevosPuestos;

    public String getIdGallina() {
        return idGallina;
    }

    public void setIdGallina(String idGallina) {
        this.idGallina = idGallina;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getHuevosPuestos() {
        return huevosPuestos;
    }

    public void setHuevosPuestos(int huevosPuestos) {
        this.huevosPuestos = huevosPuestos;
    }

    // Métodos: ponerHuevo(), envejecer(), mostrarEstado()
    public void ponerHuevo(){
        this.huevosPuestos++; 
    }

    public void envejecer(){
        this.edad++; // sumo 1 a la edad
    }

    public void mostrarEstado(){
        System.out.println("\n--- Estado actual ---");
        System.out.println("ID gallina: " + idGallina);
        System.out.println("Edad: " + edad);
        System.out.println("Huevos puestos: " + huevosPuestos);
    }
}
