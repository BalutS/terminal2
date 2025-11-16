package org.unimag.dto;

public class BusDto {
    private int idBus;
    private String modeloBus;
    private int idEmpresa;
    private String nombreImagenPublicoBus;

    public BusDto() {
    }

    public BusDto(int idBus, String modeloBus, int idEmpresa, String nombreImagenPublicoBus) {
        this.idBus = idBus;
        this.modeloBus = modeloBus;
        this.idEmpresa = idEmpresa;
        this.nombreImagenPublicoBus = nombreImagenPublicoBus;
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
}
