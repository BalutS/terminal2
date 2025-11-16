package org.unimag.modelo;

public class Tiquete {
    private int idTiquete;
    private int idPasajero;
    private int idViaje;
    private int idAsiento;
    private String nombreImagenPublicoTiquete;
    private String nombreImagenPrivadoTiquete;

    public Tiquete() {
    }

    public Tiquete(int idTiquete, int idPasajero, int idViaje, int idAsiento, String nombreImagenPublicoTiquete, String nombreImagenPrivadoTiquete) {
        this.idTiquete = idTiquete;
        this.idPasajero = idPasajero;
        this.idViaje = idViaje;
        this.idAsiento = idAsiento;
        this.nombreImagenPublicoTiquete = nombreImagenPublicoTiquete;
        this.nombreImagenPrivadoTiquete = nombreImagenPrivadoTiquete;
    }

    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getNombreImagenPublicoTiquete() {
        return nombreImagenPublicoTiquete;
    }

    public void setNombreImagenPublicoTiquete(String nombreImagenPublicoTiquete) {
        this.nombreImagenPublicoTiquete = nombreImagenPublicoTiquete;
    }

    public String getNombreImagenPrivadoTiquete() {
        return nombreImagenPrivadoTiquete;
    }

    public void setNombreImagenPrivadoTiquete(String nombreImagenPrivadoTiquete) {
        this.nombreImagenPrivadoTiquete = nombreImagenPrivadoTiquete;
    }
}
