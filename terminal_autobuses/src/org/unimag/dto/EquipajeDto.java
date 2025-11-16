package org.unimag.dto;

public class EquipajeDto {
    private int idEquipaje;
    private double pesoEquipaje;
    private int idPasajero;
    private String nombreImagenPublicoEquipaje;

    public EquipajeDto() {
    }

    public EquipajeDto(int idEquipaje, double pesoEquipaje, int idPasajero, String nombreImagenPublicoEquipaje) {
        this.idEquipaje = idEquipaje;
        this.pesoEquipaje = pesoEquipaje;
        this.idPasajero = idPasajero;
        this.nombreImagenPublicoEquipaje = nombreImagenPublicoEquipaje;
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
}
