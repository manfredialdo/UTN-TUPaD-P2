
/*
ECommerceSystem.java

Parte 1: Interfaces en un sistema de E-commerce
1. Crear una interfaz Pagable con el método calcularTotal().
2. Clase Producto: tiene nombre y precio, implementa Pagable.
3. Clase Pedido: tiene una lista de productos, implementa Pagable y calcula el
total del pedido.
4. Ampliar con interfaces Pago y PagoConDescuento para distintos medios de
pago (TarjetaCredito, PayPal), con métodos procesarPago(double) y
aplicarDescuento(double).
5. Crear una interfaz Notificable para notificar cambios de estado. La clase
Cliente implementa dicha interfaz y Pedido debe notificarlo al cambiar de
estado.
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// ************************************************************
// 1. DEFINICIÓN DE CONTRATOS (INTERFACES)
// ************************************************************

interface Pagable {
    double calcularTotal();
}

interface Pago {
    void procesarPago(double monto); 
}

interface PagoConDescuento extends Pago {
    // Herencia de interfaces: combina Pago con esta funcionalidad
    double aplicarDescuento(double total);
}

interface Notificable {
    void notificar(String mensaje);
}

// ************************************************************
// 2. CLASES BASE E IMPLEMENTACIÓN DE INTERFACES
// ************************************************************

class Producto implements Pagable {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        if (precio <= 0) {
            // Uso de 'throw' con una excepción no verificada (IllegalArgumentException)
            throw new IllegalArgumentException("El precio del producto debe ser positivo.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double calcularTotal() {
        return this.precio;
    }
}

class Cliente implements Notificable {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación a " + nombre + ": " + mensaje);
    }
}

class TarjetaCredito implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con Tarjeta de Crédito procesado. Monto: $" + monto);
    }
}

class PayPal implements PagoConDescuento {
    private static final double DESCUENTO_WEB = 0.10; // 10% de descuento

    @Override
    public double aplicarDescuento(double total) {
        double descuento = total * DESCUENTO_WEB;
        System.out.printf(" Descuento PayPal aplicado: $%.2f%n", descuento);
        return total - descuento;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con PayPal procesado. Monto final: $" + monto);
    }
}

// ************************************************************
// 3. CLASE PEDIDO Y EXCEPCIÓN PERSONALIZADA
// ************************************************************

class Pedido implements Pagable { // Herencia múltiple de comportamiento
    private List<Producto> productos;
    private Cliente cliente; 
    private String estado;

    public Pedido(Cliente cliente) {
        this.productos = new ArrayList<>();
        this.cliente = cliente;
        this.estado = "PENDIENTE";
        this.cliente.notificar("Pedido creado y en estado: " + this.estado);
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }
    
    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        this.cliente.notificar("El estado de su pedido ha cambiado a: " + nuevoEstado);
    }
}

// 5. Excepción Personalizada (RuntimeException, unchecked)
class ObjetoNuloException extends RuntimeException {
    public ObjetoNuloException(String mensaje) {
        super(mensaje);
    }
}


// ************************************************************
// 4. CLASE PRINCIPAL Y EJECUCIÓN (try-catch, throw y throws)
// ************************************************************

public class ECommerceSystem {

    // Uso de 'throws' para declarar una excepción verificada (checked exception)
    public static void simularPagoAPI(Pago medioPago, double monto) throws IOException { 
        System.out.println("\n--- Iniciando conexión a API de pago...");
        
        if (monto < 1) {
             // Uso de 'throw' para lanzar una excepción verificada (checked)
             throw new IOException("El monto de pago es insuficiente."); 
        }

        if (medioPago instanceof PagoConDescuento) {
            PagoConDescuento pcd = (PagoConDescuento) medioPago;
            double montoConDescuento = pcd.aplicarDescuento(monto);
            medioPago.procesarPago(montoConDescuento);
        } else {
            medioPago.procesarPago(monto);
        }
        System.out.println("--- Conexión a API finalizada con éxito.");
    }
    

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Sofia");
        Pedido pedido = new Pedido(cliente);

        try {
            // Lógica de Negocio
            pedido.agregarProducto(new Producto("Laptop", 1200.00));
            pedido.agregarProducto(new Producto("Mouse", 25.00));
            
            // Prueba de excepción NO VERIFICADA (Descomentar para probar)
            // pedido.agregarProducto(new Producto("Test Falla", -5.00)); 
            
            // Prueba de excepción PERSONALIZADA (Descomentar para probar)
            // throw new ObjetoNuloException("Prueba de excepción personalizada.");
            
            double totalPedido = pedido.calcularTotal();
            System.out.printf("\nTotal del Pedido (sin descuentos): $%.2f%n", totalPedido);

            // Uso de Polimorfismo con Interfaces
            Pago pagoTC = new TarjetaCredito();
            Pago pagoPP = new PayPal();

            // Uso de 'try-catch' para manejar la excepción verificada (IOException)
            simularPagoAPI(pagoTC, totalPedido);
            simularPagoAPI(pagoPP, totalPedido);
            
            pedido.cambiarEstado("PAGADO");

        } catch (IllegalArgumentException e) {
            // Manejo de Excepciones NO VERIFICADAS (unchecked)
            System.err.println("\nROR DE ARGUMENTO: " + e.getMessage());
        } catch (IOException e) {
            // Manejo de Excepciones VERIFICADAS (checked)
            System.err.println("\nERROR DE CONEXIÓN: " + e.getMessage());
        } catch (ObjetoNuloException e) {
            // Manejo de Excepciones PERSONALIZADAS
             System.err.println("\nERROR PERSONALIZADO: " + e.getMessage());
        } 
        
        System.out.println("\n--- EJECUCIÓN DEL PROGRAMA FINALIZADA ---");
    }
}


