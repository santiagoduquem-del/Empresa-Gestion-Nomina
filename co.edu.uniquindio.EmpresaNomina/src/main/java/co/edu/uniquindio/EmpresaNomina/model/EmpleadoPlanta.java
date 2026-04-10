package co.edu.uniquindio.EmpresaNomina.model;

public class EmpleadoPlanta extends Empleado {

    private String cargo;
    private int horaExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta (String nombre, String documento, int edad, float salarioBase, Categoria categoria,
                           float descuentoSalud, float descuentoPension, String cargo, int horaExtra, float valorHoraExtra, float auxilioTransporte)
    {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);

        this.cargo = cargo;
        this.horaExtra = horaExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;

    }

    @Override
    public String toString() {
        return "EmpleadoPlanta{" +
                "cargo='" + cargo + '\'' +
                ", horaExtra=" + horaExtra +
                ", valorHoraExtra=" + valorHoraExtra +
                ", auxilioTransporte=" + auxilioTransporte +
                '}';
    }
}
