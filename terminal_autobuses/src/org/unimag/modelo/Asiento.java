package org.unimag.modelo;

public class Asiento {
    private int idAsiento;
    private int idBus;
    private boolean estadoAsiento;
    private String nombreImagenPublicoAsiento;
    private String nombreImagenPrivadoAsiento;

    public Asiento() {
    }

    public Asiento(int idAsiento, int idBus, boolean estadoAsiento, String nombreImagenPublicoAsiento, String nombreImagenPrivadoAsiento) {
        this.idAsiento = idAsiento;
        this.idBus = idBus;
        this.estadoAsiento = estadoAsiento;
        this.nombreImagenPublicoAsiento = nombreImagenPublicoAsiento;
        this.nombreImagenPrivadoAsiento = nombreImagenPrivadoAsiento;
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

    public String getNombreImagenPrivadoAsiento() {
        return nombreImagenPrivadoAsiento;
    }

    public void setNombreImagenPrivadoAsiento(String nombreImagenPrivadoAsiento) {
        this.nombreImagenPrivadoAsiento = nombreImagenPrivadoAsiento;
    }
}
