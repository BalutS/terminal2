package org.unimag.modelo;

public class Bus {
    private int idBus;
    private String modeloBus;
    private int idEmpresa;
    private String nombreImagenPublicoBus;
    private String nombreImagenPrivadoBus;

    public Bus() {
    }

    public Bus(int idBus, String modeloBus, int idEmpresa, String nombreImagenPublicoBus, String nombreImagenPrivadoBus) {
        this.idBus = idBus;
        this.modeloBus = modeloBus;
        this.idEmpresa = idEmpresa;
        this.nombreImagenPublicoBus = nombreImagenPublicoBus;
        this.nombreImagenPrivadoBus = nombreImagenPrivadoBus;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public String getModeloBus() {
        return modeloBus;
    }

    public void setModeloBus(String modeloBus) {
        this.modeloBus = modeloBus;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreImagenPublicoBus() {
        return nombreImagenPublicoBus;
    }

    public void setNombreImagenPublicoBus(String nombreImagenPublicoBus) {
        this.nombreImagenPublicoBus = nombreImagenPublicoBus;
    }

    public String getNombreImagenPrivadoBus() {
        return nombreImagenPrivadoBus;
    }

    public void setNombreImagenPrivadoBus(String nombreImagenPrivadoBus) {
        this.nombreImagenPrivadoBus = nombreImagenPrivadoBus;
    }
}
