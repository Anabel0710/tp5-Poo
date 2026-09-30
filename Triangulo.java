/**
 * Representa un triangulo ubicado en el plano cartesiano.
 * Su origen corresponde a la esquina inferior izquierda.
 *
 * La clase puede ser reutilizada mediante herencia
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 29/09/2026
 */
public class Triangulo
{
    private Punto origen;
    private double base;
    private double altura;

    /**
     * Construye un triangulo indicando su origen y sus dimensiones.
     *
     * @param p_origen esquina inferior izquierda del triangulo
     * @param p_base base del triangulo
     * @param p_altura altura del triangulo
     */
    public Triangulo(Punto p_origen, double p_base, double p_altura)
    {
        this.setOrigen(p_origen);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }

    /**
     * Construye un triangulo con origen en el punto (0, 0).
     *
     * @param p_base base del triangulo
     * @param p_altura altura del triangulo
     */
    public Triangulo(double p_base, double p_altura)
    {
        this(new Punto(0, 0), p_base, p_altura);
    }

    /** Setters privados. */
    private void setOrigen(Punto p_origen)
    {
        this.origen = p_origen;
    }

    private void setBase(double p_base)
    {
        this.base = p_base;
    }

    private void setAltura(double p_altura)
    {
        this.altura = p_altura;
    }

    /**
     * Los getters son protected para que puedan ser utilizados
     * por las subclases, como Cuadrado.
     */
    protected Punto getOrigen()
    {
        return this.origen;
    }

    protected double getBase()
    {
        return this.base;
    }

    protected double getAltura()
    {
        return this.altura;
    }

    /**
     * Devuelve el nombre de la figura.
     *
     * @return nombre del triangulo
     */
    public String nombreFigura()
    {
        return "****** Triangulo ******";
    }

    /**
     * Desplaza el triangulo modificando las coordenadas de su origen.
     *
     * @param p_dx desplazamiento sobre el eje X
     * @param p_dy desplazamiento sobre el eje Y
     */
    public void desplazar(double p_dx, double p_dy)
    {
        this.getOrigen().desplazar(p_dx, p_dy);
    }

    /**
     * Calcula el perímetro del triangulo.
     *
     * @return perímetro del triangulo
     */
    public double perimetro()
    {
        return  (this.getBase() + (this.getAltura() * 2));
    }

    /**
     * Calcula la superficie del triangulo.
     *
     * @return superficie del triangulo
     */
    public double superficie()
    {
        return (this.getBase() * this.getAltura()) / 2 ;
    }

    /**
     * Muestra las características del triangulo.
     */
    public void caracteristicas()
    {
        System.out.println(this.nombreFigura());

        System.out.println(
            "Origen: " + this.getOrigen().coordenadas()
            + " - altura: " + this.getAltura()
            + " - base: " + this.getBase()
        );

        System.out.printf("Superficie: %.2f - Perimetro: %.2f%n", this.superficie(), this.perimetro());
    }

    /**
     * Calcula la distancia entre los orígenes de dos triangulos.
     *
     * @param p_otroTriangulo triangulo con el cual se compara
     * @return distancia entre los orígenes
     */
    public double distanciaA(Triangulo p_otroTriangulo)
    {
        return this.getOrigen().distanciaA(
            p_otroTriangulo.getOrigen()
        );
    }

    /**
     * Devuelve el triangulo que posee mayor superficie.
     *
     * @param p_otroTriangulo triangulo con el cual se compara
     * @return triangulo de mayor superficie
     */
    public Triangulo elMayor(Triangulo p_otroTriangulo)
    {
        if (this.superficie() >= p_otroTriangulo.superficie())
        {
            return this;
        }

        return p_otroTriangulo;
    }
}