package org.unimag.dto;

public class ConductorDto {
    private int idConductor;
    private String cedulaConductor;
    private String nombreConductor;
    private int edadConductor;
    private boolean generoConductor;
    private String nombreImagenPublicoConductor;

    public ConductorDto() {
    }

    public ConductorDto(int idConductor, String cedulaConductor, String nombreConductor, int edadConductor, boolean generoConductor, String nombreImagenPublicoConductor) {
        this.idConductor = idConductor;
        this.cedulaConductor = cedulaConductor;
        this.nombreConductor = nombreConductor;
        this.edadConductor = edadConductor;
        this.generoConductor = generoConductor;
        this.nombreImagenPublicoConductor = nombreImagenPublicoConductor;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public int getEdadConductor() {
        return edadConductor;
    }

    public void setEdadConductor(int edadConductor) {
        this.edadConductor = edadConductor;
    }

    public boolean isGeneroConductor() {
        return generoConductor;
    }

    public void setGeneroConductor(boolean generoConductor) {
        this.generoConductor = generoConductor;
    }

    public String getNombreImagenPublicoConductor() {
        return nombreImagenPublicoConductor;
    }

    public void setNombreImagenPublicoConductor(String nombreImagenPublicoConductor) {
        this.nombreImagenPublicoConductor = nombreImagenPublicoConductor;
    }
}
