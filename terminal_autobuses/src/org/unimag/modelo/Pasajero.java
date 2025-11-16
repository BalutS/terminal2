package org.unimag.modelo;

public class Pasajero {
    private int idPasajero;
    private String cedulaPasajero;
    private String nombrePasajero;
    private int edadPasajero;
    private boolean generoPasajero;
    private String nombreImagenPublicoPasajero;
    private String nombreImagenPrivadoPasajero;

    public Pasajero() {
    }

    public Pasajero(int idPasajero, String cedulaPasajero, String nombrePasajero, int edadPasajero, boolean generoPasajero, String nombreImagenPublicoPasajero, String nombreImagenPrivadoPasajero) {
        this.idPasajero = idPasajero;
        this.cedulaPasajero = cedulaPasajero;
        this.nombrePasajero = nombrePasajero;
        this.edadPasajero = edadPasajero;
        this.generoPasajero = generoPasajero;
        this.nombreImagenPublicoPasajero = nombreImagenPublicoPasajero;
        this.nombreImagenPrivadoPasajero = nombreImagenPrivadoPasajero;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getCedulaPasajero() {
        return cedulaPasajero;
    }

    public void setCedulaPasajero(String cedulaPasajero) {
        this.cedulaPasajero = cedulaPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public int getEdadPasajero() {
        return edadPasajero;
    }

    public void setEdadPasajero(int edadPasajero) {
        this.edadPasajero = edadPasajero;
    }

    public boolean isGeneroPasajero() {
        return generoPasajero;
    }

    public void setGeneroPasajero(boolean generoPasajero) {
        this.generoPasajero = generoPasajero;
    }

    public String getNombreImagenPublicoPasajero() {
        return nombreImagenPublicoPasajero;
    }

    public void setNombreImagenPublicoPasajero(String nombreImagenPublicoPasajero) {
        this.nombreImagenPublicoPasajero = nombreImagenPublicoPasajero;
    }

    public String getNombreImagenPrivadoPasajero() {
        return nombreImagenPrivadoPasajero;
    }

    public void setNombreImagenPrivadoPasajero(String nombreImagenPrivadoPasajero) {
        this.nombreImagenPrivadoPasajero = nombreImagenPrivadoPasajero;
    }
}
