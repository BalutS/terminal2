package org.unimag.dto;

public class TiqueteDto {
    private int idTiquete;
    private int idPasajero;
    private int idViaje;
    private int idAsiento;
    private String nombreImagenPublicoTiquete;

    public TiqueteDto() {
    }

    public TiqueteDto(int idTiquete, int idPasajero, int idViaje, int idAsiento, String nombreImagenPublicoTiquete) {
        this.idTiquete = idTiquete;
        this.idPasajero = idPasajero;
        this.idViaje = idViaje;
        this.idAsiento = idAsiento;
        this.nombreImagenPublicoTiquete = nombreImagenPublicoTiquete;
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
}
