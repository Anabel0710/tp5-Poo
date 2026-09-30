/**
 * Representa un rectángulo ubicado en el plano cartesiano.
 * Su origen corresponde a la esquina inferior izquierda.
 *
 * La clase puede ser reutilizada mediante herencia para representar
 * figuras más específicas, como la clase Cuadrado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 26/09/2026
 */
public class Rectangulo
{
    private Punto origen;
    private double ancho;
    private double alto;

    /**
     * Construye un rectángulo indicando su origen y sus dimensiones.
     *
     * @param p_origen esquina inferior izquierda del rectángulo
     * @param p_ancho ancho del rectángulo
     * @param p_alto alto del rectángulo
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto)
    {
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    /**
     * Construye un rectángulo con origen en el punto (0, 0).
     *
     * @param p_ancho ancho del rectángulo
     * @param p_alto alto del rectángulo
     */
    public Rectangulo(double p_ancho, double p_alto)
    {
        this(new Punto(0, 0), p_ancho, p_alto);
    }

    /** Setters privados. */
    private void setOrigen(Punto p_origen)
    {
        this.origen = p_origen;
    }

    private void setAncho(double p_ancho)
    {
        this.ancho = p_ancho;
    }

    private void setAlto(double p_alto)
    {
        this.alto = p_alto;
    }

    /**
     * Los getters son protected para que puedan ser utilizados
     * por las subclases, como Cuadrado.
     */
    protected Punto getOrigen()
    {
        return this.origen;
    }

    protected double getAncho()
    {
        return this.ancho;
    }

    protected double getAlto()
    {
        return this.alto;
    }

    /**
     * Devuelve el nombre de la figura.
     *
     * @return nombre del rectángulo
     */
    public String nombreFigura()
    {
        return "****** Rectangulo ******";
    }

    /**
     * Desplaza el rectángulo modificando las coordenadas de su origen.
     *
     * @param p_dx desplazamiento sobre el eje X
     * @param p_dy desplazamiento sobre el eje Y
     */
    public void desplazar(double p_dx, double p_dy)
    {
        this.getOrigen().desplazar(p_dx, p_dy);
    }

    /**
     * Calcula el perímetro del rectángulo.
     *
     * @return perímetro del rectángulo
     */
    public double perimetro()
    {
        return 2 * (this.getAncho() + this.getAlto());
    }

    /**
     * Calcula la superficie del rectángulo.
     *
     * @return superficie del rectángulo
     */
    public double superficie()
    {
        return this.getAncho() * this.getAlto();
    }

    /**
     * Muestra las características del rectángulo.
     */
    public void caracteristicas()
    {
        System.out.println(this.nombreFigura());

        System.out.println(
            "Origen: " + this.getOrigen().coordenadas()
            + " - Alto: " + this.getAlto()
            + " - Ancho: " + this.getAncho()
        );

        System.out.printf("Superficie: %.2f - Perimetro: %.2f%n", this.superficie(), this.perimetro());
    }

    /**
     * Calcula la distancia entre los orígenes de dos rectángulos.
     *
     * @param p_otroRectangulo rectángulo con el cual se compara
     * @return distancia entre los orígenes
     */
    public double distanciaA(Rectangulo p_otroRectangulo)
    {
        return this.getOrigen().distanciaA( p_otroRectangulo.getOrigen());
    }

    /**
     * Devuelve el rectángulo que posee mayor superficie.
     *
     * @param p_otroRectangulo rectángulo con el cual se compara
     * @return rectángulo de mayor superficie
     */
    public Rectangulo elMayor(Rectangulo p_otroRectangulo)
    {
        if (this.superficie() >= p_otroRectangulo.superficie())
        {
            return this;
        }

        return p_otroRectangulo;
    }
}