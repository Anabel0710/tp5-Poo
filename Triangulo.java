/**
 * Representa un triángulo ubicado en el plano cartesiano.
 *
 * Triangulo es una especialización de FiguraGeometrica y posee
 * una base y una altura.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 29/09/2026
 */
public class Triangulo extends FiguraGeometrica
{
    private double base;
    private double altura;

    /**
     * Construye un triángulo indicando su origen, base y altura.
     *
     * @param p_origen extremo inferior izquierdo
     * @param p_base base del triángulo
     * @param p_altura altura del triángulo
     */
    public Triangulo(Punto p_origen, double p_base, double p_altura){
        super(p_origen);

        this.setBase(p_base);
        this.setAltura(p_altura);
    }

    private void setBase(double p_base)
    {
        this.base = p_base;
    }

    private void setAltura(double p_altura)
    {
        this.altura = p_altura;
    }

    public double getBase()
    {
        return this.base;
    }

    public double getAltura()
    {
        return this.altura;
    }

    /**
     * Devuelve el nombre del triángulo.
     */
    @Override
    public String nombreFigura()
    {
        return "****** Triangulo ******";
    }

    /**
     * Calcula la superficie del triángulo.
     *
     * Fórmula: base por altura dividido dos.
     */
    @Override
    public double superficie()
    {
        return this.getBase() * this.getAltura() / 2;
    }
}