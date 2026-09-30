/**
 * Representa un círculo ubicado en el plano cartesiano.
 *
 * Circulo es una especialización de Elipse porque sus dos
 * semiejes poseen la misma medida, denominada radio.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 26/09/2026
 */
public class Circulo extends Elipse
{
    /**
     * Construye un círculo indicando su radio y su centro.
     *
     * El radio se envía dos veces al constructor de Elipse porque
     * ambos semiejes de un círculo poseen la misma medida.
     *
     * Este constructor conserva el orden de parámetros utilizado
     * por la clase Circulo de los trabajos anteriores.
     *
     * @param p_radio radio del círculo
     * @param p_centro centro del círculo
     */
    public Circulo(double p_radio, Punto p_centro)
    {
        super(p_centro, p_radio, p_radio);
    }

    /**
     * Constructor alternativo que recibe primero el centro
     * y luego el radio.
     *
     * @param p_centro centro del círculo
     * @param p_radio radio del círculo
     */
    public Circulo(Punto p_centro, double p_radio)
    {
        this(p_radio, p_centro);
    }

    /**
     * Construye un círculo con radio cero y centro en (0, 0).
     */
    public Circulo()
    {
        this(0, new Punto());
    }

    /**
     * Devuelve el radio del círculo.
     *
     * Como ambos semiejes tienen la misma medida, se utiliza
     * el semieje mayor heredado de Elipse.
     *
     * @return radio del círculo
     */
    public double getRadio()
    {
        return this.getSEjeMayor();
    }

    /**
     * Devuelve el centro del círculo.
     *
     * Este método conserva el protocolo público que tenía
     * la clase Circulo en los trabajos anteriores.
     *
     * @return centro del círculo
     */
    @Override
    public Punto getCentro()
    {
        return super.getCentro();
    }

    /**
     * Calcula el perímetro del círculo.
     *
     * @return perímetro del círculo
     */
    public double perimetro()
    {
        return 2 * Math.PI * this.getRadio();
    }

    /**
     * Redefine el nombre de la figura heredado de Elipse.
     *
     * @return nombre correspondiente al círculo
     */
    @Override
    public String nombreFigura()
    {
        return "****** Circulo ******";
    }
}