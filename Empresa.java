import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable para comprobar el funcionamiento
 * de las clases Persona y Empleado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 22/09/2026
 */
public class Empresa
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("===== CARGA DE UNA PERSONA =====");

        System.out.print("DNI: ");
        int dniPersona = teclado.nextInt();
        teclado.nextLine(); // Consume el salto de línea dejado por nextInt().

        System.out.print("Nombre: ");
        String nombrePersona = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellidoPersona = teclado.nextLine();

        System.out.print("Año de nacimiento: ");
        int anioPersona = teclado.nextInt();

        // Se crea la persona con los datos ingresados por el usuario.
        Persona unaPersona = new Persona(dniPersona, nombrePersona, apellidoPersona, anioPersona);

        System.out.println("\n===== CARGA DEL PRIMER EMPLEADO =====");

        System.out.print("CUIL: ");
        long cuilEmpleado1 = teclado.nextLong();

        System.out.print("DNI: ");
        int dniEmpleado1 = teclado.nextInt();
        teclado.nextLine(); // Consume el salto de línea pendiente.

        System.out.print("Nombre: ");
        String nombreEmpleado1 = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellidoEmpleado1 = teclado.nextLine();

        System.out.print("Año de nacimiento: ");
        int anioNacimientoEmpleado1 = teclado.nextInt();

        System.out.print("Sueldo básico: ");
        double sueldoEmpleado1 = teclado.nextDouble();

        System.out.print("Año de ingreso: ");
        int anioIngresoEmpleado1 = teclado.nextInt();

        Empleado empleado1 = new Empleado( cuilEmpleado1, dniEmpleado1, nombreEmpleado1, apellidoEmpleado1,
            anioNacimientoEmpleado1, sueldoEmpleado1, anioIngresoEmpleado1);

        System.out.println("\n===== CARGA DEL SEGUNDO EMPLEADO =====");

        System.out.print("CUIL: ");
        long cuilEmpleado2 = teclado.nextLong();

        System.out.print("DNI: ");
        int dniEmpleado2 = teclado.nextInt();
        teclado.nextLine(); // Consume el salto de línea pendiente.

        System.out.print("Nombre: ");
        String nombreEmpleado2 = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellidoEmpleado2 = teclado.nextLine();

        System.out.print("Año de nacimiento: ");
        int anioNacimientoEmpleado2 = teclado.nextInt();

        System.out.print("Sueldo básico: ");
        double sueldoEmpleado2 = teclado.nextDouble();

        System.out.print("Día de ingreso: ");
        int diaIngreso = teclado.nextInt();

        System.out.print("Mes de ingreso (1 a 12): ");
        int mesIngreso = teclado.nextInt();

        System.out.print("Año de ingreso: ");
        int anioIngreso = teclado.nextInt();

        /**
         * Calendar representa enero con 0 y diciembre con 11.
         * Por eso se resta uno al mes ingresado por el usuario.
         */
        Calendar fechaIngreso = new GregorianCalendar( anioIngreso, mesIngreso - 1, diaIngreso);

        Empleado empleado2 = new Empleado(cuilEmpleado2, dniEmpleado2, nombreEmpleado2, apellidoEmpleado2, 
                             anioNacimientoEmpleado2,sueldoEmpleado2,fechaIngreso);

        System.out.println("\n***** PERSONA *****");
        unaPersona.mostrar();

        System.out.println();

        System.out.println("***** EMPLEADO 1 *****");
        empleado1.mostrar();

        System.out.println();

        System.out.println("***** EMPLEADO 2 *****");
        empleado2.mostrar();

        System.out.println();

        System.out.println("***** DATOS EN UNA LINEA *****");
        System.out.println(empleado1.mostrarLinea());
        System.out.println(empleado2.mostrarLinea());

        System.out.println();

        System.out.println("***** ANIVERSARIO *****");

        if (empleado2.esAniversario())
        {
            System.out.println(empleado2.nomYApe()+ " cumple hoy un nuevo aniversario en la empresa.");
        }
        else
        {
            System.out.println(empleado2.nomYApe() + " no cumple hoy un nuevo aniversario en la empresa.");
        }

        teclado.close();
    }
}
