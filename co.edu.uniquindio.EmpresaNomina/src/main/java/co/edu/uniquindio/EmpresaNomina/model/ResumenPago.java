package co.edu.uniquindio.EmpresaNomina.model;

public record ResumenPago (String documento,
    String nombre,
    String tipoEmpleado,
    float salarioBruto,
    float descuentos,
    float salarioNeto
) {
        @Override
        public String toString() {
            return String.format(
                    """
                  
                      RESUMEN DE PAGO
                   
                      Documento    : %s
                      Nombre       : %s
                      Tipo         : %s
                      Salario bruto: $%,.2f
                      Descuentos   : $%,.2f
                      Salario neto : $%,.2f
                   
                    """,
                    documento, nombre, tipoEmpleado,
                    salarioBruto, descuentos, salarioNeto
            );
        }
}
