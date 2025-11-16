package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.AsientoDto;
import org.unimag.modelo.Asiento;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class AsientoServicio implements ApiOperacionBD<AsientoDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public AsientoServicio() {

        nombrePersistencia = Persistencia.NOMBRE_ASIENTO;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(AsientoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(AsientoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public AsientoDto inserInto(AsientoDto dto, String ruta) {
        Asiento objAsiento = new Asiento();

        objAsiento.setIdAsiento(getSerial());
        objAsiento.setIdBus(dto.getIdBus());
        objAsiento.setEstadoAsiento(dto.isEstadoAsiento());

        objAsiento.setNombreImagenPublicoAsiento(dto.getNombreImagenPublicoAsiento());
        objAsiento.setNombreImagenPrivadoAsiento(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objAsiento.getIdAsiento() + Persistencia.SEPARADOR_COLUMNAS
                + objAsiento.getIdBus() + Persistencia.SEPARADOR_COLUMNAS
                + objAsiento.isEstadoAsiento() + Persistencia.SEPARADOR_COLUMNAS
                + objAsiento.getNombreImagenPublicoAsiento()+ Persistencia.SEPARADOR_COLUMNAS
                + objAsiento.getNombreImagenPrivadoAsiento();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdAsiento(objAsiento.getIdAsiento());
            return dto;
        }

        return null;
    }

    @Override
    public List<AsientoDto> selectFrom() {
        List<AsientoDto> arregloAsiento = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int idAsiento = Integer.parseInt(columnas[0].trim());
                int idBus = Integer.parseInt(columnas[1].trim());
                boolean estadoAsiento = Boolean.parseBoolean(columnas[2].trim());

                arregloAsiento.add(new AsientoDto(idAsiento, idBus, estadoAsiento, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(AsientoServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloAsiento;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(AsientoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AsientoDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AsientoDto updateSet(Integer codigo, AsientoDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
