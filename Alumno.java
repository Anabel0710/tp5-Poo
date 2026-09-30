/**
 * Clase Alumno que representa un estudiante con dos notas.
 * Permite calcular promedio, verificar si aprueba y mostrar sus datos.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */
public class Alumno extends Persona{
    private int lu;
    private double nota1;
    private double nota2;

    /** Constructor: inicializa notas en cero */
    public Alumno(int p_dni, String p_nombre, String p_apellido, int p_anioNacimiento, int p_lu) {
    super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
    this.setLu(p_lu);
    this.setNota1(0);
    this.setNota2(0);
}

    /** Getters */
    public int getLu() { return this.lu; }
    public double getNota1() { return this.nota1; }
    public double getNota2() { return this.nota2; }

    /** Setters privados */
    private void setLu(int p_lu) { this.lu = p_lu; } 
    public void setNota1(double p_nota) { this.nota1 = p_nota; }
    public void setNota2(double p_nota) { this.nota2 = p_nota; }

    /** Calcula el promedio de notas */
    public double promedio() { return (this.getNota1() + this.getNota2()) / 2; }

    /** Verifica si aprueba según reglas */
    private boolean aprueba() {
        return this.promedio() > 7.0 && this.getNota1() >= 6.0 && this.getNota2() >= 6.0;
    }

    /** Devuelve leyenda APROBADO o DESAPROBADO */
    private String leyendaAprueba() {
        return this.aprueba() ? "APROBADO" : "DESAPROBADO";
    }

    /** Muestra los datos del alumno */
   @Override
    public void mostrar() {
    super.mostrar();

    System.out.println("LU: " + this.getLu()+ " Notas: " + this.getNota1() + " - " + this.getNota2());

    System.out.println("Promedio: " + this.promedio()+ " - " + (this.aprueba() ? "APROBADO" : "DESAPROBADO"));
   }
}
