import java.util.Calendar;

/**
 * Representa un cargo docente de carácter simple.
 * Un cargo simple posee diez horas semanales de docencia.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 28/09/2026
 */
public class Cargo
{
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;

    /**
     * Construye un cargo simple con diez horas de docencia.
     *
     * @param p_nombreCargo nombre del cargo y de la materia
     * @param p_sueldoBasico sueldo básico
     * @param p_anioIngreso año de ingreso al cargo
     */
    public Cargo( String p_nombreCargo, double p_sueldoBasico,int p_anioIngreso)
    {
        this( p_nombreCargo, p_sueldoBasico, p_anioIngreso, 10);
    }

    /**
     * Constructor utilizado por las subclases para indicar
     * una cantidad particular de horas de docencia.
     */
    protected Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia)
    {
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
        this.setHorasDeDocencia(p_horasDeDocencia);
    }

    /** Setters privados. */
    private void setNombreCargo(String p_nombreCargo)
    {
        this.nombreCargo = p_nombreCargo;
    }

    private void setSueldoBasico(double p_sueldoBasico)
    {
        this.sueldoBasico = p_sueldoBasico;
    }

    private void setAnioIngreso(int p_anioIngreso)
    {
        this.anioIngreso = p_anioIngreso;
    }

    private void setHorasDeDocencia(int p_horasDeDocencia)
    {
        this.horasDeDocencia = p_horasDeDocencia;
    }

    /** Getters. */
    public String getNombreCargo()
    {
        return this.nombreCargo;
    }

    public double getSueldoBasico()
    {
        return this.sueldoBasico;
    }

    public int getAnioIngreso()
    {
        return this.anioIngreso;
    }

    public int getHorasDeDocencia()
    {
        return this.horasDeDocencia;
    }

    /**
     * Calcula la antigüedad en el cargo.
     *
     * @return cantidad de años en el cargo
     */
    public int antiguedad()
    {
        Calendar hoy = Calendar.getInstance();

        return hoy.get(Calendar.YEAR) - this.getAnioIngreso();
    }

    /**
     * Calcula un adicional del 1% del sueldo básico por
     * cada año de antigüedad.
     */
    private double adicionalXAntiguedad()
    {
        return this.getSueldoBasico() * 0.01 * this.antiguedad();
    }

    /**
     * Calcula el sueldo correspondiente al cargo.
     *
     * @return sueldo básico más adicional por antigüedad
     */
    public double sueldoDelCargo()
    {
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
    }

    /**
     * Muestra los datos del cargo.
     * Las subclases redefinen este método para agregar
     * información particular.
     */
    public void mostrarCargo()
    {
        System.out.printf("%s - Sueldo Basico: %.2f" + " - Sueldo Cargo: %.2f" + " - Antiguedad: %d años%n",
            this.getNombreCargo(), this.getSueldoBasico(), this.sueldoDelCargo(), this.antiguedad());

        System.out.println("Horas Docencia: " + this.getHorasDeDocencia());
    }
}