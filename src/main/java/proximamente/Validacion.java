package dto;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Validacion {

  // Metodo para validar entradas de objeto Administrativo
  public static Administrativo validarAdministrativo(){
    String nombre;
    String fechaNacimiento = "";
    int rut;
    boolean valido = true;
    do {
      nombre = leerTexto("Ingresa el nombre del administrativo:");
      if (!(nombre.length() >= 10 && nombre.length() <= 50))
        System.out.println("El nombre debe tener entre 10 y 50 caracteres");
    } while (!(nombre.length() >= 10 && nombre.length() <= 50));

    do {
      valido = true;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);  // no permite fechas inválidas
      try {
        fechaNacimiento = leerTexto("Ingrese la fecha de nacimiento del " +
                "administrativo:");
        fechaNacimiento =
                String.valueOf(dateFormat.parse(fechaNacimiento).toLocaleString());
      } catch (Exception e) {
        System.out.println("La fecha de nacimiento debe estar en el formato " +
                "DD/MM/AAAA.");
        valido = false;
      }
    } while (!valido);

    Usuario user = new Usuario(nombre,fechaNacimiento);
    do {
      rut = leerNum("Ingresa el rut del administrativo:");
      if (!(rut < 99999999))
        System.out.println("El RUN debe ser menor a 99.999.999");
    } while (!(rut < 99999999));
    if (rut != 0) user.setRun(rut);

    String area;
    String experiencia;

    do{
      area = leerTexto("Ingresa el área del administrativo:");
      if (!(area.length() >= 5 && area.length() <= 20))
        System.out.println("El área ingresada debe tener como mínimo 5 " +
                "caracteres y 20 como máximo.");
    } while (!(area.length() >= 5 && area.length() <= 20));

    Administrativo admin = new Administrativo(user.getNombre(),
            user.getFechaNacimiento(),area);
    if (user.getRun() != 0)
      admin.setRun(user.getRun());

    do{
      experiencia = leerTexto("Opcional!  Ingresa la experiencia del " +
              "administrativo:");
      if (!(experiencia.length() <= 100))
        System.out.println("La información ingresada en experiencia debe " +
                "tener como máximo 100 caracteres. Ingrese de nuevo.");
    } while (!( experiencia.length() <= 100));
    if (experiencia != null)
      admin.setExperiencia(experiencia);
    return admin;
  }

  // Metodo para validar entradas de objeto Profesional
  public static Profesional validarProfesional(){
    String nombre;
    String fechaNacimiento = "";
    int rut;
    boolean valido = true;
    do {
      nombre = leerTexto("Ingresa el nombre del profesional:");
      if (!(nombre.length() >= 10 && nombre.length() <= 50))
        System.out.println("El nombre debe tener entre 10 y 50 caracteres");
    } while (!(nombre.length() >= 10 && nombre.length() <= 50));

    do {
      valido = true;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);  // no permite fechas inválidas
      try {
        fechaNacimiento = leerTexto("Ingrese la fecha de nacimiento del " +
                "profesional:");
        fechaNacimiento =
                String.valueOf(dateFormat.parse(fechaNacimiento).toLocaleString());
      } catch (Exception e) {
        System.out.println("La fecha de nacimiento debe estar en el formato " +
                "DD/MM/AAAA.");
        valido = false;
      }
    } while (!valido);

    Usuario user = new Usuario(nombre,fechaNacimiento);
    do {
      rut = leerNum("Ingresa el rut del profesional:");
      if (!(rut < 99999999))
        System.out.println("El RUN debe ser menor a 99.999.999");
    } while (!(rut < 99999999));
    if (rut != 0) user.setRun(rut);

    String titulo;
    String fechaIngreso;
    do{
      titulo = leerTexto("Ingresa el título del profesional:");
      if (!(titulo.length() >=10 && titulo.length()<=50))
        System.out.println("El título debe tener entre 10 y 50 caracteres");
    } while (!(titulo.length() >=10 && titulo.length()<=50));
    Profesional pro = new Profesional(user.getNombre(),
            user.getFechaNacimiento(),titulo);
    if (user.getRun() != 0)
      pro.setRun(user.getRun());

    do {
      valido = true;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);  // no permite fechas inválidas
      fechaIngreso = leerTexto("Ingrese la fecha de ingreso del " +
              "profesional:");
      if (!(fechaIngreso.isEmpty())) {
        try {

                  String.valueOf(dateFormat.parse(fechaIngreso).toLocaleString());
        } catch (Exception e) {
          System.out.println("La fecha de ingreso debe estar en el formato " +
                  "DD/MM/AAAA.");
          valido = false;
        }
      }
    } while (!valido);
    if (!(fechaIngreso.isEmpty())){
      pro.setFechaIngreso(fechaIngreso);
    }
    return pro;
  }

  // Metodo para validar entradas de objeto Cliente
  public static Cliente  validarCliente(){
    String nombres;
    String fechaNacimiento = "";
    int rut;
    boolean valido = true;

    do {
      nombres = leerTexto("Ingresa los nombres del usuario:");
      if (!(nombres.length() >= 5 && nombres.length() <= 30))
        System.out.println("Los nombres ingresados deben tener " +
                "como mínimo 5 caracteres y 30 como máximo.");
    } while (!(nombres.length() >= 5 && nombres.length() <= 30));

    do {
      valido = true;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);  // no permite fechas inválidas
      try {
        fechaNacimiento = leerTexto("Ingrese la fecha de nacimiento del " +
                "usuario:");
        fechaNacimiento =
                String.valueOf(dateFormat.parse(fechaNacimiento).toLocaleString());
      } catch (Exception e) {
        System.out.println("La fecha de nacimiento debe estar en el formato " +
                "DD/MM/AAAA.");
        valido = false;
      }
    } while (!valido);

    Usuario user = new Usuario(nombres,fechaNacimiento);

    do {
      rut = leerNum("Opcional! Ingresa el rut del usuario:");
      if (!(rut < 99999999)) {
        System.out.println("El RUN debe ser menor a 99.999.999");
      }
    } while (!(rut < 99999999));
    if (!(rut == 0))
      user.setRun(rut);

    String apellidos;
    int telefono;
    String afp;
    int sistemaDeSalud;
    String comuna;
    String direccion;
    int edad;
    String num;

    do {
      apellidos = leerTexto("Ingresa los apellidos del usuario:");
      if (!(apellidos.length() >= 5 && apellidos.length() <= 30))
        System.out.println("Los apellidos ingresados deben tener " +
                "como mínimo 5 caracteres y 30 como máximo.");
    } while (!(apellidos.length() >= 5 && apellidos.length() <= 30));

    do {
      telefono = leerNum("Ingresa el teléfono del cliente:");
      if (telefono == 0) {
        System.out.println("El teléfono no puede ser cero.");
      }
    } while (telefono == 0) ;

    do {
      edad = leerNum("Ingresa la edad del usuario:");
      if  (!(edad >= 0 && edad < 150))
        System.out.println("La edad ingresada debe ser mayor o " +
                "igual a cero y menor que 150.");
    } while (!(edad >= 0 && edad < 150));

    Cliente clie = new Cliente(user.getNombre(),user.getFechaNacimiento(),
            nombres,apellidos,telefono,edad);
    if (user.getRun() != 0)
      clie.setRun(user.getRun());

    if (deseaIngresar("afp")) {
      do {
        afp = leerTexto("Ingresa el afp del cliente:");
        if (!(afp.length() >= 4 && afp.length() <= 30)) {
          System.out.println("La afp ingresada debe tener " +
                  "como mínimo 4 caracteres y 30 como máximo.");
        }
      } while (!(afp.length() >= 4 && afp.length() <= 30));
      clie.setAfp(afp);
    }

    if (deseaIngresar("sistema de salud")) {
      do {
        num = leerTexto("Ingresa el sistema de salud del cliente (1.FONASA - 2.ISAPRE:");
        if (!(num.equals("1") || num.equals("2"))) {
          System.out.println("El sistema de salud debe ser FONASA" +
                  "(1) o ISAPRE(2)");
          valido = false;
        }
      } while (!(num.equals("1") || num.equals("2")));
      sistemaDeSalud = Integer.parseInt(num);
      clie.setSistemaDeSalud(sistemaDeSalud);
    }

    if(deseaIngresar("direccion")) {
      do {
        direccion = leerTexto("Ingresa la direccion del cliente:");
        if (!(direccion.length() <= 70)) {
          System.out.println("La direccion ingresada debe tener " +
                  "como máximo 70 caracteres.");
        }
      } while (!(direccion.length() <= 70));
      clie.setDireccion("direccion");
    }

    if (deseaIngresar("comuna")) {
      do {
        comuna = leerTexto("Ingresa la comuna del cliente:");
        if (!(comuna.length() <= 50)) {
          System.out.println("La comuna ingresada debe tener " +
                  "como máximo 50 caracteres.");
        }
      } while (!(comuna.length() <= 50));
      clie.setComuna(comuna);
    }
    return clie;
  }

  public static Usuario validarUsuario() {
    String nombre;
    String fechaNacimiento = "";
    int rut;
    boolean valido = true;
    do {
      nombre = leerTexto("Ingresa el nombre del usuario:");
      if (!(nombre.length() >= 10 && nombre.length() <= 50))
        System.out.println("El nombre debe tener entre 10 y 50 caracteres");
    } while (!(nombre.length() >= 10 && nombre.length() <= 50));

    do {
      valido = true;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);  // no permite fechas inválidas
      try {
        fechaNacimiento = leerTexto("Ingrese la fecha de nacimiento del " +
                "usuario:");
        fechaNacimiento =
                String.valueOf(dateFormat.parse(fechaNacimiento).toLocaleString());
      } catch (Exception e) {
        System.out.println("La fecha de nacimiento debe estar en el formato " +
                "DD/MM/AAAA.");
        valido = false;
      }
    } while (!valido);

    Usuario user = new Usuario(nombre,fechaNacimiento);
    do {
      rut = leerNum("Ingresa el rut del cliente:");
      if (!(rut < 99999999))
        System.out.println("El RUN debe ser menor a 99.999.999");
    } while (!(rut < 99999999));
    if (rut != 0) user.setRun(rut);
    return user;
  }

  // Metodo para validar entradas de objeto Capacitacion
