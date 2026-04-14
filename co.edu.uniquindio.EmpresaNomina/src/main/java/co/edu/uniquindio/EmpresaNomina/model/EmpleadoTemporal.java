package co.edu.uniquindio.EmpresaNomina.model;

import co.edu.uniquindio.EmpresaNomina.exception.diasTrabajadosInvalidosException;
import co.edu.uniquindio.EmpresaNomina.exception.valorDiaInvalidoException;

import javax.swing.*;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajo;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, Categoria categoria,
                     float descuentoSalud, float descuentoPension, int diasTrabajo, float valorDia)
    {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        
        if (diasTrabajo < 0) {
            throw new diasTrabajadosInvalidosException("Los días trabajados no pueden ser negativos");
        }
        if (valorDia < 0) {
            throw new valorDiaInvalidoException("El valor del día no puede ser negativo");
        }
        
        this.diasTrabajo = diasTrabajo;
        this.valorDia = valorDia;
    }

    /**
     * metodo calcularSalarioBruto
     * @return
     */
    @Override
    public float calcularSalarioBruto() {
        return (diasTrabajo * valorDia) + calcularBonificacionCategoria();
    }

    /**
     * metodo toString
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " EmpleadoTemporal{" + "diasTrabajo=" + diasTrabajo + "}";
    }

    //get y set

    @Override
    public void setHorasExtra(int horaExtra) {
        JOptionPane.showMessageDialog(null, "Es empleado Temporal, no se pueda asignar "+ horaExtra +"horas extras");
    }
    @Override
    public void setporcentajeComision(int porcentajeComision) {
        JOptionPane.showMessageDialog(null,nombre + " Es empleado Temporal no recibe comisión " );
    }

    @Override
    public void setDiasTrabajo(int diasTrabajo) {
        this.diasTrabajo = diasTrabajo;
        JOptionPane.showMessageDialog(null,nombre + " Días de trabajo " +  diasTrabajo );
    }


}
