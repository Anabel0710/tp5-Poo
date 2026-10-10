import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable que permite cargar electrodomésticos y
 * simular su compra en cuotas.
 *
 * Demuestra el uso de herencia, clases abstractas,
 * sobrescritura y polimorfismo.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Comercio
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        ArrayList<ArtefactoHogar> artefactos = new ArrayList<ArtefactoHogar>();

        int cantidad;

        do
        {
            System.out.print("Cantidad de artefactos que desea cargar: ");

            cantidad = teclado.nextInt();

            if (cantidad <= 0)
            {
                System.out.println( "Debe ingresar al menos un artefacto.");
            }
        }
        while (cantidad <= 0);

        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("\n===== ARTEFACTO " + (i + 1) + " =====");

            System.out.println("1. Cocina");
            System.out.println("2. Heladera");
            System.out.println("3. Lavarropas");

            int tipo;

            do
            {
                System.out.print("Seleccione el tipo: ");
                tipo = teclado.nextInt();

                if (tipo < 1 || tipo > 3)
                {
                    System.out.println( "La opción debe estar entre 1 y 3." );
                }
            }
            while (tipo < 1 || tipo > 3);

            teclado.nextLine();

            System.out.print("Marca: ");
            String marca = teclado.nextLine();

            float precio = leerFloatPositivo( teclado, "Precio: " );

            int stock = leerEnteroNoNegativo( teclado, "Stock: " );

            ArtefactoHogar artefacto;

            if (tipo == 1)
            {
                int hornallas = leerEnteroPositivo( teclado, "Cantidad de hornallas: ");

                int calorias = leerEnteroPositivo( teclado, "Calorías: " );

                teclado.nextLine();

                System.out.print( "Dimensiones, por ejemplo 80*60*60cm: " );

                String dimensiones = teclado.nextLine();

                artefacto = new Cocina( marca, precio, stock, hornallas, calorias, dimensiones );
            }
            else if (tipo == 2)
            {
                int pies = leerEnteroPositivo( teclado, "Cantidad de pies: " );

                int puertas = leerEnteroPositivo( teclado, "Cantidad de puertas: " );

                boolean compresor = leerBooleano( teclado, "¿Posee compresor? (S/N): " );

                artefacto = new Heladera( marca, precio, stock, pies, puertas, compresor);
            }
            else
            {
                int programas = leerEnteroPositivo( teclado, "Cantidad de programas: " );

                float kilos = leerFloatPositivo(  teclado, "Capacidad en kilogramos: " );

                boolean automatico = leerBooleano( teclado, "¿Es automático? (S/N): ");

                artefacto = new Lavarropas(marca, precio, stock, programas, kilos, automatico);
            }

            /** Aunque artefacto está declarado como ArtefactoHogar,
             * puede guardar una Cocina, Heladera o Lavarropas.
             */
            artefactos.add(artefacto);
        }

        int cuotas = leerEnteroPositivo( teclado, "\nCantidad de cuotas: ");

        float interes = leerFloatNoNegativo(teclado, "Porcentaje de interés: ");

        System.out.println("\n===== SIMULACIÓN DE CRÉDITO =====");

        /**
         * Se aplica polimorfismo: Java ejecuta imprimir() y
         * creditoConAdicional() según el tipo real del objeto.
         */
        for (ArtefactoHogar artefacto : artefactos)
        {
            artefacto.imprimir();

            System.out.printf("Cuotas: %d - Interés: %.2f%%%n", cuotas, interes);

            System.out.printf( "Valor Cuota: %.2f%n", artefacto.cuotaCredito(cuotas, interes));

            System.out.printf("Valor Cuota Con Adicionales: %.2f%n%n",artefacto.creditoConAdicional(cuotas,interes));
        }

        teclado.close();
    }

    /**
     * Lee un número entero mayor que cero.
     */
    private static int leerEnteroPositivo(Scanner p_teclado, String p_mensaje)
    {
        int valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextInt();

            if (valor <= 0)
            {
                System.out.println("El valor debe ser mayor que cero.");
            }
        }
        while (valor <= 0);

        return valor;
    }

    /**
     * Lee un número entero mayor o igual que cero.
     */
    private static int leerEnteroNoNegativo(Scanner p_teclado, String p_mensaje)
    {
        int valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextInt();

            if (valor < 0)
            {
                System.out.println( "El valor no puede ser negativo.");
            }
        }
        while (valor < 0);

        return valor;
    }

    /**
     * Lee un número decimal mayor que cero.
     */
    private static float leerFloatPositivo(Scanner p_teclado, String p_mensaje)
    {
        float valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextFloat();

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
    private static float leerFloatNoNegativo(Scanner p_teclado, String p_mensaje) {
        float valor;

        do
        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextFloat();

            if (valor < 0)
            {
                System.out.println("El interés no puede ser negativo.");
            }
        }
        while (valor < 0);

        return valor;
    }

    /**
     * Lee una respuesta S o N y la convierte a boolean.
     */
    private static boolean leerBooleano(Scanner p_teclado,String p_mensaje) {
        String respuesta;

        do
        {
            System.out.print(p_mensaje);
            respuesta = p_teclado.next();

            if (!respuesta.equalsIgnoreCase("S")  && !respuesta.equalsIgnoreCase("N"))
            {
                System.out.println( "Debe ingresar S o N.");
            }
        }
        while (!respuesta.equalsIgnoreCase("S")  && !respuesta.equalsIgnoreCase("N"));

        return respuesta.equalsIgnoreCase("S");
    }
}