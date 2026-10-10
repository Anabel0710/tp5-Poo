/**
 * Representa una cocina comercializada por el comercio.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 03/10/2026
 */
public class Cocina extends ArtefactoHogar
{
    private int hornallas;
    private int calorias;
    private String dimensiones;

    /**
     * Construye una cocina con todos sus datos.
     *
     * @param p_marca marca de la cocina
     * @param p_precio precio de la cocina
     * @param p_stock stock disponible
     * @param p_hornallas cantidad de hornallas
     * @param p_calorias cantidad de calorías
     * @param p_dimensiones dimensiones de la cocina
     */
    public Cocina(String p_marca, float p_precio, int p_stock, int p_hornallas, int p_calorias, String p_dimensiones) {
        super(p_marca, p_precio, p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }

    /** Devuelve la cantidad de hornallas. */
    public int getHornallas()
    {
        return this.hornallas;
    }

    /** Devuelve las calorías. */
    public int getCalorias()
    {
        return this.calorias;
    }

    /** Devuelve las dimensiones. */
    public String getDimensiones()
    {
        return this.dimensiones;
    }

    /** Asigna la cantidad de hornallas. */
    private void setHornallas(int p_hornallas)
    {
        this.hornallas = p_hornallas;
    }

    /** Asigna las calorías. */
    private void setCalorias(int p_calorias)
    {
        this.calorias = p_calorias;
    }

    /** Asigna las dimensiones. */
    private void setDimensiones(String p_dimensiones)
    {
        this.dimensiones = p_dimensiones;
    }

    /**
     * Devuelve la cuota sin aplicar modificaciones adicionales.
     *
     * @param p_cuotas cantidad de cuotas
     * @param p_interes porcentaje de interés
     * @return valor normal de la cuota
     */
    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes){
        return this.cuotaCredito(p_cuotas, p_interes);
    }

    /** Muestra los datos generales y particulares de la cocina. */
    @Override
    public void imprimir()
    {
        System.out.println("**** Cocina ****");
        super.imprimir();

        System.out.println("Hornallas: " + this.getHornallas());

        System.out.println("Calorías: " + this.getCalorias());

        System.out.println("Dimensiones: " + this.getDimensiones());
    }
}