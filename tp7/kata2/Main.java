/*
2. Figuras geométricas y métodos abstractos
● Clase abstracta: Figura con método calcularArea() y atributo nombre
● Subclases: Círculo y Rectángulo implementan el cálculo del área
● Tarea: Crear un array de figuras y mostrar el área de cada una usando
polimorfismo. 
*/
abstract class Figura {
    // 1. Atributo
    protected String nombre; // Usamos 'protected' para que las subclases puedan acceder

    // 2. Constructor para inicializar el nombre
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // 3. Método abstracto
    // Obliga a todas las subclases a proporcionar su propia implementación.
    public abstract double calcularArea();

    // Método concreto (no abstracto) para mostrar el nombre
    public String getNombre() {
        return nombre;
    }
}


class Circulo extends Figura {
    private double radio; // Atributo específico

    // Constructor: Invoca al constructor de la superclase con super(...)
    public Circulo(double radio) {
        // Llamada a super() para establecer el nombre
        super("Círculo");
        this.radio = radio;
    }

    // Polimorfismo: Implementación obligatoria del método abstracto
    // Fórmula del área: π * radio²
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}



class Rectangulo extends Figura {
    private double base; // Atributo específico 1
    private double altura; // Atributo específico 2

    // Constructor: Invoca al constructor de la superclase
    public Rectangulo(double base, double altura) {
        // Llamada a super() para establecer el nombre
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    // Polimorfismo: Implementación obligatoria del método abstracto
    // Fórmula del área: base * altura
    @Override
    public double calcularArea() {
        return base * altura;
    }
}



public class Main {
    public static void main(String[] args) {
        // 1. Crear un Array (o ArrayList) de la CLASE BASE: Figura
        // Esto permite almacenar objetos de Círculo y Rectángulo juntos (Upcasting).
        Figura[] figuras = new Figura[3];

        // 2. Instanciar y llenar el array con diferentes subclases
        figuras[0] = new Circulo(5.0);           // Círculo con radio 5
        figuras[1] = new Rectangulo(4.0, 6.0);   // Rectángulo con base 4, altura 6
        figuras[2] = new Circulo(2.5);           // Otro Círculo con radio 2.5

        // 3. Recorrer el array y calcular el área usando Polimorfismo
        System.out.println("--- Cálculo de Áreas de Figuras ---");

        for (Figura f : figuras) {
            // La variable 'f' es de tipo Figura, pero en tiempo de ejecución,
            // Java sabe que si es un Círculo, debe llamar a su calcularArea(),
            // y si es un Rectángulo, debe llamar al suyo. ¡Esto es Polimorfismo!
            
            double area = f.calcularArea();
            
            // Usamos String.format para limitar los decimales en el área.
            System.out.printf("La figura '%s' tiene un área de: %.2f\n", 
                              f.getNombre(), 
                              area);
        }
        
        System.out.println("-------------------------------------");
    }
}
