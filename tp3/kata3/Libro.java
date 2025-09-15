//
// Crear una clase Libro con atributos privados: titulo, autor, añoPublicacion.
//Métodos requeridos: Getters para todos los atributos. Setter con validación para añoPublicacion.
//
package kata3;
import java.time.Year;
public class Libro {   
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        int añoActual = Year.now().getValue();
        if (añoPublicacion > 0 && añoPublicacion <= añoActual) {
            this.añoPublicacion = añoPublicacion;
        } else {
            System.err.println("Error: El año de publicación no es válido.");
        }
    }
    
    public void mostrarInfo(){
        System.out.println("Info solicitada:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + añoPublicacion);
    }
}
