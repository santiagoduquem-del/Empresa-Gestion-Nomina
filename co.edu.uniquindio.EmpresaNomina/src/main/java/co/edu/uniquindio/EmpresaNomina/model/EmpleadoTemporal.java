package co.edu.uniquindio.EmpresaNomina.model;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajo;
    private float valorDia;

EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, Categoria categoria,
                 float descuentoSalud, float descuentoPension, int diasTrabajo, float valorHora)

{super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);

    this.diasTrabajo= diasTrabajo;
    this.valorDia = valorDia;
}

    @Override
    public String toString() {
        return "EmpleadoTemporal{" +
                "diasTrabajo=" + diasTrabajo +
                ", valorDia=" + valorDia +
                '}';
    }
}
