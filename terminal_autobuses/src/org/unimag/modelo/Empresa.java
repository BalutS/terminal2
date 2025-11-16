package org.unimag.modelo;

public class Empresa {

    private int idEmpresa;
    private String nombreEmpresa;
    private String nombreImagenPublicoEmpresa;
    private String nombreImagenPrivadoEmpresa;

    public Empresa() {
    }

    public Empresa(int idEmpresa, String nombreEmpresa, String nombreImagenPublicoEmpresa, String nombreImagenPrivadoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreImagenPublicoEmpresa = nombreImagenPublicoEmpresa;
        this.nombreImagenPrivadoEmpresa = nombreImagenPrivadoEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreImagenPublicoEmpresa() {
        return nombreImagenPublicoEmpresa;
    }

    public void setNombreImagenPublicoEmpresa(String nombreImagenPublicoEmpresa) {
        this.nombreImagenPublicoEmpresa = nombreImagenPublicoEmpresa;
    }

    public String getNombreImagenPrivadoEmpresa() {
        return nombreImagenPrivadoEmpresa;
    }

    public void setNombreImagenPrivadoEmpresa(String nombreImagenPrivadoEmpresa) {
        this.nombreImagenPrivadoEmpresa = nombreImagenPrivadoEmpresa;
    }

}
