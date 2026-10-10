import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Ejecutable que simula el registro de visitantes del zoológico.
 *
 * Crea un visitante independiente y una delegación compuesta
 * por otros dos individuos.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class AplicacionZoologico
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        Zoologico zoologico = new Zoologico("El Caribú");

        Calendar fechaVisita = new GregorianCalendar(2024, Calendar.SEPTEMBER,22);

        System.out.println( "===== ZOOLÓGICO EL CARIBÚ =====");

        System.out.println("\nDatos del visitante independiente");

        Persona personaIndependiente = leerPersona(teclado);

        Individuo individuoIndependiente = new Individuo( personaIndependiente, fechaVisita);

        System.out.println("\nDatos del primer integrante de PAMI");

        Persona persona1 = leerPersona(teclado);

        Individuo integrante1 = new Individuo(persona1, fechaVisita );

        System.out.println( "\nDatos del segundo integrante de PAMI");

        Persona persona2 = leerPersona(teclado);

        Individuo integrante2 = new Individuo( persona2, fechaVisita );

        Delegacion pami = new Delegacion( "PAMI", fechaVisita);

        if (!pami.inscribirIndividuo(integrante1))
        {
            System.out.println( "El primer integrante ya estaba inscripto." );
        }

        if (!pami.inscribirIndividuo(integrante2))
        {
            System.out.println( "El segundo integrante ya estaba inscripto." );
        }

        /**
         * Se registra al visitante independiente y a la delegación.
         * Los integrantes no se agregan también como visitantes
         * porque asistieron formando parte de PAMI.
         */
        zoologico.nuevoVisitante(individuoIndependiente);
        zoologico.nuevoVisitante(pami);

        System.out.println( "\n===== TODOS LOS VISITANTES DEL 22/09/2024 =====" );

        zoologico.listarVisitantePorFecha(fechaVisita);

        Calendar inicioMes = new GregorianCalendar( 2024, Calendar.SEPTEMBER, 1 );

        Calendar finMes = new GregorianCalendar( 2024, Calendar.SEPTEMBER, 30 );

        System.out.printf( "%nRecaudación de septiembre de 2024: $%.2f%n", zoologico.recaudacion(inicioMes, finMes) );

        System.out.println( "\n===== DELEGACIONES DEL 22/09/2024 =====" );

        zoologico.listarTipoVisitantePorFecha( fechaVisita, "Delegación" );

        zoologico.mostrarPersonasQueVisitaronElZoo();

        teclado.close();
    }

    /**
     * Lee por teclado los datos necesarios para crear una persona.
     *
     * @param p_teclado objeto utilizado para leer
     * @return nueva persona
     */
    private static Persona leerPersona(Scanner p_teclado)
    {
        int dni = leerEnteroPositivo( p_teclado, "DNI: " );

        p_teclado.nextLine();

        System.out.print("Nombre: ");
        String nombre = p_teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = p_teclado.nextLine();

        int anioNacimiento = leerEnteroPositivo( p_teclado, "Año de nacimiento: " );

        return new Persona( dni, nombre, apellido, anioNacimiento );
    }

    /**
     * Lee y valida un número entero positivo.
     */
    private static int leerEnteroPositivo( Scanner p_teclado, String p_mensaje)
    {
        int valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextInt();

            if (valor <= 0)
            {
                System.out.println( "El valor debe ser mayor que cero." );
            }
        }
        while (valor <= 0);

        return valor;
    }
}