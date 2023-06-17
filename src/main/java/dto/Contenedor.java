package dto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Contenedor {

  private List<IAsesoria> listAsesoria = new ArrayList<>();// Lista de instancias de la interfaz Asesoria

  private List<Capacitacion> listCapacitaciones = new ArrayList<>(); // Lista de objetos de la clase Capacitacion


  // Métodos para agregar asesorías
  public void agregarCliente(){
    listAsesoria.add(Validacion.validarCliente());
  }

  public void agregarProfesional(){
     listAsesoria.add(Validacion.validarProfesional());
  }
  public void agregarAdministrativo(){
    listAsesoria.add(Validacion.validarAdministrativo());
  }
  // Métodos para agregar capacitaciones
  public void agregarCapacitacion(){
    listCapacitaciones.add(Validacion.validarCapacitacion(listAsesoria));
  }

  // Métodos para Listar todos los Usuarios
  public void listarUsuarios() {
    System.out.println("Lista de usuarios:");
    for (IAsesoria asesoria : listAsesoria) {
        asesoria.analizarUsuario();
      }
    }

  // Métodos para Listar los Usuarios por Tipo
  public void listarUsuariosPorTipo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el tipo de usuario (cliente, profesional, administrativo):");
    String tipoUsuario = scanner.nextLine();

    for (IAsesoria asesoria : listAsesoria) {
        if (tipoUsuario.equalsIgnoreCase("cliente") && asesoria instanceof Cliente) {
          asesoria.analizarUsuario();
        } else if (tipoUsuario.equalsIgnoreCase("profesional") && asesoria instanceof Profesional) {
          asesoria.analizarUsuario();
        } else if (tipoUsuario.equalsIgnoreCase("administrativo") && asesoria instanceof Administrativo) {
          asesoria.analizarUsuario();
        }
    }
  }

  // Métodos para Listar todas las Capacitaciones
  public void listarCapacitaciones() {
    System.out.println("Lista de Capacitaciones:");

    for (Capacitacion capacitacion : listCapacitaciones) {
      System.out.println("ID Capacitación: " + capacitacion.getId());
      System.out.println("RUT Cliente: " + capacitacion.getRut());
      System.out.println("Fecha Capacitación: " + capacitacion.getDia());
      System.out.println("Hora Capacitación: " + capacitacion.getHora());
      System.out.println("Lugar Capacitación: " + capacitacion.getLugar());
      System.out.println("Duración: " + capacitacion.getDuracion());
      System.out.println("Cantidad Asistentes: " + capacitacion.getCantAsistentes());

      Cliente cliente = buscarClientePorRut(capacitacion.getRut());
      if (cliente != null) {
        System.out.println("Datos del Cliente:");
        System.out.println("RUT: " + cliente.getRun());
        System.out.println("Nombres: " + cliente.getNombres());
        System.out.println("Apellidos: " + cliente.getApellidos());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("AFP: " + cliente.getAfp());
        System.out.println("Sistema de Salud: " + cliente.getSistemaDeSalud());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Comuna: " + cliente.getComuna());
        System.out.println("Edad: " + cliente.getEdad());
      }
    }
  }

  private Cliente buscarClientePorRut(int rut) {
    for (IAsesoria asesoria : listAsesoria) {
      if (asesoria instanceof Cliente) {
        Cliente cliente = (Cliente) asesoria;
        if (cliente.getRun() == rut) {
          return cliente;
        }
      }
    }
    return null;
  }

  public void eliminarUsuario() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el RUN del usuario que desea eliminar:");
    int run = scanner.nextInt();

    IAsesoria usuarioEliminado = null;

    for (IAsesoria asesoria : listAsesoria) {
      if ((asesoria instanceof Cliente) && (((Cliente) asesoria).getRun() == run)) {
        usuarioEliminado = asesoria;
        break;
      } else if ((asesoria instanceof Profesional) && (((Profesional) asesoria).getRun() == run)) {
        usuarioEliminado = asesoria;
        break;
      } else if ((asesoria instanceof Administrativo) && (((Administrativo) asesoria).getRun() == run)) {
        usuarioEliminado = asesoria;
        break;
      }
    }

    if (usuarioEliminado != null) {
      listAsesoria.remove(usuarioEliminado);
      System.out.println("Usuario eliminado exitosamente.");
    } else {
      System.out.println("No se encontró un usuario con el RUN especificado.");
    }
  }

  public void iniciarConDatos(){
    Usuario user1 = new Usuario("Benjamín Castro","07/07/1997",11223344);
    Usuario user2 = new Usuario("Pedro Díaz","10/10/1990",123123);
    Usuario user3 = new Usuario("Gonzalo Mercado","31/03/1985",654321);
    Cliente clie1 = new Cliente("eduardo andres", "11/02/1996",12345,12345,"Eduardo Andrés", "Cavieres Alcayaga", 56971783,"afp modelo", 1,"el alazan " + "77","Quilpué",25);
    Cliente clie2 = new Cliente("Margot javiera", "12/06/2034",54321,54321,"Margot Javiera", "Alcaino Betancourt", 56911111,"afp plan vital",2, "una dirección que no existe","Santiago", 33);
    Cliente clie3 = new Cliente("Arón francisco", "11/06/1992",98990,98990,"Aron Francisco", "Ormeño " + "Vidal", 56922222,"afp chanta",1,"el mercado 8766","Ancud",77);
    Administrativo admin1 = new Administrativo("juan pedro segundo", "07/12/1980",8888,"Tecnología y comunicaciones", "15 años como secretario del equipo de telecomunicaciones");
    Administrativo admin2 = new Administrativo("Alin victoria", "25/12/1998",7777,
            "Departamento de ventas","Trainee");
    Administrativo admin3 = new Administrativo("Elmo joselo","12/12/2012",9999,
            "Capacitacion y formación continua", "Lidera el equipo de diseño de capacitaciones");
    Profesional prof1 = new Profesional("Pablo toledo","15/03/2001",445552,
            "Capacitador", "17/12/2016");
    Profesional prof2 = new Profesional("Valentin Dante","23/06/1999",77331,
            "Asistente Administrativo", "12/02/2010");
    Profesional prof3 = new Profesional("Pablo toledo","07/11/2011",99226,
            "Prevencionista de riesgo", "28/01/2013");

    Capacitacion cap1 = new Capacitacion(1,12,"lunes","12:39","Salon de Eventos",12,
            30);
    Capacitacion cap2 = new Capacitacion(2,12,"martes","12:50","casa de juan",12,
            20);
    Capacitacion cap3 = new Capacitacion(3,12,"lunes","16:39","casa jejejej",12,
            15);
    listAsesoria.add(user1);
    listAsesoria.add(user2);
    listAsesoria.add(user3);
    listAsesoria.add(clie1);
    listAsesoria.add(clie2);
    listAsesoria.add(clie3);
    listAsesoria.add(admin1);
    listAsesoria.add(admin2);
    listAsesoria.add(admin3);
    listAsesoria.add(prof1);
    listAsesoria.add(prof2);
    listAsesoria.add(prof3);
    listCapacitaciones.add(cap1);
    listCapacitaciones.add(cap2);
    listCapacitaciones.add(cap3);
  }
}