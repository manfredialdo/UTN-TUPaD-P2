public class Pasaporte {
    private String numero; 
    private String fechaEmision; 

    // 1. RELACIÓN DE COMPOSICIÓN (Foto es creada y contenida)
    private Foto foto; 

    // 2. RELACIÓN DE ASOCIACIÓN BIDIRECCIONAL (Titular)
    private Titular titular; 

    // Constructor: Establece ambas relaciones al crear el Pasaporte
    public Pasaporte(String numero, String fechaEmision, String imgFoto, String formatoFoto, Titular titular) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        
        // Composición: Creación de la Foto
        this.foto = new Foto(imgFoto, formatoFoto);
        
        // Asociación: Establecimiento del Titular y el enlace inverso
        this.titular = titular;
        this.titular.setPasaporte(this); // Establece el vínculo bidireccional
    }

    // --- GETTERS y SETTERS ---

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    // Getter para la Foto (Composición)
    public Foto getFoto() {
        return foto;
    }

    // Setter para la Foto. (Aunque es composición, se incluye el setter para completitud, 
    // pero en un diseño estricto de composición, este setter se evitaría o restringiría.)
    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    // Getter para el Titular (Asociación)
    public Titular getTitular() {
        return titular;
    }

    // Setter para el Titular. (Al cambiar el titular, se debe gestionar la bidireccionalidad).
    public void setTitular(Titular nuevoTitular) {
        // Opción 1: Desvincular el Titular antiguo (si existe)
        if (this.titular != null) {
            this.titular.setPasaporte(null);
        }
        
        // Opción 2: Asignar el nuevo Titular y establecer el enlace inverso.
        this.titular = nuevoTitular;
        if (nuevoTitular != null) {
            nuevoTitular.setPasaporte(this);
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Pasaporte [Nro: " + numero + ", Emisión: " + fechaEmision + 
               ", Titular: " + titular.getNombre() + 
               ", Contiene: " + foto.toString() + "]";
    }
}
