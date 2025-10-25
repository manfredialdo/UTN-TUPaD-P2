/*
3. Empleados y polimorfismo
● Clase abstracta: Empleado con método calcularSueldo()
● Subclases: EmpleadoPlanta, EmpleadoTemporal
● Tarea: Crear lista de empleados, invocar calcularSueldo() 
polimórficamente, usar instanceof para clasificar
*/

package kata3;

import java.util.ArrayList;
import java.util.List;






// =======================================================
// 4. CLASE PRINCIPAL: Main
// =======================================================
public class Main {
    public static void main(String[] args) {
        // Crear lista de empleados (tipo base para Polimorfismo/Upcasting)
        List<Empleado> nomina = new ArrayList<>();
        
        nomina.add(new EmpleadoPlanta("Doña Rosa "));
        nomina.add(new EmpleadoTemporal("La Carmen ", 160));
        nomina.add(new EmpleadoPlanta("Hilario Ascasubi"));
        nomina.add(new EmpleadoTemporal("la otra ", 80));

        System.out.println("--- Cálculo de Nómina Polimórfico ---");
        
        double totalNomina = 0;

        // Recorrer la lista para calcular sueldos (Polimorfismo) y clasificar (instanceof)
        for (Empleado e : nomina) {
            // Polimorfismo: Java llama al calcularSueldo() correcto (Planta o Temporal)
            double sueldo = e.calcularSueldo();
            totalNomina += sueldo;
            
            // usar instanceof para clasificar y mostrar información específica
            String tipo;
            if (e instanceof EmpleadoPlanta) {
                tipo = "Planta";
            } else if (e instanceof EmpleadoTemporal) {
                tipo = "Temporal";
            } else {
                tipo = "Desconocido";
            }

            System.out.printf("Empleado: %-15s | Tipo: %-10s | Sueldo: $%,.2f\n", 
                              e.getNombre(), tipo, sueldo);
        }
        
        System.out.println("\n-------------------------------------");
        System.out.printf("Total de la nómina: $%,.2f\n", totalNomina);
    }
}





// =======================================================
// 1. CLASE ABSTRACTA: Empleado
// =======================================================
abstract class Empleado {
    protected String nombre;
    
    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: obliga a las subclases a implementarlo.
    public abstract double calcularSueldo();
    
    public String getNombre() {
        return nombre;
    }
}



// =======================================================
// 2. SUBCLASE: EmpleadoPlanta
// =======================================================
class EmpleadoPlanta extends Empleado {
    private static final double SUELDO_BASE = 50000.0;
    
    public EmpleadoPlanta(String nombre) {
        super(nombre);
    }
    
    // Polimorfismo: Implementación específica del cálculo.
    @Override
    public double calcularSueldo() {
        // Suponemos un sueldo fijo para empleados de planta.
        return SUELDO_BASE; 
    }
}



// =======================================================
// 3. SUBCLASE: EmpleadoTemporal
// =======================================================
class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private static final double PAGO_POR_HORA = 500.0;
    
    public EmpleadoTemporal(String nombre, int horasTrabajadas) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
    }
    
    // Polimorfismo: Implementación específica del cálculo.
    @Override
    public double calcularSueldo() {
        // Sueldo calculado por horas.
        return horasTrabajadas * PAGO_POR_HORA;
    }
}



