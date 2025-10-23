package kata3;
import java.util.ArrayList;
import java.util.List;

// ====================================================================
// CLASE PROFESOR (Lado N, conoce a muchos Cursos)
// Implementa el lado 'Muchos' de la bidireccionalidad (A ↔ B)
// ====================================================================
class Profesor {
    private final String id;
    private final String nombre;
    private final String especialidad;
    private final List<Curso> cursos; 

    // Constructor simple
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>(); // Inicializa la lista de cursos
    }
    
    // ================== MÉTODOS DE RELACIÓN INTERNA (Sólo para Curso) ==================
    /* Permiten que la clase Curso actualice la lista del profesor de forma segura. */
    void agregarCursoInterno(Curso c) {
        // Verifica si ya está en la lista (usa Curso.equals)
        if (!this.cursos.contains(c)) { 
            this.cursos.add(c);
        }
    }

    void removerCursoInterno(Curso c) {
        this.cursos.remove(c);
    }
    // ==================================================================================
    
    // ---------------- Métodos funcionales ----------------
    public void listarCursos() {
        System.out.println("  Cursos dictados por " + nombre + " (" + cursos.size() + "):");
        // Ciclo for-each
        if (cursos.isEmpty()) {
            System.out.println("  [Dicta 0 cursos]");
            return;
        }
        for (Curso c : cursos) { 
            System.out.println("  -> [" + c.getCodigo() + "] " + c.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.println("👤 Profesor ID " + id + ": " + nombre + " (" + especialidad + ")");
        System.out.println("   Cursos a cargo: " + cursos.size());
    }
    // ---------------------------------------------------

    // Getters y Métodos de colección
    public List<Curso> getCursos() { return new ArrayList<>(cursos); } // Devuelve copia
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    
    // equals/hashCode basados en ID para ArrayList.contains/remove
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return this.id.equals(profesor.id); 
    }
    @Override public int hashCode() { return id.hashCode(); }
}

// ====================================================================
// CLASE CURSO (Lado 1, conoce a un Profesor)
// Implementa el lado 'Uno' de la bidireccionalidad (A ↔ B)
// ====================================================================
class Curso {
    private final String codigo;
    private final String nombre;
    private Profesor profesor; // Referencia simple a Profesor

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }
    
    // ---------------- Método Clave de Sincronización ----------------
    /* * setProfesor: Mantiene el Invariante de Asociación (Sincronización Bidireccional).
     * Este es el único método que modifica la relación en ambos lados.
     */
    public void setProfesor(Profesor nuevoProfesor) {
        Profesor antiguoProfesor = this.profesor; 

        // 1. Limpieza (Lado Muchos): Si había un profesor, y es diferente al nuevo, quítale este curso.
        if (antiguoProfesor != null && !antiguoProfesor.equals(nuevoProfesor)) {
            antiguoProfesor.removerCursoInterno(this); 
        }

        // 2. Asignación (Lado Uno): Asignar el nuevo profesor al curso.
        this.profesor = nuevoProfesor;

        // 3. Sincronización (Lado Muchos): Si el nuevo profesor existe, agrégale este curso.
        // También evita el caso en que se llame setProfesor con el mismo profesor.
        if (nuevoProfesor != null && !nuevoProfesor.equals(antiguoProfesor)) {
            nuevoProfesor.agregarCursoInterno(this); 
        }
    }

    public void mostrarInfo() {
        String nombreProfesor = (profesor != null) ? profesor.getNombre() : "SIN ASIGNAR";
        System.out.println("📚 Curso [" + codigo + "]: " + nombre + " | Profesor: " + nombreProfesor);
    }
    // -----------------------------------------------------------------

    // Getters y Métodos de colección
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }
    
    // equals/hashCode basados en Código para ArrayList.contains/remove
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return this.codigo.equals(curso.codigo);
    }
    @Override public int hashCode() { return codigo.hashCode(); }
}

