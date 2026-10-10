
/**
 * Representa de manerea general un artefacto para el hogar
 * 
 * Contiene las caracteristicas y operaciones generales de los artefactos comercializados
 * 
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 3/10/2026
 */
public abstract class ArtefactoHogar {
    private String marca;
    private float precio;
    private int stock;
    
    /**Construye un artefacto indicando su marca, precio y stock
     * 
     * @param p_marca marca del artefacto
     * @param p_precio precio del artefacto
     * @param p_stock stock disponible del artefacto
    */
   public ArtefactoHogar(String p_marca, float p_precio, int p_stock){
       this.setMarca(p_marca);
       this.setPrecio(p_precio);
       this.setStock(p_stock);
    }
    
   private void setMarca(String p_marca){ this.marca = p_marca;}
   private void setPrecio(float p_precio){ this.precio = p_precio;}
   private void setStock(int p_stock){ this.stock = p_stock;}
   
   public String getMarca(){ return this.marca; }
   public float getPrecio(){ return this.precio;}
   public int getStock(){ return this.stock ;}
   
   /**Calcula el valor de una cuota agregando un interes recibido
    * @param p_cuotas cantidad de cuotas
    * @param p_interes porcentaje de interes
    * @return valor de cada cuota 
    *
   */
   
   public float cuotaCredito(int p_cuotas, float p_interes){
       float cuotaSinIntereses = this.getPrecio()/ p_cuotas;
       float interes = this.getPrecio() * p_interes / 100;
       
       return cuotaSinIntereses + interes;
    }
   
   /**
    * Calcula la cuota incluyendo las modificaciones particulares
    * del tipo concreto de artefacto.
    *
    * @param p_cuotas cantidad de cuotas
    * @param p_interes porcentaje de interés
    * @return valor de la cuota con adicionales o descuentos
   */
    public abstract float creditoConAdicional(int p_cuotas,float p_intere );

    /** Muestra los datos comunes del artefacto. */
    public void imprimir()
    {
        System.out.printf( "Marca: %s - Precio: %.2f - Stock: %d%n",
            this.getMarca(),
            this.getPrecio(),
            this.getStock()
        );
    }
}