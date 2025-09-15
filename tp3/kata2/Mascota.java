package kata2;
public class Mascota {
    // nombre, especie, edad.
    private String nombre;
    private String especie;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // Métodos requeridos: mostrarInfo(), cumplirAnios().
    public void mostrarInfo(){
        System.out.println("nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("edad: " + edad);
    }

    public int cumplirAnios(){
        int nuevaEdad = edad + 1;
        edad = nuevaEdad;
        return edad;
    }
    
    
}

