
/**
 * Write a description of class FiguraGeometrica here.
 * 
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 29/09/2026
 */
public abstract class FiguraGeometrica
{
    private Punto origen;
    
    public FiguraGeometrica(Punto p_origen){
        this.setOrigen(p_origen);
    }
    
    private void setOrigen(Punto p_origen){
        this.origen = origen;
    }
    
    /**Es protected para que pueda usarse desde las subclases*/
    protected Punto getOrigen(){return this.origen; }
    
    /**Devuelve el nombre de cada figura*/
    
    public abstract String nombreFigura();
    
    /**Devuelve la superficie de cada figura*/
    public abstract double superficie();
    
    /**Muestra el nombre y la superficie de cualquier figura */
    public void mostrarSuperficie(){
        System.out.println(" " + this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }
    
}