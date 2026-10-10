import java.util.Scanner;

/**
 * Clase ejecutable para comprobar el funcionamiento de las clases
 * Elipse y Circulo mediante el ingreso de datos por teclado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 27/09/2026
 */
public class AplicacionElipse
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("===== CARGA DE LA ELIPSE =====");

        System.out.print("Coordenada X del centro: ");
        double xElipse = teclado.nextDouble();

        System.out.print("Coordenada Y del centro: ");
        double yElipse = teclado.nextDouble();

        System.out.print("Semieje mayor: ");
        double semiejeMayor = teclado.nextDouble();

        System.out.print("Semieje menor: ");
        double semiejeMenor = teclado.nextDouble();

        Punto centroElipse = new Punto(xElipse, yElipse);

        Elipse elipse = new Elipse(semiejeMayor, semiejeMenor, centroElipse);

        System.out.println("\n===== CARGA DEL CIRCULO =====");

        System.out.print("Coordenada X del centro: ");
        double xCirculo = teclado.nextDouble();

        System.out.print("Coordenada Y del centro: ");
        double yCirculo = teclado.nextDouble();

        System.out.print("Radio: ");
        double radio = teclado.nextDouble();

        Punto centroCirculo = new Punto(xCirculo, yCirculo);

        Circulo circulo = new Circulo( radio, centroCirculo);

        System.out.println("\n===== CARACTERISTICAS =====");

        elipse.caracteristicas();
        System.out.println();
        circulo.caracteristicas();

        System.out.println("\n===== DISTANCIA ENTRE CENTROS =====");

        System.out.printf("Distancia: %.2f%n", elipse.distanciaA(circulo));

        System.out.println("\n===== FIGURA DE MAYOR SUPERFICIE =====");

        Elipse figuraMayor = elipse.elMayor(circulo);
        figuraMayor.caracteristicas();

        teclado.close();
    }
}