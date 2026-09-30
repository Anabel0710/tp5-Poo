import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable que prueba una caja de ahorro y una cuenta
 * corriente pertenecientes a un mismo titular.
 * También verifica si el titular está cumpliendo años.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 23/08/2026
 */
public class Banco
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos del titular.
        System.out.print("Ingrese el DNI del titular: ");
        int dni = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Ingrese el nombre del titular: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese el apellido del titular: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese el día de nacimiento: ");
        int diaNacimiento = teclado.nextInt();

        System.out.print("Ingrese el mes de nacimiento: ");
        int mesNacimiento = teclado.nextInt();

        System.out.print("Ingrese el año de nacimiento: ");
        int anioNacimiento = teclado.nextInt();

        /**
         * Se crea la fecha de nacimiento.
         * Calendar numera los meses desde 0 hasta 11,
         * por eso se resta uno al mes ingresado.
         */
        Calendar fechaNacimiento = new GregorianCalendar(anioNacimiento, mesNacimiento - 1, diaNacimiento);

        // Se crea un único objeto Persona.
        Persona titular = new Persona(dni, nombre, apellido, fechaNacimiento);

        /**
         * Se comprueba si la fecha actual coincide con el día
         * y el mes de nacimiento del titular.
         */
        if (titular.esCumpleaños())
        {
            System.out.println(
                "\n¡Feliz cumpleaños, "
                + titular.nomYApe() + "!"
            );
        }

        // Datos de la caja de ahorro.
        System.out.print("\nIngrese el número de caja de ahorro: ");
        int nroCajaAhorro = teclado.nextInt();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoCajaAhorro = teclado.nextDouble();

        CajaDeAhorro cajaAhorro = new CajaDeAhorro(nroCajaAhorro, titular, saldoCajaAhorro);

        // Datos de la cuenta corriente.
        System.out.print("\nIngrese el número de cuenta corriente: ");
        int nroCuentaCorriente = teclado.nextInt();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoCuentaCorriente = teclado.nextDouble();

        CuentaCorriente cuentaCorriente = new CuentaCorriente(
            nroCuentaCorriente,
            titular,
            saldoCuentaCorriente
        );

        System.out.println("\nESTADO INICIAL\n");

        cajaAhorro.mostrar();

        System.out.println();

        cuentaCorriente.mostrar();

        /*
         * PRUEBAS DE CUENTA CORRIENTE
         */

        System.out.println("\nPRUEBAS DE CUENTA CORRIENTE");

        System.out.print("Ingrese un importe para depositar: ");
        double depositoCorriente = teclado.nextDouble();

        cuentaCorriente.depositar(depositoCorriente);

        System.out.print("Ingrese un importe permitido para extraer: ");
        double extraccionCorriente = teclado.nextDouble();

        cuentaCorriente.extraer(extraccionCorriente);

        System.out.print(
            "Ingrese un importe que supere el saldo "
            + "más el descubierto: ");
        double extraccionNoPermitida = teclado.nextDouble();

        cuentaCorriente.extraer(extraccionNoPermitida);

        System.out.println("\nEstado de la cuenta corriente:");
        cuentaCorriente.mostrar();

        /*
         * PRUEBAS DE CAJA DE AHORRO
         */

        System.out.println("\nPRUEBAS DE CAJA DE AHORRO");

        System.out.print("Ingrese un importe para depositar: ");
        double depositoAhorro = teclado.nextDouble();

        cajaAhorro.depositar(depositoAhorro);

        System.out.print("Ingrese un importe permitido para extraer: ");
        double extraccionAhorro = teclado.nextDouble();

        cajaAhorro.extraer(extraccionAhorro);

        System.out.print( "Ingrese un importe mayor que el saldo disponible: ");
        double extraccionSinSaldo = teclado.nextDouble();

        cajaAhorro.extraer(extraccionSinSaldo);

        System.out.println("\nEstado de la caja de ahorro:");
        cajaAhorro.mostrar();

        /*
         * La primera extracción permitida ya consumió una de las
         * diez extracciones. Se utilizan las nueve restantes.
         * Antes se deposita dinero suficiente.
         */
        cajaAhorro.depositar(20.0);

        for (int i = 1; i <= 9; i++)
        {
            cajaAhorro.extraer(1.0);
        }

        /*
         * Esta es la extracción número once y debe rechazarse
         * porque ya no quedan extracciones disponibles.
         */
        System.out.println("\nIntento de extracción sin extracciones disponibles:" );

        cajaAhorro.extraer(1.0);

        System.out.println("\nESTADO FINAL\n");

        cajaAhorro.mostrar();

        System.out.println();

        cuentaCorriente.mostrar();

        teclado.close();
    }
}