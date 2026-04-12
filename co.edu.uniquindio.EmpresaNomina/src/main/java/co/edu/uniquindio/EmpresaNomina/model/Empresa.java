package co.edu.uniquindio.EmpresaNomina.model;

import co.edu.uniquindio.EmpresaNomina.exception.documentoDuplicadoException;
import co.edu.uniquindio.EmpresaNomina.exception.empleadoNuloException;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private int nit;
    private List<Empleado> listEmpleado;

    /**
     * Constructor de la clase Empresa.
     * @param nombre
     * @param nit
     *listEmpleado
     */

    public Empresa(String nombre, int nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listEmpleado = new ArrayList<>();
    }


    // Getters y Setters
    public String getNombre()
    { return nombre; }

    public void setNombre(String nombre)
    { this.nombre = nombre; }

    public int getNit()
    { return nit; }

    public void setNit(int nit)
    { this.nit = nit; }

    public List<Empleado> getListEmpleado()
    { return listEmpleado; }



    /**
     * metodo agregarEmpleado
     */

    public void agregarEmpleado(Empleado nuevoEmpleado) {
        if (nuevoEmpleado == null) {
            throw new empleadoNuloException("El empleado no puede ser nulo");
        }
        if (buscarEmpleado(nuevoEmpleado.getDocumento()) != null) {
            throw new documentoDuplicadoException("Ya existe un empleado con el documento: " + nuevoEmpleado.getDocumento());
        }
        listEmpleado.add(nuevoEmpleado);
    }

    /**
     * metodo buscarEmpleado
     */

    public Empleado buscarEmpleado(String documento) {
        for (Empleado emp : listEmpleado) {
            if (emp.getDocumento().equals(documento)) {
                return emp;
            }
        }
        return null;
    }

    /**
     * metodo obtenerEmpleadoMayorSalario
     */


    public Empleado obtenerEmpleadoMayorSalario() {
        if (listEmpleado.isEmpty()) return null;
        
        Empleado mayor = listEmpleado.get(0);
        for (Empleado emp : listEmpleado) {
            if (emp.calcularSalarioNeto() > mayor.calcularSalarioNeto()) {
                mayor = emp;
            }
        }
        return mayor;
    }


    /**
     * metodo calcularNominaTotal
     */

    public float calcularNominaTotal() {
        float total = 0;
        for (Empleado emp : listEmpleado) {
            total += emp.calcularSalarioNeto();
        }
        return total;
    }

    /**
     * metodo generarResumenesPago
     */

    public List<ResumenPago> generarResumenesPago() {
        List<ResumenPago> resumenes = new ArrayList<>();
        for (Empleado emp : listEmpleado) {
            String tipo = emp.getClass().getSimpleName().replace("Empleado", "");
            resumenes.add(new ResumenPago(
                    emp.getDocumento(),
                    emp.getNombre(),
                    tipo,
                    emp.calcularSalarioBruto(),
                    emp.calcularDescuentos(),
                    emp.calcularSalarioNeto()
            ));
        }
        return resumenes;
    }

    /**
     * metodo mostrarTodosLosEmpleados
     */

    public void mostrarTodosLosEmpleados() {
        System.out.println("--- LISTA DE EMPLEADOS ---");
        for (Empleado emp : listEmpleado) {
            System.out.println(emp.toString());
        }
    }


    /**
     * metodo mostrarResumenesPago
     */
    public void mostrarResumenesPago() {
        System.out.println("--- RESÚMENES DE PAGO GENERADOS ---");
        for (ResumenPago resumen : generarResumenesPago()) {
            System.out.println(resumen.toString());
        }
    }


    /**
     * metodo mostrarInformacion
     */
    public void mostrarInformacion() {
        System.out.println(" EMPRESA: " + nombre + " (NIT: " + nit + ") ");
        mostrarResumenesPago();
        System.out.println(" NÓMINA TOTAL DE LA EMPRESA: $" + calcularNominaTotal());
        
        Empleado mayor = obtenerEmpleadoMayorSalario();
        if (mayor != null) {
            System.out.println(" EMPLEADO CON MAYOR SALARIO: " + mayor.getNombre() + " $" + mayor.calcularSalarioNeto() + "");
        }
        System.out.println("-----------------");
    }


}
