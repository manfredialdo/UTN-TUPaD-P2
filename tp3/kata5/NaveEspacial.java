package kata5;
public class NaveEspacial {
    private String nombre;
    private int combustible = 50; // Se inicializa directamente
    private final int CAPACIDAD_MAXIMA = 100;
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void despegar() {
        System.out.println(" ¡La nave " + nombre + " está despegando!");
    }

    public void avanzar(int distancia) {
        if (combustible >= distancia) {
            combustible -= distancia;
            System.out.println("La nave " + nombre + " avanza " + distancia + " unidades.");
        } else {
            System.out.println("¡Error! No hay suficiente combustible para avanzar " + distancia + " unidades.");
        }
    }

    public void recargarCombustible(int cantidad) {
        if (combustible + cantidad <= CAPACIDAD_MAXIMA) {
            combustible += cantidad;
            System.out.println("La nave " + nombre + " ha recargado " + cantidad + " unidades de combustible.");
        } else {
            int exceso = (combustible + cantidad) - CAPACIDAD_MAXIMA;
            System.out.println("¡Error! La recarga de " + cantidad + " superaría el límite de combustible.");
            System.out.println("Se supera el límite por: " + exceso + " unidades.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n--- Estado de la nave " + nombre + " ---");
        System.out.println("Combustible actual: " + combustible + " / " + CAPACIDAD_MAXIMA);
        System.out.println("------------------------------------");
    }
}




