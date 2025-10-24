import java.util.ArrayList;
import java.util.List;

/**
 * Enumeración para representar las categorías de productos.
 */
enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");

    private final String descripcion;

    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

// =======================================================
// CLASE PRODUCTO (Asociación con CategoriaProducto)
// =======================================================
class Producto {
    private final String id; 
    private final String nombre;
    private final double precio; 
    private int cantidad; // El único atributo mutable
    private final CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        // Validación básica
        if (precio <= 0 || cantidad < 0) {
            // En una aplicación real se usaría excepción, aquí se usa un mensaje simple y default.
             System.out.println("Advertencia: Precio debe ser positivo y cantidad no negativa. Usando valores por defecto.");
             this.precio = (precio <= 0) ? 0.01 : precio;
             this.cantidad = (cantidad < 0) ? 0 : cantidad;
        } else {
             this.precio = precio;
             this.cantidad = cantidad;
        }
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public CategoriaProducto getCategoria() { return categoria; }
    
    // Setter (único para el atributo mutable)
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            System.out.println("⚠️ Advertencia: No se puede establecer una cantidad negativa. Stock no modificado.");
            return;
        }
        this.cantidad = cantidad;
    }

    /**
     * Sobrescribe toString() para una mejor representación del objeto.
     */
    @Override
    public String toString() {
        return String.format(
            "| ID: %s | Nombre: %s | Precio: $%.2f | Stock: %d | Categoría: %s (%s)",
            id, nombre, precio, cantidad, categoria.name(), categoria.getDescripcion()
        );
    }
}

// =======================================================
// CLASE INVENTARIO (Agregación de Producto)
// =======================================================

/**
 * Clase Inventario para gestionar la colección dinámica de productos (Agregación).
 */
class Inventario {
    // Declaración usando la interfaz List (buena práctica)
    private final List<Producto> productos;

    public Inventario() {
        // Uso de ArrayList como implementación concreta
        this.productos = new ArrayList<>();
    }

    /** * Agrega un producto si su ID no existe.
     */
    public void agregarProducto(Producto p) {
        if (p == null) {
            System.out.println("ERROR: El producto a agregar no puede ser nulo.");
            return;
        }
        if (buscarProductoPorId(p.getId()) == null) {
            productos.add(p);
            System.out.println("Producto '" + p.getNombre() + "' agregado al inventario.");
        } else {
            System.out.println("ERROR: Ya existe un producto con el ID: " + p.getId());
        }
    }

    /** * Lista todos los productos utilizando el método toString().
     */
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("\n--- LISTA COMPLETA DE PRODUCTOS (" + productos.size() + ") ---");
        for (Producto p : productos) {
            System.out.println(p); 
        }
        System.out.println("----------------------------------------------");
    }

    /** * Busca un producto por ID.
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /** * Elimina un producto por ID.
     */
    public void eliminarProducto(String id) {
        Producto productoAEliminar = buscarProductoPorId(id);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar); 
            System.out.println("Producto con ID " + id + " (" + productoAEliminar.getNombre() + ") eliminado con éxito.");
        } else {
            System.out.println("ERROR: No se encontró el producto con ID " + id + " para eliminar.");
        }
    }

    /** * Actualiza el stock de un producto por ID.
     */
    public void actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            int stockAnterior = p.getCantidad();
            p.setCantidad(nuevaCantidad);
            if (p.getCantidad() != stockAnterior) { 
                System.out.println("Stock de '" + p.getNombre() + "' actualizado: de " + stockAnterior + " a " + nuevaCantidad + ".");
            }
        } else {
            System.out.println("ERROR: Producto con ID " + id + " no encontrado para actualizar stock.");
        }
    }

    /** * Filtra productos por categoría.
     * @return Una nueva lista con los productos filtrados.
     */
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    /** * Calcula el stock total de todo el inventario.
     */
    public int obtenerTotalStock() {
        int totalStock = 0;
        for (Producto p : productos) {
            totalStock += p.getCantidad();
        }
        return totalStock;
    }

    /** * Refactorizado: Obtiene el producto con la mayor cantidad de stock
     * utilizando un bucle for-each manual, ya que Collections.max() no está permitido.
     */
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }

        // Inicializar el producto con mayor stock con el primer elemento
        Producto mayorStock = productos.get(0); 

        // Recorrer el resto de la lista para encontrar el máximo
        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }
        return mayorStock; 
    }

    /** * Filtra productos dentro de un rango de precio.
     * @return Una nueva lista con los productos filtrados.
     */
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        List<Producto> filtrados = new ArrayList<>();
        // Asegurar que el rango esté ordenado
        double inicio = Math.min(min, max);
        double fin = Math.max(min, max);
        
        for (Producto p : productos) {
            if (p.getPrecio() >= inicio && p.getPrecio() <= fin) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
    
    /** * Muestra las categorías disponibles.
     */
    public void mostrarCategoriasDisponibles() {
        System.out.println("\n---CATEGORÍAS DISPONIBLES ---");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println("- " + cat.name() + ": " + cat.getDescripcion());
        }
    }
}

