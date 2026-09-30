import java.util.Scanner;

/**
 * Clase ejecutable que permite ingresar por teclado los datos
 * de una persona y de un alumno para mostrar su información.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Escuela {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("===== CARGA DE UNA PERSONA =====");

        System.out.print("DNI: ");
        int dniPersona = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nombre: ");
        String nombrePersona = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellidoPersona = teclado.nextLine();

        System.out.print("Año de nacimiento: ");
        int anioPersona = teclado.nextInt();

        Persona persona = new Persona(dniPersona, nombrePersona, apellidoPersona, anioPersona);
        
        System.out.println("\n===== CARGA DE UN ALUMNO =====");

        System.out.print("DNI: ");
        int dniAlumno = teclado.nextInt();
        teclado.nextLine(); 

        System.out.print("Nombre: ");
        String nombreAlumno = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellidoAlumno = teclado.nextLine();

        System.out.print("Año de nacimiento: ");
        int anioAlumno = teclado.nextInt();

        System.out.print("Libreta universitaria: ");
        int lu = teclado.nextInt();

        Alumno alumno = new Alumno(dniAlumno, nombreAlumno, apellidoAlumno, anioAlumno, lu);

        System.out.print("Primera nota: ");
        alumno.setNota1(teclado.nextDouble());

        System.out.print("Segunda nota: ");
        alumno.setNota2(teclado.nextDouble());

        System.out.println("\n===== DATOS DE LA PERSONA =====");
        persona.mostrar();

        System.out.println("\n===== DATOS DEL ALUMNO =====");
        alumno.mostrar();

        teclado.close();
    }
}
