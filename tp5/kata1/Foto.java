public class Foto {
    private String imagen; 
    private String formato; 

    // Constructor
    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    // --- GETTERS y SETTERS ---
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    // Método toString
    @Override
    public String toString() {
        return "Foto [Formato: " + formato + ", Imagen: " + imagen.substring(0, 10) + "...]";
    }
}
