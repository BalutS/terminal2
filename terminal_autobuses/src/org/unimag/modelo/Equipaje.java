package org.unimag.modelo;

public class Equipaje {
    private int idEquipaje;
    private double pesoEquipaje;
    private int idPasajero;
    private String nombreImagenPublicoEquipaje;
    private String nombreImagenPrivadoEquipaje;

    public Equipaje() {
    }

    public Equipaje(int idEquipaje, double pesoEquipaje, int idPasajero, String nombreImagenPublicoEquipaje, String nombreImagenPrivadoEquipaje) {
        this.idEquipaje = idEquipaje;
        this.pesoEquipaje = pesoEquipaje;
        this.idPasajero = idPasajero;
        this.nombreImagenPublicoEquipaje = nombreImagenPublicoEquipaje;
        this.nombreImagenPrivadoEquipaje = nombreImagenPrivadoEquipaje;
    }

    public int getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(int idEquipaje) {
        this.idEquipaje = idEquipaje;
    }

    public double getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(double pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombreImagenPublicoEquipaje() {
        return nombreImagenPublicoEquipaje;
    }

    public void setNombreImagenPublicoEquipaje(String nombreImagenPublicoEquipaje) {
        this.nombreImagenPublicoEquipaje = nombreImagenPublicoEquipaje;
    }

    public String getNombreImagenPrivadoEquipaje() {
        return nombreImagenPrivadoEquipaje;
    }

    public void setNombreImagenPrivadoEquipaje(String nombreImagenPrivadoEquipaje) {
        this.nombreImagenPrivadoEquipaje = nombreImagenPrivadoEquipaje;
    }
}
