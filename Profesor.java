import java.util.ArrayList;

/**
 * Representa un profesor de una facultad.
 *
 * Profesor es una especialización de Persona y posee una colección
 * de entre uno y tres cargos docentes.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 27/09/2026
 */
public class Profesor extends Persona
{
    private String titulo;
    private ArrayList<Cargo> cargos;

    /**
     * Construye un profesor con todos sus cargos declarados.
     *
     * @param p_dni DNI del profesor
     * @param p_nombre nombre del profesor
     * @param p_apellido apellido del profesor
     * @param p_anioNacimiento año de nacimiento
     * @param p_titulo título profesional
     * @param p_cargos colección inicial de cargos
     */
    public Profesor( int p_dni, String p_nombre, String p_apellido,int p_anioNacimiento, 
                     String p_titulo, ArrayList<Cargo> p_cargos)
    {
        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);

        this.setTitulo(p_titulo);
        this.setCargos(p_cargos);
    }

    private void setTitulo(String p_titulo)
    {
        this.titulo = p_titulo;
    }

    private void setCargos(ArrayList<Cargo> p_cargos)
    {
        if (p_cargos.size() >= 1 && p_cargos.size() <= 3)
        {
            this.cargos = new ArrayList<Cargo>(p_cargos);
        }
        else
        {
            throw new IllegalArgumentException(
                "Un profesor debe tener entre uno y tres cargos."
            );
        }
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public ArrayList<Cargo> getCargos()
    {
        return this.cargos;
    }

    /**
     * Agrega un cargo si el profesor todavía no posee tres.
     *
     * @return true si el cargo pudo agregarse
     */
    public boolean agregarCargo(Cargo p_cargo)
    {
        if (this.getCargos().size() < 3)
        {
            this.getCargos().add(p_cargo);
            return true;
        }

        return false;
    }

    /**
     * Quita un cargo siempre que permanezca al menos uno,
     * respetando la cardinalidad 1..3.
     *
     * @return true si el cargo pudo eliminarse
     */
    public boolean quitarCargo(Cargo p_cargo)
    {
        if (this.getCargos().size() > 1)
        {
            return this.getCargos().remove(p_cargo);
        }

        return false;
    }

    /**
     * Calcula el sueldo total sumando el sueldo de todos los cargos.
     *
     * @return sueldo total del profesor
     */
    public double sueldoTotal()
    {
        double total = 0;

        for (Cargo cargo : this.getCargos())
        {
            total += cargo.sueldoDelCargo();
        }

        return total;
    }

    /**
     * Muestra todos los cargos asignados al profesor.
     */
    public void listarCargos()
    {
        System.out.println("-***** Cargos Asignados *****-");
        System.out.println("---------------------------------------");

        for (Cargo cargo : this.getCargos())
        {
            cargo.mostrarCargo();
            System.out.println();
        }
    }

    /**
     * Redefine mostrar() para incluir el título, los cargos
     * y el sueldo total del profesor.
     */
    @Override
    public void mostrar()
    {
        super.mostrar();

        System.out.println("Titulo: " + this.getTitulo());
        System.out.println();

        this.listarCargos();

        System.out.printf("** Sueldo Total: %.2f **%n", this.sueldoTotal());
    }

    /**
     * Devuelve los datos principales del profesor en una línea.
     *
     * @return datos del profesor
     */
    public String mostrarLinea()
    {
        return "DNI: " + this.getDNI() + " - Nombre: " + this.nomYApe() + " - Sueldo Total: " + 
               String.format("%.2f",this.sueldoTotal());
    }
}