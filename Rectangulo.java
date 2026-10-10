/**
 * Representa un rectángulo ubicado en el plano cartesiano.
 *
 * Hereda de FiguraGeometrica el punto que representa su origen.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 29/09/2026
 */
public class Rectangulo extends FiguraGeometrica
{
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
        super(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    /**
     * Construye un rectángulo con origen en (0,0).
     *
     * @param p_ancho ancho del rectángulo
     * @param p_alto alto del rectángulo
     */
    public Rectangulo(double p_ancho, double p_alto)
    {
        super(new Punto(0, 0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    /** Asigna el ancho del rectángulo. */
    private void setAncho(double p_ancho)
    {
        this.ancho = p_ancho;
    }

    /** Asigna el alto del rectángulo. */
    private void setAlto(double p_alto)
    {
        this.alto = p_alto;
    }

    /** Devuelve el ancho del rectángulo. */
    public double getAncho()
    {
        return this.ancho;
    }

    /** Devuelve el alto del rectángulo. */
    public double getAlto()
    {
        return this.alto;
    }

    /**
     * Desplaza el rectángulo modificando su origen.
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
     * Implementa el método abstracto heredado de FiguraGeometrica.
     *
     * @return superficie del rectángulo
     */
    @Override
    public double superficie()
    {
        return this.getAncho() * this.getAlto();
    }

    /**
     * Devuelve el nombre de la figura.
     *
     * @return nombre de la figura
     */
    @Override
    public String nombreFigura()
    {
        return "Rectángulo";
    }

    /** Muestra las características del rectángulo. */
    public void caracteristicas()
    {
        System.out.println("***** Rectángulo *****");
        System.out.println("- Origen: " + this.getOrigen().coordenadas());
        System.out.println("- Alto: " + this.getAlto());
        System.out.println("- Ancho: " + this.getAncho());
        System.out.println("- Superficie: " + this.superficie());
        System.out.println("- Perímetro: " + this.perimetro());
    }

    /**
     * Calcula la distancia entre los orígenes de dos rectángulos.
     *
     * @param p_otroRectangulo rectángulo con el cual se compara
     * @return distancia entre los orígenes
     */
    public double distancia(Rectangulo p_otroRectangulo)
    {
        return this.getOrigen().distanciaA(
            p_otroRectangulo.getOrigen()
        );
    }

    /**
     * Devuelve el rectángulo que tiene mayor superficie.
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