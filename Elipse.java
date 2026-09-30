/**
 * Representa una elipse ubicada en el plano cartesiano.
 *
 * La elipse posee un centro, un semieje mayor y un semieje menor.
 * Esta clase también funciona como superclase de Circulo.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 26/09/2026
 */
public class Elipse
{
    private double sEjeMayor;
    private double sEjeMenor;
    private Punto centro;

    /**
     * Construye una elipse indicando su centro y sus semiejes.
     *
     * @param p_centro centro de la elipse
     * @param p_sEjeMayor medida del semieje mayor
     * @param p_sEjeMenor medida del semieje menor
     */
    public Elipse(Punto p_centro, double p_sEjeMayor,double p_sEjeMenor)
    {
        this.setCentro(p_centro);
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }

    /**
     * Construye una elipse con centro en el punto (0, 0).
     *
     * @param p_sEjeMayor medida del semieje mayor
     * @param p_sEjeMenor medida del semieje menor
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor)
    {
        this(new Punto(0, 0), p_sEjeMayor, p_sEjeMenor);
    }

    /** Setters privados. */
    private void setSEjeMayor(double p_sEjeMayor)
    {
        this.sEjeMayor = p_sEjeMayor;
    }

    private void setSEjeMenor(double p_sEjeMenor)
    {
        this.sEjeMenor = p_sEjeMenor;
    }

    private void setCentro(Punto p_centro)
    {
        this.centro = p_centro;
    }

    /**
     * Los getters son protected para que puedan ser utilizados
     * por las subclases, como Circulo.
     */
    protected double getSEjeMayor()
    {
        return this.sEjeMayor;
    }

    protected double getSEjeMenor()
    {
        return this.sEjeMenor;
    }

    protected Punto getCentro()
    {
        return this.centro;
    }

    /**
     * Devuelve el nombre de la figura.
     *
     * @return nombre correspondiente a una elipse
     */
    public String nombreFigura()
    {
        return "****** Elipse ******";
    }

    /**
     * Calcula la superficie de la elipse.
     *
     * Fórmula: PI × semieje mayor × semieje menor.
     *
     * @return superficie de la elipse
     */
    public double superficie()
    {
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }

    /**
     * Desplaza la elipse modificando las coordenadas de su centro.
     *
     * @param p_dx desplazamiento sobre el eje X
     * @param p_dy desplazamiento sobre el eje Y
     */
    public void desplazar(double p_dx, double p_dy)
    {
        this.getCentro().desplazar(p_dx, p_dy);
    }

    /**
     * Calcula la distancia entre los centros de dos elipses.
     *
     * @param p_otraElipse elipse con la cual se compara
     * @return distancia entre los centros
     */
    public double distanciaA(Elipse p_otraElipse)
    {
        return this.getCentro().distanciaA( p_otraElipse.getCentro());
    }

    /**
     * Devuelve la elipse que posee mayor superficie.
     *
     * @param p_otraElipse elipse con la cual se compara
     * @return elipse de mayor superficie
     */
    public Elipse elMayor(Elipse p_otraElipse)
    {
        if (this.superficie() >= p_otraElipse.superficie())
        {
            return this;
        }

        return p_otraElipse;
    }

    /**
     * Muestra las características de la elipse.
     *
     * Se utiliza nombreFigura() para permitir que el encabezado
     * cambie cuando el objeto sea un Circulo.
     */
    public void caracteristicas()
    {
        System.out.println(this.nombreFigura());

        System.out.printf( "Centro: %s - Semieje Mayor: %.2f"
            + " - Semieje Menor: %.2f%n",
            this.getCentro().coordenadas(),
            this.getSEjeMayor(),
            this.getSEjeMenor()
        );

        System.out.printf( "Superficie: %.2f%n", this.superficie());
    }
}