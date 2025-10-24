class Vehiculo {
    // Modificadores de acceso: private para encapsulamiento
    private String marca;
    private String modelo;

    // Constructor para inicializar atributos
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    //  Método para mostrar información
    public void mostrarInfo() {
        System.out.println("--- Información del Vehículo ---");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}
class Auto extends Vehiculo {
    // Atributo adicional de la subclase
    private int cantidadPuertas;

    //  Constructor
    // Uso de super(...) para invocar al constructor de la superclase (Vehiculo)
    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo); // Llama al constructor de Vehiculo
        this.cantidadPuertas = cantidadPuertas;
    }

    // Polimorfismo: Sobrescritura del método (Overriding)
    @Override
    public void mostrarInfo() {
        // Llamar al método de la superclase para reutilizar código
        super.mostrarInfo();
        
        // Agregar la información específica de Auto
        System.out.println("Tipo: Auto");
        System.out.println("Puertas: " + cantidadPuertas);
        System.out.println("---------------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        // Instanciar un objeto Auto
        Auto miAuto = new Auto("Toyota", "Corolla", 4);

        // Llamada al método sobrescrito (Polimorfismo)
        // Se ejecuta la versión de mostrarInfo() definida en la clase Auto.
        System.out.println("instancia de Auto:");
        miAuto.mostrarInfo();
        
        
        // Ejemplo de Upcasting
        Vehiculo vehiculoGenerico = new Auto("Ford", "Fiesta", 2);
        
        System.out.println("\nupcassting y Polimorfismo (Llamada dinámica de métodos):");
        // Aunque la referencia es de tipo Vehiculo,
        // la llamada al método ejecuta la versión de Auto (Polimorfismo).
        vehiculoGenerico.mostrarInfo();
    }
}
