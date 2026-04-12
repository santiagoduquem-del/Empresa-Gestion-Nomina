package co.edu.uniquindio.EmpresaNomina.model;

import co.edu.uniquindio.EmpresaNomina.exception.comisionInvalidaException;

public class EmpleadoVenta extends Empleado {

    private float totalVenta;
    private float porcentajeComision;

    public EmpleadoVenta (String nombre, String documento, int edad, float salarioBase, Categoria categoria, float descuentoSalud, float descuentoPension,
                           float totalVentas, float porcentajeComision)
    {
        super (nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        
        if (porcentajeComision < 0 || porcentajeComision > 100) {
            throw new comisionInvalidaException("El porcentaje de comisión debe estar entre 0 y 100");
        }

        this.totalVenta= totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public float calcularSalarioBruto() {
        float comision = totalVenta * (porcentajeComision / 100);
        return salarioBase + calcularBonificacionCategoria() + comision;
    }

    @Override
    public String toString() {
        return super.toString() + " EmpleadoVenta{" + "totalVentas=" + totalVenta + "}";
    }
}
