/**
 * Representa un círculo ubicado en el plano cartesiano.
 *
 * Un círculo es una especialización de Elipse porque sus dos
 * semiejes tienen la misma longitud: el radio.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0
 */
public class Circulo extends Elipse
{
    /**
     * Construye un círculo indicando su radio y centro.
     *
     * El radio se envía como semieje mayor y semieje menor
     * al constructor de Elipse.
     *
     * @param p_radio radio del círculo
     * @param p_centro centro del círculo
     */
    public Circulo(double p_radio, Punto p_centro)
    {
        super(p_radio, p_radio, p_centro);
    }

    /**
     * Construye un círculo con radio cero y centro en (0,0).
     */
    public Circulo()
    {
        super(0, 0, new Punto(0, 0));
    }

    /**
     * Devuelve el radio del círculo.
     *
     * El radio corresponde a cualquiera de los semiejes heredados.
     *
     * @return radio del círculo
     */
    public double getRadio()
    {
        return this.getSemiejeMayor();
    }

    /**
     * Calcula el perímetro del círculo.
     *
     * @return perímetro del círculo
     */
    @Override
    public double perimetro()
    {
        return 2 * Math.PI * this.getRadio();
    }

    /**
     * Devuelve el nombre de la figura.
     *
     * Este método permite que el polimorfismo identifique
     * correctamente al objeto como un círculo.
     *
     * @return nombre de la figura
     */
    @Override
    public String nombreFigura()
    {
        return "Círculo";
    }

    /**
     * Calcula la distancia entre los centros de dos círculos.
     *
     * @param p_otroCirculo círculo con el cual se compara
     * @return distancia entre los centros
     */
    public double distanciaA(Circulo p_otroCirculo)
    {
        return this.getCentro().distanciaA( p_otroCirculo.getCentro());
    }

    /**
     * Devuelve el círculo que tiene mayor superficie.
     *
     * @param p_otroCirculo círculo con el cual se compara
     * @return círculo de mayor superficie
     */
    public Circulo elMayor(Circulo p_otroCirculo)
    {
        if (this.superficie() >= p_otroCirculo.superficie())
        {
            return this;
        }

        return p_otroCirculo;
    }

    /** Muestra las características del círculo. */
    @Override
    public void caracteristicas()
    {
        System.out.println("***** Círculo *****");
        System.out.println("- Centro: " + this.getCentro().coordenadas());
        System.out.println("- Radio: " + this.getRadio());
        System.out.println("- Superficie: " + this.superficie());
        System.out.println("- Perímetro: " + this.perimetro());
    }
}