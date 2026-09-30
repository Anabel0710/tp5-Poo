/**
 * Representa un cargo de carácter semiexclusivo.
 *
 * Posee veinte horas semanales. Como mínimo diez corresponden
 * a docencia y las restantes pueden dedicarse a investigación.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 27/09/2026
 */
public class SemiExclusivo extends Cargo
{
    private int horasDeInvestigacion;

    /**
     * Construye un cargo semiexclusivo.
     *
     * @param p_nombreCargo nombre del cargo
     * @param p_sueldoBasico sueldo básico
     * @param p_anioIngreso año de ingreso
     * @param p_horasInvestigacion horas de investigación, entre 0 y 10
     */
    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasInvestigacion)
    {
        /**
         * El total es de veinte horas. Las horas que no se dedican
         * a investigación se asignan a docencia.
         */
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, 20 - p_horasInvestigacion);

        this.setHorasDeInvestigacion(p_horasInvestigacion);
    }

    private void setHorasDeInvestigacion(int p_horas)
    {
        if (p_horas >= 0 && p_horas <= 10)
        {
            this.horasDeInvestigacion = p_horas;
        }
        else
        {
            this.horasDeInvestigacion = 0;
        }
    }

    public int getHorasDeInvestigacion()
    {
        return this.horasDeInvestigacion;
    }

    /**
     * Redefine el método para agregar las horas de investigación.
     */
    @Override
    public void mostrarCargo()
    {
        super.mostrarCargo();

        System.out.println("----Cargo de caracter SemiExclusivo----");

        System.out.println("Horas investigacion: " + this.getHorasDeInvestigacion());
    }
}