//Un cliente puede tomar ninguna o muchas capacitaciones
  public static Capacitacion validarCapacitacion(List<IAsesoria> lista) {
    int id;
    int rut;
    String dia;
    String hora;
    String lugar;
    int duracion;
    int cantAsistentes;
    boolean valido = true;

    do {
      id = leerNum("Ingresa el id de la capacitación:");
      if (id == 0)
        System.out.println("El id interno de  la capacitación " +
                "debe ser mayor a cero.");
    } while (id == 0);

    do {
      valido = false;
      rut = leerNum("Ingresa el rut del cliente:");
      for (IAsesoria asesoria : lista) {
        if (asesoria instanceof Cliente) {
          Cliente cliente = (Cliente) asesoria;
          if (cliente.getRun() == rut) {
            valido = true;
          }
        }
      }
      if (valido == false)
        System.out.println("no existe un cliente con el rut proporcionado");
    } while (!valido);

    do {
      lugar = leerTexto("Ingresa el lugar de la capacitación:");
      if (!(lugar.length() >= 10 && lugar.length() <= 50)) {
        System.out.println("El lugar ingresado debe tener " +
                "como mínimo 10 caracteres y 50 como máximo. Ingrese de nuevo.");
      }
    } while  (!(lugar.length() >= 10 && lugar.length() <= 50));

    do {
      cantAsistentes = leerNum("Ingresa la cantidad de asistentes de la " +
              "capacitación:");
      if (cantAsistentes < 1000 && cantAsistentes > -1) {
        System.out.println("la cantidad de asistentes debe " +
                "ser un número positivo menor que 1000");
      }
    } while (cantAsistentes < 1000 && cantAsistentes > -1);

    Capacitacion cap = new Capacitacion(id,rut,lugar,cantAsistentes);

    if(deseaIngresar("día de la semana")) {
      do {
        valido = true;
        dia = leerTexto("Ingresa el día de la semana:");
        if (!(dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") ||
                dia.equalsIgnoreCase("miercoles") || dia.equalsIgnoreCase("jueves") ||
                dia.equalsIgnoreCase("viernes") || dia.equalsIgnoreCase("sabado") ||
                dia.equalsIgnoreCase("domingo"))) {
          System.out.println("Ingrese un día de la semana válido,"
                  + " (lunes, martes, miercoles, jueves, viernes, sabado, domingo).");
          valido = false;
        } else dia = dia.toLowerCase();
      } while (!valido);
      cap.setDia(dia);
    }

    if(deseaIngresar("hora")) {
      do {
        valido = true;
        hora = leerTexto("Ingrese la hora de la capacitación en formato HH:mm");
        DateTimeFormatter tiempo = DateTimeFormatter.ofPattern("HH:mm");
        try {
          LocalTime horalocal = LocalTime.parse(hora, tiempo);
          hora = String.valueOf(horalocal);
        } catch (DateTimeParseException e) {
          System.out.println("La Hora debe estar ingresada en el " +
                  "formato HH:mm ");
          valido = false;
        }
      } while (!valido);
      cap.setHora(hora);
    }

    if (deseaIngresar("duración")) {
      do {
        duracion = leerNum("Ingresa la duración en minutos de la " +
                "capacitación:");
        if (!(duracion <= 70)) {
          System.out.println("La información ingresada en " +
                  "duración debe tener menos de 71 caracteres.");
        }
      } while (!(duracion <= 70));
    cap.setDuracion(duracion);
    }

    return cap;
  }


  private static String leerTexto(String mensaje){
    System.out.println(mensaje);
    Scanner scan = new Scanner(System.in);
    return scan.nextLine();
  }

  private static int leerNum(String mensaje){
    boolean valido = true;
    int num = 0;
    Scanner scan = new Scanner(System.in);
    String texto;
    do {
      valido = true;
      texto = leerTexto(mensaje);
      if (!(texto.isEmpty())) {
        try {
          num = Integer.parseInt(texto);
        } catch (Exception e) {
          valido = false;
          System.out.println("Este campo no admite caracteres no numéricos.");
        }
      }
    } while (!valido);
    return num;
  }

  private static boolean deseaIngresar(String mensaje)
  {
    System.out.println("¿Desea ingresar '" + mensaje + "' ?");
    System.out.println("Ingrese 's' si desea agregar esta información.");
    if (leerTexto("").toLowerCase().equals("s"))
      return true;
    else return false;
  }

}