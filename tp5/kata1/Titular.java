public class Titular {
    private String nombre; 
    private String dni; 

    // Relación Bidireccional: Referencia a Pasaporte
    private Pasaporte pasaporte; 

    // Constructor
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    // Setter para establecer la relación bidireccional (enlace inverso)
    // Es clave en esta asociación bidireccional.
    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    // Método toString
    @Override
    public String toString() {
        String infoPasaporte = (pasaporte != null) ? ", Pasaporte Nro: " + pasaporte.getNumero() : "";
        return "Titular [Nombre: " + nombre + ", DNI: " + dni + infoPasaporte + "]";
    }
}
