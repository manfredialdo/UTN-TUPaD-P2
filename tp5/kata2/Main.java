//2. Celular - Batería - Usuario
//a. Agregación: Celular → Batería
//b. Asociación bidireccional: Celular ↔ Usuario
//Clases y atributos:
//i. Celular: imei, marca, modelo
//ii. Batería: modelo, capacidad
// iii. Usuario: nombre, dni

class Celular {
  private String imei;
  private String marca;
  private String modelo;
  private Usuario usuario; // Asociación 1:1 con Usuario
  private Bateria bateria; // Agregación

  public Celular(String imei, String marca, String modelo, Bateria bateria){
    this.imei = imei;
    this.marca = marca;
    this.modelo = modelo;
    this.bateria = bateria;
  }

  // Setter para la Asociación Bidireccional (Usuario se establece desde afuera)
  public void setUsuario(Usuario usuario){
    if (this.usuario != usuario) {
      this.usuario = usuario;
      if (usuario != null){
        usuario.setCelular(this); // Llama al setter del otro lado
      }
    }
  }

  public void mostrarBateria(){
    //Agregando () a getCapacidad y ; al final
    System.out.println("El celular " + modelo + " de la marca " + marca +
    " tiene una batería " + bateria.getModelo() + " con una capacidad de " + bateria.getCapacidad());
  }
}


class Bateria {
  private String modelo;
  private String capacidad; // Mantenemos String, asumiendo que incluye unidad (e.g., "4500mAh")
  
  public Bateria(String modelo, String capacidad){
    this.modelo = modelo;
    this.capacidad = capacidad;
  }
  
  public String getModelo(){
    return modelo;
  }
  
  public String getCapacidad(){
    return capacidad;
  }
}

class Usuario {
  private String nombre;
  private int dni;
  private Celular celular; // Agregado para la asociación bidireccional**

  public Usuario(String nombre, int dni) {
    this.nombre = nombre;
    this.dni = dni;
  }

  // Se agrega el tipo de retorno String**
  public String getNombre(){
    return nombre;
  }
  
  // Se agrega el tipo de retorno int**
  public int getDni(){
    return dni;
  }
  
  // Setter para manejar la otra parte de la asociación bidireccional**
  public void setCelular(Celular celular){
    if (this.celular != celular) {
      this.celular = celular;
    }
  }
}

// Clase Principal para la ejecución
public class Main {
    public static void main(String[] args) {
      // Ejemplo de uso:
      Bateria miBateria = new Bateria("Li-ion S20", "4500mAh");
      Celular miCelular = new Celular("1234567890", "Samsung", "Galaxy S20", miBateria);
      Usuario miUsuario = new Usuario("Ana Perez", 25888777);
      
      // Establecer la asociación bidireccional
      miCelular.setUsuario(miUsuario);      
      // Mostrar la información
      miCelular.mostrarBateria(); 
      // Si quieres mostrar el usuario asociado, necesitarías un getter en Celular
    }
}
