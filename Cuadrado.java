/**
 * Representa un cuadrado en el plano cartesiano.
 *
 * Cuadrado es una especialización de Rectangulo, ya que posee
 * todas sus características, pero su ancho y su alto son iguales.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 26/09/2026
 */
public class Cuadrado extends Rectangulo
{
    /**
     * Construye un cuadrado indicando su origen y la medida del lado.
     *
     * Se envía el lado dos veces al constructor de Rectangulo,
     * porque en un cuadrado el ancho y el alto son iguales.
     *
     * @param p_origen esquina inferior izquierda del cuadrado
     * @param p_lado medida del lado del cuadrado
     */
    public Cuadrado(Punto p_origen, double p_lado)
    {
        super(p_origen, p_lado, p_lado);
    }

    /**
     * Devuelve la medida del lado del cuadrado.
     *
     * @return medida del lado
     */
    public double getLado()
    {
        return this.getAncho();
    }

    /**
     * Redefine el método heredado para devolver el nombre
     * correspondiente al cuadrado.
     *
     * @return nombre del cuadrado
     */
    @Override
    public String nombreFigura()
    {
        return "****** Cuadrado ******";
    }

    /**
     * Redefine el método heredado para mostrar las características
     * particulares del cuadrado.
     */
    @Override
    public void caracteristicas()
    {
        System.out.println(this.nombreFigura());

        System.out.println("Origen: " + this.getOrigen().coordenadas() + " - Lado: " + this.getLado());

        System.out.printf("Superficie: %.2f - Perimetro: %.2f%n", this.superficie(), this.perimetro());
    }
}