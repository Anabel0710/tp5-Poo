import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable que permite cargar por teclado una facultad,
 * sus profesores y los cargos correspondientes.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 27/09/2026
 */
public class AplicacionFacultad
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre de la facultad: ");
        String nombreFacultad = teclado.nextLine();

        System.out.print("Cantidad de profesores: ");
        int cantidadProfesores = teclado.nextInt();
        teclado.nextLine();

        Facultad facultad = null;

        for (int i = 0; i < cantidadProfesores; i++)
        {
            System.out.println(
                "\n===== PROFESOR " + (i + 1) + " ====="
            );

            System.out.print("DNI: ");
            int dni = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Apellido: ");
            String apellido = teclado.nextLine();

            System.out.print("Año de nacimiento: ");
            int anioNacimiento = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Título: ");
            String titulo = teclado.nextLine();

            int cantidadCargos;

            do
            {
                System.out.print("Cantidad de cargos (entre 1 y 3): ");

                cantidadCargos = teclado.nextInt();
                teclado.nextLine();
            }
            while (cantidadCargos < 1 || cantidadCargos > 3);

            ArrayList<Cargo> cargos = new ArrayList<Cargo>();

            for (int j = 0; j < cantidadCargos; j++)
            {
                System.out.println(
                    "\n--- CARGO " + (j + 1) + " ---"
                );

                System.out.println("1. Simple");
                System.out.println("2. Semiexclusivo");
                System.out.println("3. Exclusivo");
                System.out.print("Tipo de cargo: ");

                int tipo = teclado.nextInt();
                teclado.nextLine();

                System.out.print("Nombre del cargo: ");
                String nombreCargo = teclado.nextLine();

                System.out.print("Sueldo básico: ");
                double sueldoBasico = teclado.nextDouble();

                System.out.print("Año de ingreso al cargo: ");
                int anioIngreso = teclado.nextInt();

                Cargo cargo;

                if (tipo == 2)
                {
                    int horasInvestigacion; 
                    
                    do {
                    System.out.print("Horas de investigación (0 a 10): ");

                    horasInvestigacion = teclado.nextInt();
                    
                    if(horasInvestigacion < 0 || horasInvestigacion > 10) {
                    System.out.println("Error las horas deben estar entre 0 y 10");
                    }
                }
                while (horasInvestigacion < 0 || horasInvestigacion > 10);

                    cargo = new SemiExclusivo(nombreCargo,sueldoBasico, anioIngreso, horasInvestigacion);
        
                }
                else if (tipo == 3)
                {
                    System.out.print("Horas de docencia: ");
                    int horasDocencia = teclado.nextInt();

                    System.out.print("Horas de investigación: ");
                    int horasInvestigacion = teclado.nextInt();

                    System.out.print("Horas de extensión: ");
                    int horasExtension = teclado.nextInt();

                    cargo = new Exclusivo(nombreCargo, sueldoBasico, anioIngreso, horasDocencia,
                        horasInvestigacion, horasExtension);
                }
                else
                {
                    cargo = new Cargo( nombreCargo, sueldoBasico, anioIngreso);
                }

                cargos.add(cargo);
                teclado.nextLine();
            }

            Profesor profesor = new Profesor( dni, nombre, apellido, anioNacimiento, titulo, cargos);

            if (facultad == null)
            {
                facultad = new Facultad(nombreFacultad, profesor);
            }
            else
            {
                facultad.agregarProfesor(profesor);
            }
        }

        if (facultad != null)
        {
            System.out.println("\n===== LISTADO COMPLETO =====");
            facultad.listarProfesorCargos();

            System.out.println("\n===== NOMINA DE PROFESORES =====");
            facultad.nominaProfesores();
        }

        teclado.close();
    }
}