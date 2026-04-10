package co.edu.uniquindio.EmpresaNomina.model;

public class Empleado {
    private String nombre;
    private String apellido;
    private String identificacion;
    private Categoria categoria;

    public Empleado(String nombre, String apellido, String identificacion, Categoria categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.categoria = categoria;
    }

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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
