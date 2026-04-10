package co.edu.uniquindio.EmpresaNomina.model;

public class EmpleadoVentas extends Empleado {

    private float totalVenetas;
    private float porcentajeComision;

    public EmpleadoVentas (String nombre,String documento,int edad, float salarioBase, Categoria categoria,float descuentoSalud, float descuentoPension,
                           float totalVentas, float porcentajeComision)

    {super (nombre, documento, edad, salarioBase,  categoria,  descuentoSalud,  descuentoPension);
        this.totalVenetas = totalVenetas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public String toString() {
        return "EmpleadoVentas{" +
                "totalVenetas=" + totalVenetas +
                ", porcentajeComision=" + porcentajeComision +
                '}';
    }
}
