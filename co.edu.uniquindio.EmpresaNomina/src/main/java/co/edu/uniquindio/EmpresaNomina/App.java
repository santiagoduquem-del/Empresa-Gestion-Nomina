package co.edu.uniquindio.EmpresaNomina;

import co.edu.uniquindio.EmpresaNomina.model.*;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Empresa miEmpresa = new Empresa("Nómina Quindío", 123456789);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n===== MENÚ GESTIÓN DE NÓMINA =====");
            System.out.println("1. Agregar empleado de planta");
            System.out.println("2. Agregar empleado de ventas");
            System.out.println("3. Agregar empleado temporal");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("5. Buscar empleado por documento");
            System.out.println("6. Mostrar empleado con mayor salario neto");
            System.out.println("7. Mostrar nómina total de la empresa");
            System.out.println("8. Mostrar resumen de pagos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarEmpleadoPlanta();
                    case 2 -> agregarEmpleadoVentas();
                    case 3 -> agregarEmpleadoTemporal();
                    case 4 -> miEmpresa.mostrarTodosLosEmpleados();
                    case 5 -> buscarEmpleado();
                    case 6 -> mostrarEmpleadoMayorSalario();
                    case 7 -> System.out.println(">>> NÓMINA TOTAL: $" + miEmpresa.calcularNominaTotal());
                    case 8 -> miEmpresa.mostrarResumenesPago();
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                opcion = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                opcion = -1;
            }
        } while (opcion != 0);
    }

    private static void agregarEmpleadoPlanta() {
        try {
            System.out.print("Nombre: "); String nombre = scanner.nextLine();
            System.out.print("Documento: "); String doc = scanner.nextLine();
            System.out.print("Edad: "); int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Salario Base: "); float salario = Float.parseFloat(scanner.nextLine());
            Categoria cat = solicitarCategoria();
            System.out.print("% Descuento Salud: "); float salud = Float.parseFloat(scanner.nextLine());
            System.out.print("% Descuento Pensión: "); float pension = Float.parseFloat(scanner.nextLine());
            System.out.print("Cargo: "); String cargo = scanner.nextLine();
            System.out.print("Horas Extra: "); int horas = Integer.parseInt(scanner.nextLine());
            System.out.print("Valor Hora Extra: "); float valorHora = Float.parseFloat(scanner.nextLine());
            System.out.print("Auxilio Transporte: "); float auxilio = Float.parseFloat(scanner.nextLine());

            miEmpresa.agregarEmpleado(new EmpleadoPlanta(nombre, doc, edad, salario, cat, salud, pension, cargo, horas, valorHora, auxilio));
            System.out.println("Empleado de planta agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }

    private static void agregarEmpleadoVentas() {
        try {
            System.out.print("Nombre: "); String nombre = scanner.nextLine();
            System.out.print("Documento: "); String doc = scanner.nextLine();
            System.out.print("Edad: "); int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Salario Base: "); float salario = Float.parseFloat(scanner.nextLine());
            Categoria cat = solicitarCategoria();
            System.out.print("% Descuento Salud: "); float salud = Float.parseFloat(scanner.nextLine());
            System.out.print("% Descuento Pensión: "); float pension = Float.parseFloat(scanner.nextLine());
            System.out.print("Total Ventas: "); float ventas = Float.parseFloat(scanner.nextLine());
            System.out.print("% Comisión: "); float comision = Float.parseFloat(scanner.nextLine());

            miEmpresa.agregarEmpleado(new EmpleadoVentas(nombre, doc, edad, salario, cat, salud, pension, ventas, comision));
            System.out.println("Empleado de ventas agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }

    private static void agregarEmpleadoTemporal() {
        try {
            System.out.print("Nombre: "); String nombre = scanner.nextLine();
            System.out.print("Documento: "); String doc = scanner.nextLine();
            System.out.print("Edad: "); int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Salario Base (para bonificación): "); float salario = Float.parseFloat(scanner.nextLine());
            Categoria cat = solicitarCategoria();
            System.out.print("% Descuento Salud: "); float salud = Float.parseFloat(scanner.nextLine());
            System.out.print("% Descuento Pensión: "); float pension = Float.parseFloat(scanner.nextLine());
            System.out.print("Días Trabajados: "); int dias = Integer.parseInt(scanner.nextLine());
            System.out.print("Valor Día: "); float valorDia = Float.parseFloat(scanner.nextLine());

            miEmpresa.agregarEmpleado(new EmpleadoTemporal(nombre, doc, edad, salario, cat, salud, pension, dias, valorDia));
            System.out.println("Empleado temporal agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }

    private static void buscarEmpleado() {
        System.out.print("Ingrese el documento: ");
        String doc = scanner.nextLine();
        Empleado emp = miEmpresa.buscarEmpleado(doc);
        if (emp != null) {
            emp.mostrarInformacion();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void mostrarEmpleadoMayorSalario() {
        Empleado mayor = miEmpresa.obtenerEmpleadoMayorSalario();
        if (mayor != null) {
            System.out.println("El empleado que más gana es: " + mayor.getNombre() + " ($" + mayor.calcularSalarioNeto() + ")");
        } else {
            System.out.println("No hay empleados registrados.");
        }
    }

    private static Categoria solicitarCategoria() {
        System.out.println("Categoría (1. JUNIOR, 2. SEMISENIOR, 3. SENIOR): ");
        int catOp = Integer.parseInt(scanner.nextLine());
        return switch (catOp) {
            case 1 -> Categoria.JUNIOR;
            case 2 -> Categoria.SEMISENIOR;
            case 3 -> Categoria.SENIOR;
            default -> null;
        };
    }
}
