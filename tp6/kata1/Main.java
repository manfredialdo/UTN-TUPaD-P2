import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
// * Enumeración para representar las categorías de productos.
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

/**
 * Clase que modela un Producto.
 */
class Producto implements Comparable<Producto> {
    private String id;
    private String nombre;
    private double precio; // Atributo privado
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
    // Método mostrarInfo()
    public void mostrarInfo() {
        System.out.println("--- Producto: " + nombre + " ---");
        System.out.println("  ID: " + id);
        System.out.println("  Precio: $" + precio);
        System.out.println("  Stock: " + cantidad);
        System.out.println("  Categoría: " + categoria.getDescripcion());
    }

    /**
     * Implementación de Comparable para el algoritmo de obtener el Producto con Mayor Stock.
     */
    @Override
    public int compareTo(Producto otro) {
        // Ordena por cantidad de stock (mayor stock primero)
        return Integer.compare(this.cantidad, otro.cantidad);
    }
}

/**
 * Clase Inventario para gestionar la colección dinámica de productos (ArrayList). */
class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Métodos requeridos:

    public void agregarProducto(Producto p) {
        if (buscarProductoPorId(p.getId()) == null) {
            productos.add(p);
            System.out.println(" Producto '" + p.getNombre() + "' agregado al inventario.");
        } else {
            System.out.println(" ERROR: Ya existe un producto con el ID: " + p.getId());
        }
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("️ El inventario está vacío.");
            return;
        }
        System.out.println("\n--- LISTA COMPLETA DE PRODUCTOS ---");
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(String id) {
        Producto productoAEliminar = buscarProductoPorId(id);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("️ Producto con ID " + id + " eliminado con éxito.");
        } else {
            System.out.println(" ERROR: No se encontró el producto con ID " + id + " para eliminar.");
        }
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println(" Stock de '" + p.getNombre() + "' actualizado a " + nuevaCantidad + ".");
        } else {
            System.out.println(" ERROR: Producto con ID " + id + " no encontrado para actualizar stock.");
        }
    }

    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    public int obtenerTotalStock() {
        int totalStock = 0;
        for (Producto p : productos) {
            totalStock += p.getCantidad(); // Sumatoria
        }
        return totalStock;
    }

    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }
        return Collections.max(productos); 
    }

    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) { 
                filtrados.add(p);
            }
        }
        return filtrados;
    }
    
    public void mostrarCategoriasDisponibles() {
        System.out.println("\n--- CATEGORÍAS DISPONIBLES ---");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println("- " + cat.name() + ": " + cat.getDescripcion());
        }
    }
}
/**
 * Clase principal para la ejecución y prueba de los métodos. */
public class Main {
    public static void main(String[] args) {
        // 1. Inicialización
        Inventario tienda = new Inventario();
        tienda.mostrarCategoriasDisponibles();

        // 2. Agregar productos
        tienda.agregarProducto(new Producto("P001", "Laptop Gamer", 1200.50, 5, CategoriaProducto.ELECTRONICA));
        tienda.agregarProducto(new Producto("P002", "Camiseta Algodón", 25.00, 50, CategoriaProducto.ROPA));
        tienda.agregarProducto(new Producto("P003", "Harina de Trigo", 1.20, 200, CategoriaProducto.ALIMENTOS));
        tienda.agregarProducto(new Producto("P004", "Sofá Modular", 550.00, 10, CategoriaProducto.HOGAR));
        tienda.agregarProducto(new Producto("P005", "Smartphone X", 800.00, 15, CategoriaProducto.ELECTRONICA));
        tienda.agregarProducto(new Producto("P006", "Silla Ergonómica", 150.00, 25, CategoriaProducto.HOGAR));

        // 3. Listar todos los productos
        tienda.listarProductos();

        // 4. Búsqueda y Actualización
        Producto buscado = tienda.buscarProductoPorId("P003");
        if (buscado != null) {
            System.out.println("Producto P003 encontrado: " + buscado.getNombre());
        }

        tienda.actualizarStock("P003", 150); // Búsqueda y modificación
        tienda.actualizarStock("P999", 10); // Prueba de error

        // 5. Filtrado por Categoría (Uso de Enum)
        System.out.println("\n--- FILTRADO: ELECTRONICA ---");
        List<Producto> electronica = tienda.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        for (Producto p : electronica) {
            p.mostrarInfo();
        }

        // 6. Obtener estadísticas simples
        System.out.println(" Total Stock del Inventario: " + tienda.obtenerTotalStock());

        Producto mayorStock = tienda.obtenerProductoConMayorStock(); // Algoritmo Máximo
        if (mayorStock != null) {
            System.out.println(" Producto con Mayor Stock: " + mayorStock.getNombre() + " (" + mayorStock.getCantidad() + " unidades)");
        }
        
        // 7. Filtrar por Rango de Precio
        System.out.println("\n--- FILTRADO: Rango de Precio $100 a $600 ---");
        List<Producto> porPrecio = tienda.filtrarProductosPorPrecio(100.00, 600.00);
        for (Producto p : porPrecio) {
            System.out.println("-> " + p.getNombre() + " ($" + p.getPrecio() + ")"); 
        }

        // 8. Eliminación
        tienda.eliminarProducto("P001");
        tienda.listarProductos();
    }
}
