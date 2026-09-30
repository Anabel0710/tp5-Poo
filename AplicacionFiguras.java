import java.util.Scanner;

/**
 * Clase ejecutable para comprobar el funcionamiento de las clases
 * Rectangulo y Cuadrado mediante el ingreso de datos por teclado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 26/09/2026
 */
public class AplicacionFiguras
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("===== CARGA DEL RECTANGULO =====");

        System.out.print("Coordenada X del origen: ");
        double xRectangulo = teclado.nextDouble();

        System.out.print("Coordenada Y del origen: ");
        double yRectangulo = teclado.nextDouble();

        System.out.print("Ancho: ");
        double ancho = teclado.nextDouble();

        System.out.print("Alto: ");
        double alto = teclado.nextDouble();

        Punto origenRectangulo = new Punto(xRectangulo, yRectangulo);

        Rectangulo rectangulo = new Rectangulo(origenRectangulo, ancho, alto);

        System.out.println("\n===== CARGA DEL CUADRADO =====");

        System.out.print("Coordenada X del origen: ");
        double xCuadrado = teclado.nextDouble();

        System.out.print("Coordenada Y del origen: ");
        double yCuadrado = teclado.nextDouble();

        System.out.print("Lado: ");
        double lado = teclado.nextDouble();

        Punto origenCuadrado = new Punto(xCuadrado, yCuadrado);

        Cuadrado cuadrado = new Cuadrado( origenCuadrado, lado);

        System.out.println("\n===== CARACTERISTICAS =====");

        rectangulo.caracteristicas();
        System.out.println();
        cuadrado.caracteristicas();

        System.out.println("\n===== FIGURA DE MAYOR SUPERFICIE =====");

        Rectangulo figuraMayor = rectangulo.elMayor(cuadrado);
        figuraMayor.caracteristicas();

        teclado.close();
    }
}