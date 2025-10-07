// Clase 1: Pasaporte - Contiene (Composición) y Asocia (Bidireccional)
class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto;          // Composición 1:1 (La Foto se crea aquí)
    private Titular titular;    // Asociación 1:1 (El Titular se establece desde afuera)

    // Constructor que maneja la Composición
    public Pasaporte(String numero, String fechaEmision, String imagen, String formato) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        // 1a. Composición: Crea la Foto internamente.
        this.foto = new Foto(imagen, formato); 
    }

    // Setter para la Asociación Bidireccional
    public void setTitular(Titular titular) {
        // Asegura que la asociación se establezca en ambos sentidos.
        if (this.titular != titular) {
            this.titular = titular;
            if (titular != null) {
                titular.setPasaporte(this);
            }
        }
    }

    public void mostrarDetalles() {
        String nombreTitular = (titular != null) ? titular.getNombre() : "Sin Titular";
        System.out.println("--- DETALLES DEL PASAPORTE ---");
        System.out.println("Número: " + numero);
        System.out.println("Fecha de Emisión: " + fechaEmision);
        System.out.println("Titular Asociado: " + nombreTitular);
        // Muestra los detalles de la Foto (Composición)
        System.out.println("Detalles de la Foto: " + foto.getImagen() + " (" + foto.getFormato() + ")");
        System.out.println("---------------------------------");
    }
    
    // Getters necesarios para la Asociación bidireccional
    public String getNumero() { return numero; }
    public Titular getTitular() { return titular; } 
}

// Clase 2: Foto - Parte de la Composición
class Foto {
    private String imagen;
    private String formato;

    // Se crea SOLO con los datos proporcionados por Pasaporte.
    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    public String getImagen() { return imagen; }
    public String getFormato() { return formato; }
}

// Clase 3: Titular - Parte de la Asociación Bidireccional
class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // Asociación 1:1 (Puede o no tener Pasaporte)

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    // Setter para la Asociación Bidireccional
    public void setPasaporte(Pasaporte pasaporte) {
        // Asegura que la asociación se establezca en ambos sentidos.
        if (this.pasaporte != pasaporte) {
            this.pasaporte = pasaporte;
            if (pasaporte != null) {
                pasaporte.setTitular(this);
            }
        }
    }

    public void mostrarTitularidad() {
        String numPasaporte = (pasaporte != null) ? pasaporte.getNumero() : "No tiene Pasaporte";
        System.out.println("--- DETALLES DEL TITULAR ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Pasaporte Asignado: " + numPasaporte);
        System.out.println("------------------------------");
    }
    
    // Getters necesarios
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}


// Clase Principal para la ejecución
public class Main {
    public static void main(String[] args) {
        // 1. CREAR OBJETOS INDEPENDIENTES (para la Asociación)        
        // Creación del Titular. Existe sin necesidad de un pasaporte.
        Titular titular1 = new Titular("Juan Pérez", "12345678A");
        // Creación del Pasaporte. Internamente crea la Foto (Composición).
        Pasaporte pasaporte1 = new Pasaporte("XYZ987654", "2025-01-15", "Rostro fondo blanco", "JPEG");

        // 2. ESTABLECER ASOCIACIÓN BIDIRECCIONAL ↔        
        // Asociamos el Pasaporte al Titular.
        // El método setTitular() se encarga de enlazar ambos objetos.
        pasaporte1.setTitular(titular1);

        // 3. UTILIZAR LAS RELACIONES        
        System.out.println("VERIFICACIÓN DE RELACIONES:");        
        // Verificación 1: Muestra los detalles del Pasaporte, incluyendo la Foto (Composición) y el Titular (Asociación).
        pasaporte1.mostrarDetalles(); 
        // Verificación 2: Muestra los detalles del Titular, incluyendo el Pasaporte asociado.
        titular1.mostrarTitularidad(); 
    }
}
