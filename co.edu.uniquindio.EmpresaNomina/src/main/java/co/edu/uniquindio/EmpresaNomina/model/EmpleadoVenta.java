package co.edu.uniquindio.EmpresaNomina.model;

import co.edu.uniquindio.EmpresaNomina.exception.comisionInvalidaException;

import javax.swing.*;

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

    @Override
    public void setHorasExtra(int horaExtra) {
        JOptionPane.showMessageDialog(null, "Es empleado de ventas, no se pueda asignar "+ horaExtra +"horas extras");
    }

    @Override
    public void setporcentajeComision(int porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
        JOptionPane.showMessageDialog(null,nombre +" Horas extra "  + porcentajeComision+" horas extras" );
    }
    @Override
    public void setDiasTrabajo(int diasTrabajo) {
        JOptionPane.showMessageDialog(null,nombre + " Es empleado de venta no aplica trabajo por días  " );
    }

}
