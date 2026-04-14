package co.edu.uniquindio.EmpresaNomina.model;

import co.edu.uniquindio.EmpresaNomina.exception.horasExtrasNegativasException;
import co.edu.uniquindio.EmpresaNomina.exception.valorHoraExtraInvalidoException;

public class EmpleadoPlanta extends Empleado {

    private String cargo;
    private int horaExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta (String nombre, String documento, int edad, float salarioBase, Categoria categoria,
                           float descuentoSalud, float descuentoPension, String cargo, int horaExtra, float valorHoraExtra, float auxilioTransporte)
    {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        
        if (horaExtra < 0) {
            throw new horasExtrasNegativasException("Las horas extra no pueden ser negativas");
        }
        if (valorHoraExtra < 0) {
            throw new valorHoraExtraInvalidoException("El valor de la hora extra no puede ser negativo");
        }

        this.cargo = cargo;
        this.horaExtra = horaExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    /**
     * metodo calcularSalarioBruto
     */
    @Override
    public float calcularSalarioBruto() {
        return salarioBase + calcularBonificacionCategoria() + (horaExtra * valorHoraExtra) + auxilioTransporte;
    }

    /**
     * metodo toString
     */
    @Override
    public String toString() {
        return super.toString() + " EmpleadoPlanta{" + "cargo='" + cargo + "'}";
    }

//Getters and setters

    @Override
    public void setHorasExtra(int valor) {
        this.horaExtra = valor;
    }
}
