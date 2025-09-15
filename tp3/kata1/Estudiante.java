package kata1;
class Estudiante  {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    // funciones: Métodos requeridos: mostrarInfo(), subirCalificacion(puntos), 
    // bajarCalificacion(puntos).
    public void mostrarInfo(){
        System.out.println("Estudiante: " + apellido + " " + nombre);
        System.out.println("Curso: " + curso);
        System.out.println("Calificacion: " + calificacion);
    }
    
    public double subirCalificacion(double puntos){
        double nuevaCalificacion = calificacion + puntos;
        calificacion = nuevaCalificacion;
        return calificacion;
    }

    public double bajarCalificacion(double puntos){
        double nuevaCalificacion = calificacion - puntos;
        calificacion = nuevaCalificacion;
        return calificacion;
    }
    
}
