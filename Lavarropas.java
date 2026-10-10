/**
 * Representa un lavarropas comercializado por el comercio.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Lavarropas extends ArtefactoHogar
{
    private int programas;
    private float kilos;
    private boolean automatico;

    /**
     * Construye un lavarropas con todos sus datos.
     *
     * @param p_marca marca del lavarropas
     * @param p_precio precio del lavarropas
     * @param p_stock stock disponible
     * @param p_programas cantidad de programas
     * @param p_kilos capacidad en kilogramos
     * @param p_automatico indica si es automático
     */
    public Lavarropas( String p_marca, float p_precio, int p_stock, int p_programas, float p_kilos, boolean p_automatico) {
        super(p_marca, p_precio, p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
    }

    public int getProgramas(){return this.programas;}
    public float getKilos(){return this.kilos;}
    public boolean getAutomatico() {return this.automatico;}

    private void setProgramas(int p_programas){ this.programas = p_programas;}
    private void setKilos(float p_kilos) { this.kilos = p_kilos; }
    private void setAutomatico(boolean p_automatico) {this.automatico = p_automatico; }

    /**
     * Calcula la cuota con el descuento correspondiente.
     *
     * Si el lavarropas no es automático se aplica un descuento
     * del 2% sobre el valor de cada cuota.
     *
     * @param p_cuotas cantidad de cuotas
     * @param p_interes porcentaje de interés
     * @return cuota con el descuento aplicado
     */
    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        float cuota = this.cuotaCredito(p_cuotas, p_interes);

        if (!this.getAutomatico())
        {
            cuota = cuota - cuota * 0.02f;
        }

        return cuota;
    }

    /** Muestra los datos generales y particulares del lavarropas. */
    @Override
    public void imprimir()
    {
        System.out.println("**** Lavarropas ****");
        super.imprimir();

        System.out.println("Programas: " + this.getProgramas());

        System.out.println("Capacidad: " + this.getKilos() + " kg" );

        if (this.getAutomatico())
        {
            System.out.println("Automático: Sí");
        }
        else
        {
            System.out.println("Automático: No");
        }
    }
}