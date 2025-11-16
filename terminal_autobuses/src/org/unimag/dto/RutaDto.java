package org.unimag.dto;

public class RutaDto {
    private int idRuta;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double tarifa;
    private String nombreImagenPublicoRuta;

    public RutaDto() {
    }

    public RutaDto(int idRuta, String ciudadOrigen, String ciudadDestino, double tarifa, String nombreImagenPublicoRuta) {
        this.idRuta = idRuta;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.tarifa = tarifa;
        this.nombreImagenPublicoRuta = nombreImagenPublicoRuta;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getNombreImagenPublicoRuta() {
        return nombreImagenPublicoRuta;
    }

    public void setNombreImagenPublicoRuta(String nombreImagenPublicoRuta) {
        this.nombreImagenPublicoRuta = nombreImagenPublicoRuta;
    }
}
