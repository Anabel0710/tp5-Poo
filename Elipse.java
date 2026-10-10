/**
 * Representa una elipse ubicada en el plano cartesiano.
 *
 * Hereda de FiguraGeometrica el punto que representa su centro.
 * En esta clase, el origen heredado se interpreta como el centro
 * de la elipse.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 29/09/2026
 */
public class Elipse extends FiguraGeometrica
{
    private double semiejeMayor;
    private double semiejeMenor;

    /**
     * Construye una elipse indicando sus semiejes y su centro.
     *
     * @param p_semiejeMayor longitud del semieje mayor
     * @param p_semiejeMenor longitud del semieje menor
     * @param p_centro centro de la elipse
     */
    public Elipse(double p_semiejeMayor, double p_semiejeMenor, Punto p_centro) {
        super(p_centro);
        this.setSemiejeMayor(p_semiejeMayor);
        this.setSemiejeMenor(p_semiejeMenor);
    }

    /**
     * Construye una elipse con centro en (0,0).
     *
     * @param p_semiejeMayor longitud del semieje mayor
     * @param p_semiejeMenor longitud del semieje menor
     */
    public Elipse(double p_semiejeMayor, double p_semiejeMenor)
    {
        super(new Punto(0, 0));
        this.setSemiejeMayor(p_semiejeMayor);
        this.setSemiejeMenor(p_semiejeMenor);
    }

    /** Asigna el semieje mayor. */
    private void setSemiejeMayor(double p_semiejeMayor)
    {
        this.semiejeMayor = p_semiejeMayor;
    }

    /** Asigna el semieje menor. */
    private void setSemiejeMenor(double p_semiejeMenor)
    {
        this.semiejeMenor = p_semiejeMenor;
    }

    /** Devuelve el semieje mayor. */
    public double getSemiejeMayor()
    {
        return this.semiejeMayor;
    }

    /** Devuelve el semieje menor. */
    public double getSemiejeMenor()
    {
        return this.semiejeMenor;
    }

    /**
     * Devuelve el centro de la elipse.
     *
     * El centro corresponde al origen heredado de FiguraGeometrica.
     *
     * @return centro de la elipse
     */
    public Punto getCentro()
    {
        return this.getOrigen();
    }

    /**
     * Desplaza el centro de la elipse.
     *
     * @param p_dx desplazamiento sobre el eje X
     * @param p_dy desplazamiento sobre el eje Y
     */
    public void desplazar(double p_dx, double p_dy)
    {
        this.getCentro().desplazar(p_dx, p_dy);
    }

    /**
     * Calcula la superficie de la elipse.
     *
     * Fórmula: PI × semieje mayor × semieje menor.
     *
     * @return superficie de la elipse
     */
    @Override
    public double superficie()
    {
        return Math.PI * this.getSemiejeMayor() * this.getSemiejeMenor();
    }

    /**
     * Calcula aproximadamente el perímetro de la elipse.
     *
     * @return perímetro aproximado
     */
    public double perimetro()
    {
        double a = this.getSemiejeMayor();
        double b = this.getSemiejeMenor();

        return Math.PI * ( 3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }

    /**
     * Devuelve el nombre de la figura.
     *
     * @return nombre de la figura
     */
    @Override
    public String nombreFigura()
    {
        return "Elipse";
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
     * Devuelve la elipse que tiene mayor superficie.
     *
     * @param p_otraElipse elipse con la cual se compara
     * @return elipse de mayor superficie
     */
    public Elipse elMayor(Elipse p_otraElipse){
        if (this.superficie() >= p_otraElipse.superficie())
        {
            return this;
        }

        return p_otraElipse;
    }

    /** Muestra las características de la elipse. */
    public void caracteristicas(){
        System.out.println("***** Elipse *****");
        System.out.println("- Centro: " + this.getCentro().coordenadas());
        System.out.println("- Semieje mayor: " + this.getSemiejeMayor());
        System.out.println("- Semieje menor: " + this.getSemiejeMenor());
        System.out.println("- Superficie: " + this.superficie());
        System.out.println("- Perímetro aproximado: " + this.perimetro());
    }
}