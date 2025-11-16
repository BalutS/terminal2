package org.unimag.dto;

public class ViajeDto {
    private int idViaje;
    private int idRuta;
    private int idConductor;
    private int idBus;
    private String fechaViaje;
    private String horaViaje;
    private String nombreImagenPublicoViaje;

    public ViajeDto() {
    }

    public ViajeDto(int idViaje, int idRuta, int idConductor, int idBus, String fechaViaje, String horaViaje, String nombreImagenPublicoViaje) {
        this.idViaje = idViaje;
        this.idRuta = idRuta;
        this.idConductor = idConductor;
        this.idBus = idBus;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.nombreImagenPublicoViaje = nombreImagenPublicoViaje;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(String horaViaje) {
        this.horaViaje = horaViaje;
    }

    public String getNombreImagenPublicoViaje() {
        return nombreImagenPublicoViaje;
    }

    public void setNombreImagenPublicoViaje(String nombreImagenPublicoViaje) {
        this.nombreImagenPublicoViaje = nombreImagenPublicoViaje;
    }
}
