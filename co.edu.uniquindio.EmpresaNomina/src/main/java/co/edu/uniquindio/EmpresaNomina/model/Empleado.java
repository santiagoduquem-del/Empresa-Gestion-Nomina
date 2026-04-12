package co.edu.uniquindio.EmpresaNomina.model;

import co.edu.uniquindio.EmpresaNomina.exception.salarioNegativoException;

public abstract class Empleado {

    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected Categoria categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase, Categoria categoria,
                    float descuentoSalud, float descuentoPension) {
        
        if (salarioBase < 0) {
            throw new salarioNegativoException("El salario base no puede ser negativo");
        }
        if (descuentoSalud < 0 || descuentoSalud > 100000000) {
            throw new RuntimeException("El descuento de salud debe estar entre 0 y 100");
        }
        if (descuentoPension < 0 || descuentoPension > 100000000) {
            throw new RuntimeException("El descuento de pensión debe estar entre 0 y 100");
        }

        /**
         * Constructor de la clase Empleado.
         * @param nombre
         * @param documento
         * @param edad
         * @param salarioBase
         * @param categoria
         * @param descuentoSalud
         * @param descuentoPension
         */
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }


    // Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    /**
     * metodo calcularSalarioBruto

     */
    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        if (categoria == null) return 0;
        switch (categoria) {
            case JUNIOR: return salarioBase * 0.05f;
            case SEMISENIOR: return salarioBase * 0.10f;
            case SENIOR: return salarioBase * 0.15f;
            default: return 0;
        }
    }

    /**
     * metodo calcularDescuentos
     *
     */

    public float calcularDescuentos() {
        return (salarioBase * (descuentoSalud / 100)) + (salarioBase * (descuentoPension / 100));
    }

    /**
     * metodo calcularSalarioNeto
     *
     */

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    /**
     * metodo mostrarInformacion
     */

    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " (" + categoria + ")");
        System.out.println(" > Salario Bruto: " + calcularSalarioBruto());
        System.out.println(" > (-) Descuentos: " + calcularDescuentos());
        System.out.println(" > (=) Salario Neto: " + calcularSalarioNeto());
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBase=" + salarioBase +
                ", categoria=" + categoria +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                '}';
    }
}
