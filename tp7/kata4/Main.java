/*
4. Animales y comportamiento sobrescrito
● Clase: Animal con método hacerSonido() y describirAnimal()
● Subclases: Perro, Gato, Vaca sobrescriben hacerSonido() con @Override
● Tarea: Crear lista de animales y mostrar sus sonidos con polimorfismo
*/
Package kata4;
import java.util.ArrayList;
import java.util.List;

// Superclase: Clase Animal
class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método base para Polimorfismo
    public void hacerSonido() {
        System.out.println("Sonido genérico de animal.");
    }
    
    public void describirAnimal() {
        System.out.println("Este animal se llama " + nombre);
    }

    // Método de acceso
    public String getNombre() {
        return nombre;
    }
}

// Subclase: Perro
class Perro extends Animal { //erencia
    public Perro(String nombre) {
        super(nombre); //  Uso de super()
    }
    
    // olimorfismo: Sobrescritura
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.println(nombre + " es un Perro, es un ladrido sin garganta que aúlla versos al olvido de la tapera.");
    }
}

// Subclase: Gato
class Gato extends Animal { //Herencia
    public Gato(String nombre) {
        super(nombre); //  Uso de super()
    }
    
    // Polimorfismo: Sobrescritura
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.println(nombre + " es un Gato, es un ojo verde que refleja la luna triste sobre el cuero crudo..");
    }
}

// Subclase: Vaca
class Vaca extends Animal { // erencia
    public Vaca(String nombre) {
        super(nombre); // Uso de super()
    }
    
    //limorfismo: Sobrescritura
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Muuuu!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.println(nombre + " es una Vaca, y tambien es un triste bulto de vida, solo valioso por lo que alimenta.");
    }
}

// Clase Principal
public class Main {
    public static void main(String[] args) {
        // 1. Crear una lista de la clase base (Animal) para aplicar Upcasting
        List<Animal> granja = new ArrayList<>();

        // 2. Instanciar subclases y agregarlas a la lista (Upcasting implícito)
        granja.add(new Perro("Capataz"));
        granja.add(new Gato("Vizcacha"));
        granja.add(new Vaca("Lola"));
        granja.add(new Perro("Sombra"));

        System.out.println(" ZooInteractivo ---");
        
        // 3. Recorrer la lista y demostrar el Polimorfismo
        for (Animal animal : granja) {
            // Polimorfismo: Se llama al método hacerSonido() o describirAnimal() 
            //    específico de la clase real del objeto (Perro, Gato, Vaca), 
            //    a pesar de que la referencia sea de tipo Animal.
            
            animal.describirAnimal();
            animal.hacerSonido();
            System.out.println("---   ---   ---   ---   ---");
        }
    }
}
