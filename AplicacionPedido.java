import java.util.Scanner;

/**
 * Clase ejecutable que permite armar un pedido de etiquetas
 * ingresando los datos por teclado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class AplicacionPedido
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println( "===== EMPRESA ETIQUET.AR =====" );

        int cantidadItems = leerEnteroPositivo( teclado, "Cantidad de ítems del pedido: " );

        /**
         * La cardinalidad del pedido es 1..*, por lo que primero
         * se crea obligatoriamente el primer renglón.
         */
        System.out.println("\n===== ITEM 1 =====");

        Renglon primerRenglon = leerRenglon(teclado);
        Pedido pedido = new Pedido(primerRenglon);

        /**
         * Los demás renglones se agregan después de haber
         * construido el pedido.
         */
        for (int i = 1; i < cantidadItems; i++)
        {
            System.out.println( "\n===== ITEM " + (i + 1) + " =====" );

            Renglon nuevoRenglon = leerRenglon(teclado);
            pedido.agregarRenglon(nuevoRenglon);
        }

        pedido.mostrar();

        teclado.close();
    }

    /**
     * Lee los datos necesarios para crear un renglón.
     *
     * @param p_teclado objeto utilizado para leer datos
     * @return nuevo renglón
     */
    private static Renglon leerRenglon(Scanner p_teclado)
    {
        int tipo;

        do
        {
            System.out.println("1. Etiqueta Premium");
            System.out.println("2. Etiqueta Común");
            System.out.print("Seleccione el tipo: ");

            tipo = p_teclado.nextInt();

            if (tipo < 1 || tipo > 2)
            {
                System.out.println( "La opción debe ser 1 o 2." );
            }
        }
        while (tipo < 1 || tipo > 2);

        int cantidad = leerEnteroPositivo(  p_teclado, "Cantidad de etiquetas: " );

        double costo = leerDoublePositivo( p_teclado, "Costo unitario: $" );

        Etiqueta etiqueta;

        if (tipo == 1)
        {
            int colores = leerEnteroPositivo( p_teclado, "Cantidad de colores: " );

            etiqueta = new Premium(costo, colores);
        }
        else
        {
            double diseño = leerDoubleNoNegativo( p_teclado, "Costo del diseño: $" );

            etiqueta = new Comun(costo, diseño);
        }

        /**
         * Se aplica polimorfismo porque Renglon recibe una
         * referencia de tipo Etiqueta que puede guardar un
         * objeto Premium o Comun.
         */
        return new Renglon(cantidad, etiqueta);
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