// =======================================================
// CLASE MAIN (Uso y Pruebas)
// =======================================================

/**
 * Clase principal para la ejecución y prueba de los métodos.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Inicialización
        Inventario tienda = new Inventario();
        tienda.mostrarCategoriasDisponibles();

        // 2. Agregar productos
        System.out.println("\n--- AGREGANDO PRODUCTOS ---");
        tienda.agregarProducto(new Producto("P001", "parlante blutu ", 1200.50, 5, CategoriaProducto.ELECTRONICA));
        tienda.agregarProducto(new Producto("P002", "chomba y llor ", 25.00, 50, CategoriaProducto.ROPA));
        tienda.agregarProducto(new Producto("P003", "Harina de mandioca ", 1.20, 200, CategoriaProducto.ALIMENTOS));
        tienda.agregarProducto(new Producto("P004", "Modular", 550.00, 10, CategoriaProducto.HOGAR));
        tienda.agregarProducto(new Producto("P005", " celular X", 800.00, 15, CategoriaProducto.ELECTRONICA));
        tienda.agregarProducto(new Producto("P006", "Silla bebe ", 150.00, 25, CategoriaProducto.HOGAR));
        tienda.agregarProducto(new Producto("P001", "Duplicado ID", 10.00, 1, CategoriaProducto.ALIMENTOS)); 

        // 3. Listar todos los productos
        tienda.listarProductos();

        // 4. Búsqueda y Actualización
        System.out.println("\n--- BÚSQUEDA Y ACTUALIZACIÓN ---");
        Producto buscado = tienda.buscarProductoPorId("P003");
        if (buscado != null) {
            System.out.println("Producto P003 encontrado: " + buscado.getNombre());
        }

        tienda.actualizarStock("P003", 150); 
        tienda.actualizarStock("P999", 10); 
        
        // 5. Filtrado por Categoría
        System.out.println("\n--- 🔬 FILTRADO: ELECTRONICA ---");
        List<Producto> electronica = tienda.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        for (Producto p : electronica) {
            System.out.println("-> " + p);
        }

        // 6. Obtener estadísticas simples
        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Total Stock del Inventario: " + tienda.obtenerTotalStock());

        Producto mayorStock = tienda.obtenerProductoConMayorStock(); 
        if (mayorStock != null) {
            System.out.println("Producto con Mayor Stock: " + mayorStock.getNombre() + " (" + mayorStock.getCantidad() + " unidades)");
        }
        
        // 7. Filtrar por Rango de Precio
        System.out.println("\n--- FILTRADO: Rango de Precio $100 a $600 ---");
        List<Producto> porPrecio = tienda.filtrarProductosPorPrecio(100.00, 600.00);
        for (Producto p : porPrecio) {
            System.out.println("-> " + p.getNombre() + " ($" + p.getPrecio() + ")"); 
        }

        // 8. Eliminación
        System.out.println("\n--- ELIMINACIÓN ---");
        tienda.eliminarProducto("P001");
        tienda.listarProductos();
    }
}
