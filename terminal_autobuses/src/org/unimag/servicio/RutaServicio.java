package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.RutaDto;
import org.unimag.modelo.Ruta;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class RutaServicio implements ApiOperacionBD<RutaDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public RutaServicio() {

        nombrePersistencia = Persistencia.NOMBRE_RUTA;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(RutaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(RutaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public RutaDto inserInto(RutaDto dto, String ruta) {
        Ruta objRuta = new Ruta();

        objRuta.setIdRuta(getSerial());
        objRuta.setCiudadOrigen(dto.getCiudadOrigen());
        objRuta.setCiudadDestino(dto.getCiudadDestino());
        objRuta.setTarifa(dto.getTarifa());

        objRuta.setNombreImagenPublicoRuta(dto.getNombreImagenPublicoRuta());
        objRuta.setNombreImagenPrivadoRuta(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objRuta.getIdRuta() + Persistencia.SEPARADOR_COLUMNAS
                + objRuta.getCiudadOrigen() + Persistencia.SEPARADOR_COLUMNAS
                + objRuta.getCiudadDestino() + Persistencia.SEPARADOR_COLUMNAS
                + objRuta.getTarifa() + Persistencia.SEPARADOR_COLUMNAS
                + objRuta.getNombreImagenPublicoRuta()+ Persistencia.SEPARADOR_COLUMNAS
                + objRuta.getNombreImagenPrivadoRuta();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdRuta(objRuta.getIdRuta());
            return dto;
        }

        return null;
    }

    @Override
    public List<RutaDto> selectFrom() {
        List<RutaDto> arregloRuta = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int idRuta = Integer.parseInt(columnas[0].trim());
                String ciudadOrigen = columnas[1].trim();
                String ciudadDestino = columnas[2].trim();
                double tarifa = Double.parseDouble(columnas[3].trim());

                arregloRuta.add(new RutaDto(idRuta, ciudadOrigen, ciudadDestino, tarifa, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(RutaServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloRuta;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(RutaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RutaDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RutaDto updateSet(Integer codigo, RutaDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
