/**
 * Representa un cargo de carácter exclusivo.
 *
 * Permite establecer las horas destinadas a docencia,
 * investigación y extensión.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 28/09/2026
 */
public class Exclusivo extends Cargo
{
    private int horasDeInvestigacion;
    private int horasDeExtension;

    /**
     * Construye un cargo exclusivo.
     *
     * @param p_nombreCargo nombre del cargo
     * @param p_sueldoBasico sueldo básico
     * @param p_anioIngreso año de ingreso
     * @param p_horasDocencia horas de docencia
     * @param p_horasInvestigacion horas de investigación
     * @param p_horasExtension horas de extensión
     */
    public Exclusivo( String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDocencia,
        int p_horasInvestigacion, int p_horasExtension)
    {
        super( p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDocencia);

        this.setHorasDeInvestigacion(p_horasInvestigacion);
        this.setHorasDeExtension(p_horasExtension);
    }

    private void setHorasDeInvestigacion(int p_horas)
    {
        this.horasDeInvestigacion = p_horas;
    }

    private void setHorasDeExtension(int p_horas)
    {
        this.horasDeExtension = p_horas;
    }

    public int getHorasDeInvestigacion()
    {
        return this.horasDeInvestigacion;
    }

    public int getHorasDeExtension()
    {
        return this.horasDeExtension;
    }

    /**
     * Redefine el método para mostrar las horas propias
     * de un cargo exclusivo.
     */
    @Override
    public void mostrarCargo()
    {
        super.mostrarCargo();

        System.out.println( "----Cargo de caracter Exclusivo----");

        System.out.println( "Horas investigacion: " + this.getHorasDeInvestigacion());

        System.out.println( "Horas extension: " + this.getHorasDeExtension());
    }
}