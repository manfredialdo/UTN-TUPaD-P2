import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un Autor.
 */
class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Getter necesario para mostrarAutoresDisponibles()
    public String getNombre() {
        return nombre;
    }

    // Método para mostrar la información del autor
    public void mostrarInfo() {
        System.out.println("    [Autor: " + nombre + " | ID: " + id + " | Nacionalidad: " + nacionalidad + "]");
    }
}

/**
 * Clase que modela un Libro.
 */
class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor; 

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    // Getters necesarios
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitulo() { 
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    // Método para mostrar la información del libro y su autor
    public void mostrarInfo() {
        System.out.println("📚 Titulo: " + titulo);
        System.out.println("   ISBN: " + isbn);
        System.out.println("   Año: " + anioPublicacion);
        autor.mostrarInfo(); 
    }
}

/**
 * Clase Biblioteca (Contenedora).
 * Implementa la relación de Composición 1 a N.
 */
class Biblioteca {
    private String nombre; 
    private List<Libro> libros; 

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>(); 
    }
    
    // Getter necesario para Main
    public String getNombre() {
        return nombre;
    }
    
    // Método auxiliar de Búsqueda
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // MÉTODOS REQUERIDOS

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor); 
        if (buscarLibroPorIsbn(isbn) == null) {
            libros.add(nuevoLibro);
            System.out.println(" Libro '" + titulo + "' agregado a la " + this.nombre + "."); 
        } else {
            System.out.println(" Error: Ya existe un libro con el ISBN " + isbn);
        }
    }

    public void listarLibros() {
        if (libros.size() == 0) { 
            System.out.println("La biblioteca '" + nombre + "' no tiene libros.");
            return;
        }
        System.out.println("\n--- LISTADO DE LIBROS EN: " + nombre.toUpperCase() + " (" + libros.size() + " Total) ---");
        for (Libro libro : libros) {
            libro.mostrarInfo();
            System.out.println("---------------------------------------------");
        }
    }

    public void eliminarLibro(String isbn) {
        Libro libroAEliminar = buscarLibroPorIsbn(isbn);
        if (libroAEliminar != null) {
            libros.remove(libroAEliminar);
            System.out.println(" Libro con ISBN " + isbn + " eliminado con éxito.");
        } else {
            System.out.println("error: No se encontró el libro con ISBN " + isbn + " para eliminar.");
        }
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }
    
    public void mostrarAutoresDisponibles() {
        List<String> autoresUnicos = new ArrayList<>(); 
        
        for (Libro libro : libros) {
            String nombreAutor = libro.getAutor().getNombre();
            
            if (!autoresUnicos.contains(nombreAutor)) { 
                autoresUnicos.add(nombreAutor);
            }
        }
        
        System.out.println("\n--- AUTORES DISPONIBLES EN LA " + nombre.toUpperCase() + " ---");
        
        if (autoresUnicos.size() == 0) { 
            System.out.println("No hay autores registrados.");
            return;
        }
        
        for (String nombreAutor : autoresUnicos) {
            System.out.println(" nombre autor: " + nombreAutor);
        }
        System.out.println("------------------------------------------");
    }
}


/**
 * Clase principal para la ejecución y prueba de los métodos.
 */
public class Main {
    public static void main(String[] args) {
        
        // 1. Creamos una biblioteca.
        Biblioteca bibliotecaCentral = new Biblioteca("Biblioteca Central");
        System.out.println("Iniciando gestión de la " + bibliotecaCentral.getNombre()); 
        System.out.println("----------------------------------------");

        // 2. Crear al menos tres autores
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Jane Austen", "Británica");
        Autor autor3 = new Autor("A003", "Jorge Luis Borges", "Argentina");
        
        // 3. Agregar 5 libros asociados a alguno de los Autores a la biblioteca.
        bibliotecaCentral.agregarLibro("978-0307474728", "Cien años de soledad", 1967, autor1);
        bibliotecaCentral.agregarLibro("978-0141439518", "Orgullo y Prejuicio", 1813, autor2);
        bibliotecaCentral.agregarLibro("978-0307474735", "El amor en los tiempos del cólera", 1985, autor1);
        bibliotecaCentral.agregarLibro("978-0140285741", "Ficciones", 1944, autor3);
        bibliotecaCentral.agregarLibro("978-0141439525", "Sentido y Sensibilidad", 1811, autor2);


        // 4. Listar todos los libros con su información y la del autor.
        bibliotecaCentral.listarLibros();
        
        // 5. Buscar un libro por su ISBN y mostrar su información.
        String isbnBuscado = "978-0140285741";
        Libro libroEncontrado = bibliotecaCentral.buscarLibroPorIsbn(isbnBuscado);
        System.out.println("\n--- BÚSQUEDA POR ISBN: " + isbnBuscado + " ---");
        if (libroEncontrado != null) {
            libroEncontrado.mostrarInfo();
        } else {
            System.out.println("Libro no encontrado.");
        }
        
        // 6. Filtrar y mostrar los libros publicados en un año específico.
        int anioFiltro = 1813;
        List<Libro> libros1813 = bibliotecaCentral.filtrarLibrosPorAnio(anioFiltro);
        System.out.println("\n--- FILTRO POR AÑO: " + anioFiltro + " ---");
        if (libros1813.size() == 0) { // Usando size()
            System.out.println("No se encontraron libros de ese año.");
        } else {
            for (Libro libro : libros1813) {
                System.out.println("- " + libro.getTitulo() + " por " + libro.getAutor().getNombre());
            }
        }
        
        // 7. Eliminar un libro por su ISBN y listar los libros restantes.
        bibliotecaCentral.eliminarLibro("978-0141439525");
        
        // 8. Mostrar la cantidad total de libros en la biblioteca.
        System.out.println("\n🔢 Cantidad total de libros restantes: " + bibliotecaCentral.obtenerCantidadLibros());
        
        // 9. Listar todos los autores de los libros disponibles en la biblioteca.
        bibliotecaCentral.mostrarAutoresDisponibles();
    }
}
