/**
 * Representa una heladera comercializada por el comercio.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0
 */
public class Heladera extends ArtefactoHogar
{
    private int pies;
    private int puertas;
    private boolean compresor;

    /**
     * Construye una heladera con todos sus datos.
     *
     * @param p_marca marca de la heladera
     * @param p_precio precio de la heladera
     * @param p_stock stock disponible
     * @param p_pies capacidad expresada en pies
     * @param p_puertas cantidad de puertas
     * @param p_compresor indica si posee compresor
     */
    public Heladera(String p_marca, float p_precio, int p_stock, int p_pies, int p_puertas, boolean p_compresor)
    {
        super(p_marca, p_precio, p_stock);
        this.setPies(p_pies);
        this.setPuertas(p_puertas);
        this.setCompresor(p_compresor);
    }

   
    public int getPies(){ return this.pies;}
    public int getPuertas(){  return this.puertas;}
    public boolean getCompresor() { return this.compresor;}

    private void setPies(int p_pies) { this.pies = p_pies;}
    private void setPuertas(int p_puertas) { this.puertas = p_puertas;}
    private void setCompresor(boolean p_compresor) { this.compresor = p_compresor;}

    /**
     * Calcula la cuota aplicando el seguro correspondiente.
     *
     * Si posee compresor se agregan $50 a cada cuota.
     *
     * @param p_cuotas cantidad de cuotas
     * @param p_interes porcentaje de interés
     * @return valor de la cuota con el adicional
     */
    @Override
    public float creditoConAdicional( int p_cuotas,float p_interes) {
        float cuota = this.cuotaCredito( p_cuotas,p_interes);

        if (this.getCompresor()) {
            cuota = cuota + 50;
        }

        return cuota;
    }

    /** Muestra los datos generales y particulares de la heladera. */
    @Override
    public void imprimir()
    {
        System.out.println("**** Heladera ****");
        super.imprimir();

        System.out.println("Pies: " + this.getPies());
        System.out.println("Puertas: " + this.getPuertas());

        if (this.getCompresor())
        {
            System.out.println("Compresor: Sí");
        }
        else
        {
            System.out.println("Compresor: No");
        }
    }
}