// ====================================================================
// CLASE UNIVERSIDAD (Administrador)
// ====================================================================
class Universidad {
    private final String nombre;
    private final List<Profesor> profesores;
    private final List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Métodos de administración:
    public void agregarProfesor(Profesor p) {
        if (!profesores.contains(p)) { 
            profesores.add(p);
            System.out.println("✅ Profesor " + p.getNombre() + " agregado.");
        } else { System.out.println("⚠️ Profesor " + p.getNombre() + " ya existe."); }
    }

    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) { 
            cursos.add(c);
            System.out.println("✅ Curso [" + c.getCodigo() + "] " + c.getNombre() + " agregado.");
        } else { System.out.println("⚠️ Curso [" + c.getCodigo() + "] ya existe."); }
    }

    // El método que orquesta la asignación y el Invariante
    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso == null || profesor == null) {
            System.out.println("❌ Error de asignación: Curso o Profesor no encontrado.");
            return;
        }
        
        // Llama al método clave del Curso, el cual sincroniza al Profesor.
        curso.setProfesor(profesor); 
        System.out.println("🔗 Asignado: " + profesor.getNombre() + " dicta [" + curso.getCodigo() + "].");
    }

    public void listarProfesores() {
        System.out.println("\n--- LISTA DE PROFESORES (" + profesores.size() + ") ---");
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
    }

    public void listarCursos() {
        System.out.println("\n--- LISTA DE CURSOS (" + cursos.size() + ") ---");
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }
    
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) return c;
        }
        return null;
    }

    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Rompe la relación con el profesor (llama a setProfesor(null) internamente)
            curso.setProfesor(null); 
            cursos.remove(curso);
            System.out.println("🗑️ Curso [" + codigo + "] ELIMINADO. Relación rota.");
        } else {
            System.out.println("❌ No se pudo eliminar: Curso " + codigo + " no encontrado.");
        }
    }

    public void eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Se usa una copia de la lista antes de iterar y modificar la lista original.
            List<Curso> cursosADictar = new ArrayList<>(profesor.getCursos()); 
            
            for (Curso c : cursosADictar) {
                // Al llamar a setProfesor(null) se quita la referencia de este profesor de la lista del curso
                // y se remueve el curso de la lista del profesor (manteniendo el invariante).
                c.setProfesor(null); 
            }
            profesores.remove(profesor);
            System.out.println("🗑️ Profesor ID " + id + " " + profesor.getNombre() + " ELIMINADO. Cursos reasignados a null.");
        } else {
             System.out.println("❌ No se pudo eliminar: Profesor ID " + id + " no encontrado.");
        }
    }
    
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\n--- REPORTE: Cursos por Profesor ---");
        for (Profesor p : profesores) {
            System.out.println("Profesor " + p.getNombre() + ": " + p.getCursos().size() + " cursos.");
        }
    }
}

// ====================================================================
// CLASE MAIN (Tareas a realizar)
// ====================================================================
public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Tecnológica Central");

        // PASO 1 y 2: Creación y Agregación
        System.out.println("\n--- 1. Creación y Agregación ---");
        Profesor p1 = new Profesor("P101", "Dra. Ana Gómez", "Ingeniería de Software");
        Profesor p2 = new Profesor("P102", "Ing. Juan Pérez", "Base de Datos");
        Profesor p3 = new Profesor("P103", "Lic. Marta Ríos", "Redes");

        Curso c1 = new Curso("CS101", "Programación Avanzada");
        Curso c2 = new Curso("CS102", "Bases de Datos I");
        Curso c3 = new Curso("CS103", "Redes y Sistemas");
        Curso c4 = new Curso("CS104", "Estructura de Datos");
        Curso c5 = new Curso("CS105", "Seguridad Informática");
        
        uni.agregarProfesor(p1);
        uni.agregarProfesor(p2);
        uni.agregarProfesor(p3);
        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);
        uni.agregarCurso(c4);
        uni.agregarCurso(c5);
        
        // PASO 3: Asignación Inicial
        System.out.println("\n--- 2. Asignación Inicial ---");
        uni.asignarProfesorACurso("CS101", "P101"); 
        uni.asignarProfesorACurso("CS104", "P101"); 
        uni.asignarProfesorACurso("CS102", "P102"); 
        uni.asignarProfesorACurso("CS103", "P103"); 
        
        // PASO 4: Listado y Verificación de Sincronización
        System.out.println("\n--- 3. Verificación Inicial ---");
        uni.listarCursos();
        uni.listarProfesores();
        
        // PASO 5: Cambio de Profesor
        System.out.println("\n--- 4. Cambio de Profesor (Invariante) ---");
        // CS104 pasa de Ana (P101, 2 cursos) a Juan (P102, 1 curso)
        uni.asignarProfesorACurso("CS104", "P102"); 
        
        System.out.println("\n--- Resultado del Cambio ---");
        p1.mostrarInfo(); // Ana debe tener 1 curso
        p2.mostrarInfo(); // Juan debe tener 2 cursos
        
        // PASO 6: Remover un curso
        System.out.println("\n--- 5. Eliminación de Curso ---");
        uni.eliminarCurso("CS104"); // Elimina CS104, el cual era de Juan (P102)
        
        System.out.println("\n--- Resultado de la Eliminación ---");
        p2.mostrarInfo(); // Juan debe tener 1 curso
        
        // PASO 7: Remover un profesor
        System.out.println("\n--- 6. Eliminación de Profesor ---");
        uni.eliminarProfesor("P101"); // Ana (P101) dicta CS101. CS101 debe quedar sin profesor.
        
        System.out.println("\n--- Resultado de la Eliminación ---");
        uni.listarProfesores(); 
        Curso cs101 = uni.buscarCursoPorCodigo("CS101");
        if (cs101 != null) {
            cs101.mostrarInfo(); // Debe decir SIN ASIGNAR
        }
        
        // PASO 8: Mostrar un reporte
        uni.mostrarReporteCursosPorProfesor();
    }
}
