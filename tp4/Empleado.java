// Empleado.java tp4 manfredialdo
public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    static int totalEmpleados = 0;
    private static int siguienteId = 1; 

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 1500;
        this.id = siguienteId++;
        totalEmpleados++;
    }

    public double actualizarSalario(double porcentaje) {
        if (porcentaje > 0) { 
            this.salario += this.salario * (porcentaje / 100);
        }
        return this.salario;
    }

    public double actualizarSalario(int aumento) {
        if (aumento > 0) { 
            this.salario += aumento;
        }
        return this.salario;
    }

    // Getters
    public int getId() { return this.id; }
    public String getNombre() { return this.nombre; }
    public String getPuesto() { return this.puesto; }
    public double getSalario() { return this.salario; }

    // Setters
    public void setNombre(String nombre){ 
      this.nombre = nombre; 
    }
    public void setPuesto(String puesto) { 
      this.puesto = puesto; 
    }
    public void setSalario(double salario) { 
      this.salario = salario; 
    }

    // Método estático para mostrar el total de empleados
    public static void mostrarTotalEmpleados() {
        System.out.println("Se crearon un total de " + totalEmpleados + " empleados.");
    }

    @Override
    public String toString() {
        return "Empleado{id=" + this.id + ", nombre='" + this.nombre + "', puesto='" + this.puesto + "', salario=" + String.format("%.2f", this.salario) + "}";
    }

    public static void main(String[] args) {
        
        System.out.println("Crear Empleados ---");
        System.out.println("Creando emp1 y emp2 (ID automatico, salario por defecto $1500)...");
        Empleado emp1 = new Empleado("Ramon Roso", "Limpieza");
        Empleado emp2 = new Empleado("Luis Pereti", "Diseñador ");
        System.out.println("Creando emp3 (ID manual 100, salario especificado $4500)...");
        Empleado emp3 = new Empleado(100, "Marta ", "Gerente ", 4500.00); 
        System.out.println("\n--- 2. plicacion de Aumentos Salariales ---");
        System.out.println("Salario inicial de " + emp1.getNombre() + ": " + String.format("%.2f", emp1.getSalario()));
        emp1.actualizarSalario(10.5); // Aumento del 10.5%
        System.out.println("Aumento 10.5% -> Nuevo Salario: " + String.format("%.2f", emp1.getSalario()));
        System.out.println("Salario inicial de " + emp2.getNombre() + ": " + String.format("%.2f", emp2.getSalario()));
        emp2.actualizarSalario(300); // Aumento de $300
        System.out.println("Aumento $300 -> Nuevo Salario: " + String.format("%.2f", emp2.getSalario()));
        System.out.println("Salario inicial de " + emp3.getNombre() + ": " + String.format("%.2f", emp3.getSalario()));
        emp3.actualizarSalario(5.0); // Aumento del 5.0%
        System.out.println("Aumento 5.0% -> Nuevo Salario: " + String.format("%.2f", emp3.getSalario()));
        System.out.println("\n--- 3. Informacin Final de Empleados ---");
        System.out.println("Empleado 1: " + emp1.toString());
        System.out.println("Empleado 2: " + emp2.toString());
        System.out.println("Empleado 3: " + emp3.toString());
        Empleado.mostrarTotalEmpleados(); 
    }
}


