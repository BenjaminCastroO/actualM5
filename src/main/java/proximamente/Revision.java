package dto;

public class Revision {
    public final int SIN_PROBLEMAS = 1;
    public final int CON_OBSERVACIONES = 2;
    public final int NO_APRUEBA = 3;

    private int idRevision;
    private VisitaTerreno idVisita;
    private String nombreRevision;
    private String detalleParaRevisar;
    private int estado;

    public Revision() {
    }

    public Revision(int idRevision, VisitaTerreno idVisita, String nombreRevision, String detalleParaRevisar, int estado) {
        setIdRevision(idRevision);
        this.idVisita = idVisita;
        setNombreRevision(nombreRevision);
        setDetalleParaRevisar(detalleParaRevisar);
        setEstado(estado);
    }

    public int getIdRevision() {

        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        if (idRevision < 0)
            throw new IllegalArgumentException("El id interno de la Visita " +
                    "debe ser mayor a cero.");

        this.idRevision = idRevision;
    }

    public VisitaTerreno getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(VisitaTerreno idVisita) {
        this.idVisita = idVisita;
    }

    public String getNombreRevision() {
        return nombreRevision;
    }

    public void setNombreRevision(String nombreRevision) {
        if (!(nombreRevision.length() >= 10 && nombreRevision.length() <= 50))
            throw new IllegalArgumentException("El lugar ingresado debe tener " +
                    "como mínimo 10 caracteres y 50 como máximo. Ingrese de nuevo.");

        this.nombreRevision = nombreRevision;
    }

    public String getDetalleParaRevisar() {
        return detalleParaRevisar;
    }

    public void setDetalleParaRevisar(String detalleParaRevisar) {
        if (!(detalleParaRevisar.length()  <= 100))
            throw new IllegalArgumentException("El Detalle Ingresado debe tener " +
                    "como máximo 100 caracteres. Ingrese de nuevo.");
        this.detalleParaRevisar = detalleParaRevisar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {

        if (comprobarEstado(estado))
            this.estado = estado;
    }

    private boolean comprobarEstado(int estado){
        return (estado == SIN_PROBLEMAS || estado == CON_OBSERVACIONES || estado == NO_APRUEBA);
    }
    public String obtenerEstado() {
        if (estado == SIN_PROBLEMAS) return "SIN PROBLEMAS";
        if (estado == CON_OBSERVACIONES) return "CON OBSERVACIONES";
        if (estado == NO_APRUEBA) return "NO APRUEBA";
        else return "INVÁLIDO";
    }


}
