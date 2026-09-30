import java.util.ArrayList;

/**
 * Representa un jardín que desea pintar diferentes figuras
 * geométricas en el piso.
 *
 * Permite calcular la superficie total, los litros de pintura
 * y la cantidad de latas necesarias.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 29/09/2026
 */
public class Jardin
{
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;

    /**
     * Construye un jardín inicialmente sin figuras.
     *
     * @param p_nombre nombre del jardín
     */
    public Jardin(String p_nombre)
    {
        this.setNombre(p_nombre);

        this.setFiguras(
            new ArrayList<FiguraGeometrica>()
        );
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    private void setFiguras(
        ArrayList<FiguraGeometrica> p_figuras
    )
    {
        this.figuras = p_figuras;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public ArrayList<FiguraGeometrica> getFiguras()
    {
        return this.figuras;
    }

    /**
     * Agrega una figura al presupuesto del jardín.
     */
    public void agregarFigura(FiguraGeometrica p_figura)
    {
        this.getFiguras().add(p_figura);
    }

    /**
     * Quita una figura de la colección.
     *
     * @return true si la figura fue encontrada y eliminada
     */
    public boolean quitarFigura(FiguraGeometrica p_figura)
    {
        return this.getFiguras().remove(p_figura);
    }

    /**
     * Calcula la cantidad total de metros cuadrados a pintar.
     *
     * @return superficie total de todas las figuras
     */
    public double cuantosMetros()
    {
        double total = 0;

        for (FiguraGeometrica figura : this.getFiguras())
        {
            total += figura.superficie();
        }

        return total;
    }

    /**
     * Calcula los litros de pintura necesarios.
     *
     * Una lata de cuatro litros cubre veinte metros cuadrados.
     */
    private double cuantosLitros()
    {
        return this.cuantosMetros() * 4 / 20;
    }

    /**
     * Calcula la cantidad de latas que deben comprarse.
     *
     * Se utiliza Math.ceil porque no pueden comprarse fracciones
     * de lata y siempre debe alcanzarse a cubrir toda la superficie.
     *
     * @return cantidad entera de latas
     */
    public int cuantasLatas()
    {
        return (int) Math.ceil(
            this.cuantosLitros() / 4
        );
    }

    /**
     * Muestra el presupuesto completo del jardín.
     */
    public void detalleFiguras()
    {
        System.out.println("Presupuesto: " + this.getNombre());

        System.out.println();

        for (FiguraGeometrica figura : this.getFiguras())
        {
            figura.mostrarSuperficie();
        }

        System.out.println("----------------------------------");

        System.out.printf("Total a cubrir: %.2f%n", this.cuantosMetros());

        System.out.println(
            "Comprar " + this.cuantasLatas() + " latas"
        );
    }
}