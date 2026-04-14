package co.edu.uniquindio.EmpresaNomina;

import co.edu.uniquindio.EmpresaNomina.model.*;

import javax.swing.*;


public class App {

    private static final Empresa miEmpresa = new Empresa("Nómina Quindío", 123456789);
    private static final Empleado empleadoTemporal1 = new EmpleadoTemporal("a","1", 1,1, Categoria.JUNIOR,1,1,1,1);
    private static final Empleado empledoPlanta1 = new EmpleadoPlanta("a","1", 1,1, Categoria.JUNIOR,1,1,"1",1, 1,1);
    private static final Empleado empledoVenta1 = new EmpleadoVenta("a","1", 1,1, Categoria.JUNIOR,1,1,1,1);




    public static void main(String[] args) {
        //Empleados de prueba
        EmpleadoPlanta e1 = new EmpleadoPlanta("Carlos Ruiz", "123", 35, 2500000f, Categoria.SENIOR, 0.04f, 0.04f, "Analista", 10, 15000f, 162000f);

        EmpleadoTemporal t1 = new EmpleadoTemporal("Sofía Ramírez", "678", 25, 1800000f, Categoria.JUNIOR, 0.04f, 0.04f, 20, 60000f);

        EmpleadoVenta v1 = new EmpleadoVenta("Pedro Sánchez", "223", 31, 1500000f, Categoria.SEMISENIOR, 0.04f, 0.04f, 5000000f, 0.05f);

        miEmpresa.agregarEmpleado(e1);
        miEmpresa.agregarEmpleado(t1);
        miEmpresa.agregarEmpleado(v1);




        String menu = "-----Menu Gestion De Nomina------ \n" +
                "Marque alguna de estas opciones \n" +
                "  \n" +
                "  " +
                "1. Ingresar Cambios \n" +
                "2. Crear grupo \n" +
                "3. Registrar Contacto\n" +
                "4. Crear Reunion \n" +
                "5 \n" +
                "\n" +
                "\n" +
                "8. Salir de la agenda\n";

        String menuModificar = "-----Menu Modificar------ \n" +
                "Marque alguna de estas opciones \n" +
                "  \n" +
                "  " +
                "1. Ingresar horas extra\n" +
                "2. Modificar Descuento\n" +
                "3. Buscar contactos del mismo nombre \n" +
                "4. Buscar y mostra GrupoContacto  \n" +
                "5 \n" +
                "\n" +
                "\n" +
                "7. Salir de la agenda\n";


        int opcion = 0;
        int opcionBuscar=0;
        String input = "";
        String inputModificar = "";
        int contError = 0;

        while(opcion!=8){
            input = JOptionPane.showInputDialog(menu);


            if (input==null){

                contError+=1;

                if (contError>=3){
                    JOptionPane.showMessageDialog(null, "Excedió el número de errores,  adios");
                    break;
                }
                continue;

            }


// Sirve para aislar un posible error al captar información sin tener que parar el ciclo
            try{
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Debe ingrear un número correspondiente a una opción");
                continue;
            }


            switch (opcion){
                case 1 : { inputModificar = JOptionPane.showInputDialog(menuModificar);

                    try{
                        opcionBuscar = Integer.parseInt(inputModificar);
                    } catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Debe ingrear un número correspondiente a una opción");
                        continue;
                    }
                    switch (opcionBuscar){
                        case 1 : {
                            continue;
                        }
                        case 2 : {
                            continue;

                        }

                        case 3 : {
                            continue;

                        }

                        case 4 : {

                            continue;

                        }

                        case 7: continue;

                        default: JOptionPane.showMessageDialog(null,"No marcó una opción valida");
                            continue;

                    }


                }

                case 2 : {
                    continue;
                }

                case 3 : {
                    continue;
                }

                case  8 : break;

                default: break;

            }
            break;
        }

    }
}
