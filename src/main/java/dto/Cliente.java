package dto;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
  public final int FONASA = 1;
  public final int ISAPRE = 2;

  private int rut;
  private String nombres;
  private String apellidos;
  private int telefono;
  private String afp;
  private int sistemaDeSalud;
  private String direccion;
  private String comuna;
  private int edad;
  private List<Accidente> accidentes = new ArrayList<>();
  private List<VisitaTerreno> visitasTerreno = new ArrayList<>();

  public Cliente(String nombre, String fechaNacimiento, String nombres, String apellidos, int telefono, int edad) {
    super(nombre, fechaNacimiento);
    setNombres(nombres);
    setApellidos(apellidos);
    setTelefono(telefono);
    setEdad(edad);
  }

  public Cliente(String nombre, String fechaNacimiento, int run, int rut, String nombres,
                 String apellidos, int telefono, String afp, int sistemaDeSalud,
                 String direccion,
                 String comuna, int edad) {
    super(nombre, fechaNacimiento, run);
    setRut(rut);
    setNombres(nombres);
    setApellidos(apellidos);
    setTelefono(telefono);
    setDireccion(direccion);
    setComuna(comuna);
    setEdad(edad);
    setAfp(afp);
    setSistemaDeSalud(sistemaDeSalud);
  }
  //Un cliente debe tener una o muchas visitas en terreno
  public void agregarVisita(VisitaTerreno visitaTerreno){
    visitasTerreno.add(visitaTerreno);
  }
  //Un cliente puede registrar ninguno o muchos accidentes
  public void agregarAccidente(Accidente accidente){
    accidentes.add(accidente);
  }
  // Método que obtiene el nombre completo del cliente
  // Concatenar nombres y apellidos (método específico de la clase Cliente)
  public String obtenerNombre() {
    return (nombres + " " + apellidos);
  }

  // Método que muestra el tipo de sistema de salud del cliente
  // Despliega el tipo de sistema de salud según el valor registrado
  // (método específico de la clase Cliente)
  public String obtenerSistemaSalud() {
    if (sistemaDeSalud == 1) return "FONASA";
    if (sistemaDeSalud == 2) return "ISAPRE";
    else return "INDEFINIDO";
  }

  public int getRut() {
    return rut;
  }

  public void setRut(int rut) {
    if (rut < 99999999) this.rut = rut;
    else
      throw new IllegalArgumentException("El rut debe ser menor a 99.999.999");
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    if (!(nombres.length() >= 5 && nombres.length() <= 30))
      throw new IllegalArgumentException("Los nombres ingresados deben tener " +
              "como mínimo 5 caracteres y 30 como máximo.");
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    if (!(apellidos.length() >= 5 && apellidos.length() <= 30))
      throw new IllegalArgumentException("Los apellidos ingresados deben " +
              "tener como mínimo 5 caracteres y 30 como máximo.");
    this.apellidos = apellidos;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    if ((telefono == 0))
      throw new IllegalArgumentException("El telefono no puede ser nulo.");
    this.telefono = telefono;
  }

  public String getAfp() {
    return afp;
  }

  public void setAfp(String afp) {
    if (!(afp.length() >= 4 && afp.length() <= 30))
      throw new IllegalArgumentException("La afp ingresada debe tener " +
              "como mínimo 4 caracteres y 30 como máximo.");
    this.afp = afp;
  }

  public int getSistemaDeSalud() {
    return sistemaDeSalud;
  }

  public void setSistemaDeSalud(int sistemaDeSalud) {
    if (!(sistemaDeSalud == FONASA || sistemaDeSalud == ISAPRE))
      throw new IllegalArgumentException("El sistema de salud debe ser FONASA" +
              "(1) o ISAPRE(2)");
    this.sistemaDeSalud = sistemaDeSalud;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    if (!(direccion.length() <= 70))
      throw new IllegalArgumentException("La dirección ingresada debe tener " +
              "como máximo 70 caracteres.");
    this.direccion = direccion;
  }

  public String getComuna() {
    return comuna;
  }

  public void setComuna(String comuna) {
    if (!(comuna.length() <= 70))
      throw new IllegalArgumentException("La comuna ingresada debe tener " +
              "como máximo 50 caracteres.");
    this.comuna = comuna;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    if (!(edad >= 0 && edad < 150))
      throw new IllegalArgumentException("La edad ingresada debe ser mayor o " +
              "igual a cero y menor que 150.");
    this.edad = edad;
  }

  @Override
  // Llama al método de la clase padre (Usuario)
  // Despliega la dirección y la comuna del cliente
  public void analizarUsuario() {
    super.analizarUsuario();
    System.out.println("Dirección = '" + direccion + '\'' + ", comuna = " + comuna);
  }

  @Override
  public String toString() {
    return "model.Cliente " +
            "rut=" + rut +
            ", nombres='" + nombres + '\'' +
            ", apellidos='" + apellidos + '\'' +
            ", telefono=" + telefono +
            ", afp='" + afp + '\'' +
            ", sistemaDeSalud=" + sistemaDeSalud +
            ", direccion='" + direccion + '\'' +
            ", comuna='" + comuna + '\'' +
            ", edad=" + edad +
            ' ';
  }




}