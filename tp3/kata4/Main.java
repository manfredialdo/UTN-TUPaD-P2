/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata4;
public class Main {
    public static void main(String[] args) {
        Gallina galli1 = new Gallina();
        galli1.setIdGallina("ramona");
        galli1.setEdad(1);
        galli1.setHuevosPuestos(19);
        galli1.mostrarEstado();

        galli1.ponerHuevo();
        galli1.envejecer();
        galli1.mostrarEstado();

        Gallina galli2 = new Gallina();
        galli2.setIdGallina("lucre");
        galli2.setEdad(3);
        galli2.setHuevosPuestos(29);
        galli2.mostrarEstado();

        galli2.ponerHuevo();
        galli2.envejecer();
        galli2.mostrarEstado();
    }
}
