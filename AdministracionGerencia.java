import java.util.Scanner;

/**
 * Clase ejecutable que permite registrar alojamientos y servicios
 * utilizando datos ingresados por teclado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 6/10/2026
 */
public class AdministracionGerencia
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre de la gerencia: ");
        String nombreGerencia = teclado.nextLine();

        Gerencia gerencia = new Gerencia(nombreGerencia);

        int cantidad = leerEnteroPositivo(  teclado,  "Cantidad de alojamientos: " );

        for (int i = 0; i < cantidad; i++)
        {
            System.out.println( "\n===== ALOJAMIENTO " + (i + 1) + " =====" );

            int tipo;

            do
            {
                System.out.println("1. Hotel");
                System.out.println("2. Cabaña");
                System.out.print("Seleccione el tipo: ");

                tipo = teclado.nextInt();

                if (tipo < 1 || tipo > 2)
                {
                    System.out.println( "La opción debe ser 1 o 2." );
                }
            }
            while (tipo < 1 || tipo > 2);

            teclado.nextLine();

            System.out.print("Nombre del alojamiento: ");
            String nombre = teclado.nextLine();

            double precioBase = leerDoublePositivo( teclado, "Precio base por día: " );

            int dias = leerEnteroPositivo( teclado, "Cantidad de días: " );

            Alojamiento alojamiento;

            if (tipo == 1)
            {
                String tipoHabitacion;

                do
                {
                    System.out.print( "Tipo de habitación (Single/Doble): " );

                    tipoHabitacion = teclado.next();

                    if (!tipoHabitacion.equalsIgnoreCase("Single") && !tipoHabitacion.equalsIgnoreCase("Doble"))
                    {
                        System.out.println( "Debe ingresar Single o Doble." );
                    }
                }
                while (!tipoHabitacion.equalsIgnoreCase("Single") && !tipoHabitacion.equalsIgnoreCase("Doble"));

                alojamiento = new Hotel( nombre, precioBase, dias, tipoHabitacion );
            }
            else
            {
                int habitaciones = leerEnteroPositivo( teclado, "Cantidad de habitaciones: " );

                alojamiento = new Cabaña( nombre, precioBase, dias, habitaciones );
            }

            cargarServicios(teclado, alojamiento);

            /**
             * Se agrega tanto Hotel como Cabaña a una colección
             * declarada para objetos Alojamiento.
             */
            gerencia.agregarAlojamiento(alojamiento);
        }

        gerencia.mostrarLiquidacion();

        teclado.close();
    }

    /**
     * Permite cargar los servicios de un alojamiento.
     *
     * @param p_teclado objeto utilizado para leer datos
     * @param p_alojamiento alojamiento que recibirá los servicios
     */
    private static void cargarServicios( Scanner p_teclado, Alojamiento p_alojamiento)
    {
        int cantidadServicios = leerEnteroNoNegativo( p_teclado, "Cantidad de servicios adicionales: " );

        p_teclado.nextLine();

        for (int i = 0; i < cantidadServicios; i++)
        {
            System.out.println( "\nServicio " + (i + 1) );

            System.out.print("Descripción: ");
            String descripcion = p_teclado.nextLine();

            double precio = leerDoubleNoNegativo( p_teclado, "Precio del servicio: " );

            p_teclado.nextLine();

            Servicio servicio = new Servicio( descripcion, precio );

            p_alojamiento.agregarServicio(servicio);
        }
    }

    /**
     * Lee un entero mayor que cero.
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

    /**
     * Lee un entero mayor o igual que cero.
     */
    private static int leerEnteroNoNegativo( Scanner p_teclado, String p_mensaje)
    {
        int valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextInt();

            if (valor < 0)
            {
                System.out.println( "El valor no puede ser negativo." );
            }
        }
        while (valor < 0);

        return valor;
    }

    /**
     * Lee un número decimal mayor que cero.
     */
    private static double leerDoublePositivo( Scanner p_teclado, String p_mensaje)
    {
        double valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextDouble();

            if (valor <= 0)
            {
                System.out.println( "El valor debe ser mayor que cero." );
            }
        }
        while (valor <= 0);

        return valor;
    }

    /**
     * Lee un número decimal mayor o igual que cero.
     */
    private static double leerDoubleNoNegativo( Scanner p_teclado, String p_mensaje)
    {
        double valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextDouble();

            if (valor < 0)
            {
                System.out.println( "El valor no puede ser negativo." );
            }
        }
        while (valor < 0);

        return valor;
    }
}