import java.util.Scanner;

/**

 * Clase ejecutable que permite ingresar las figuras que desea
 * pintar un jardín y emitir el presupuesto correspondiente.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 29/09/2026
 */

public class Administracion

{
    public static void main(String[] args)

    {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Nombre del jardín: ");
        String nombreJardin = teclado.nextLine();
        
        Jardin jardin = new Jardin(nombreJardin);
        
        int cantidadFiguras;

        do

        {
            System.out.print("Cantidad de figuras: ");

            cantidadFiguras = teclado.nextInt();

            if (cantidadFiguras < 1) {

                System.out.println( "Error: debe ingresar al menos una figura.");
            }

        }

        while (cantidadFiguras < 1);



        for (int i = 0; i < cantidadFiguras; i++)

        {
            System.out.println( "\n===== FIGURA " + (i + 1) + " =====");

            int tipo;

            do

            {
                System.out.println("1. Cuadrado");

                System.out.println("2. Triángulo");

                System.out.println("3. Círculo");

                System.out.println("4. Elipse");

                System.out.print("Seleccione una figura: ");

                tipo = teclado.nextInt();
                

                if (tipo < 1 || tipo > 4)

                {

                    System.out.println("Error: seleccione una opción entre 1 y 4." );

                }

            }

            while (tipo < 1 || tipo > 4);

            System.out.print("Coordenada X del origen: ");

            double x = teclado.nextDouble();



            System.out.print("Coordenada Y del origen: ");

            double y = teclado.nextDouble();

            Punto origen = new Punto(x, y);

            FiguraGeometrica figura;

            if (tipo == 1)

            {
                double lado = leerPositivo( teclado,  "Lado del cuadrado: ");

                figura = new Cuadrado(origen, lado);

            }

            else if (tipo == 2)

            {

                double base = leerPositivo(

                    teclado,

                    "Base del triángulo: "

                );



                double altura = leerPositivo(

                    teclado,

                    "Altura del triángulo: "

                );



                figura = new Triangulo( origen, base, altura);

            }

            else if (tipo == 3)

            {

                double radio = leerPositivo( teclado, "Radio del círculo: ");

                figura = new Circulo(origen, radio);

            }

            else

            {

                double semiejeMayor = leerPositivo(teclado, "Semieje mayor: ");

                double semiejeMenor = leerPositivo( teclado, "Semieje menor: ");

                figura = new Elipse( origen, semiejeMayor, semiejeMenor);

            }



            jardin.agregarFigura(figura);

        }



        System.out.println("\n===== PRESUPUESTO =====");



        jardin.detalleFiguras();



        teclado.close();

    }



    /**

     * Solicita un número positivo.
     *
     * @param p_teclado Scanner utilizado para leer por teclado
     * @param p_mensaje mensaje que indica el dato solicitado
     * @return número positivo ingresado
     */

    private static double leerPositivo( Scanner p_teclado, String p_mensaje)
    {
        double valor;

        do

        {
            System.out.print(p_mensaje);
            valor = p_teclado.nextDouble();

            if (valor <= 0)

            {

                System.out.println( "Error: el valor debe ser mayor que cero." );

            }

        }

        while (valor <= 0);



        return valor;

    }

}

