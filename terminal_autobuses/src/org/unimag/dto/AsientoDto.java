package org.unimag.dto;

public class AsientoDto {
    private int idAsiento;
    private int idBus;
    private boolean estadoAsiento;
    private String nombreImagenPublicoAsiento;

    public AsientoDto() {
    }

    public AsientoDto(int idAsiento, int idBus, boolean estadoAsiento, String nombreImagenPublicoAsiento) {
        this.idAsiento = idAsiento;
        this.idBus = idBus;
        this.estadoAsiento = estadoAsiento;
        this.nombreImagenPublicoAsiento = nombreImagenPublicoAsiento;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public boolean isEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(boolean estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public String getNombreImagenPublicoAsiento() {
        return nombreImagenPublicoAsiento;
    }

    public void setNombreImagenPublicoAsiento(String nombreImagenPublicoAsiento) {
        this.nombreImagenPublicoAsiento = nombreImagenPublicoAsiento;
    }
}
