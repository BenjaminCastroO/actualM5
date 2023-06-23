package dto;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Usuario implements IAsesoria{
private String nombre;
private String fechaNacimiento;
private int run;
    
public Usuario(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario(String nombre, String fechaNacimiento, int run) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setRun(run);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >=10 && nombre.length()<=50){
            this.nombre = nombre;
        }else {
            throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres");
        }
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);  // no permite fechas inválidas
        try {
            String prueba =
                    String.valueOf(dateFormat.parse(fechaNacimiento).toLocaleString());
            this.fechaNacimiento = fechaNacimiento;
        } catch (ParseException e) {
            throw new IllegalArgumentException("La fecha de nacimiento debe estar en el formato DD/MM/AAAA.");
        }
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        if (run < 99999999){
            this.run = run;
        }else{
            throw new IllegalArgumentException("El RUN debe ser menor a 99.999.999");
        }
    }

    // Método que muestra la edad del usuario
    // Cálculo de la edad a partir de la fecha de nacimiento
    // (método específico de la clase Usuario)
    public void mostrarEdad() {
        DateTimeFormatter tiempo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate cumpleanios = LocalDate.parse(this.fechaNacimiento,tiempo);
        LocalDate ahora = LocalDate.now();
        Period edad = Period.between(cumpleanios,ahora);
        System.out.println("El usuario tiene " + edad.getYears() + " años");
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", run=" + run +
                '}';
    }

    @Override
    // Despliega el nombre y el RUN del usuario
    public void analizarUsuario() {
        System.out.println("nombre='" + nombre + '\'' + ", run=" + run);
    }
}
