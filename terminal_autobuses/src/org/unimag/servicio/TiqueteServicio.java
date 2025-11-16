package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.TiqueteDto;
import org.unimag.modelo.Tiquete;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class TiqueteServicio implements ApiOperacionBD<TiqueteDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public TiqueteServicio() {

        nombrePersistencia = Persistencia.NOMBRE_TIQUETE;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(TiqueteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(TiqueteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public TiqueteDto inserInto(TiqueteDto dto, String ruta) {
        Tiquete objTiquete = new Tiquete();

        objTiquete.setIdTiquete(getSerial());
        objTiquete.setIdPasajero(dto.getIdPasajero());
        objTiquete.setIdViaje(dto.getIdViaje());
        objTiquete.setIdAsiento(dto.getIdAsiento());

        objTiquete.setNombreImagenPublicoTiquete(dto.getNombreImagenPublicoTiquete());
        objTiquete.setNombreImagenPrivadoTiquete(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objTiquete.getIdTiquete() + Persistencia.SEPARADOR_COLUMNAS
                + objTiquete.getIdPasajero() + Persistencia.SEPARADOR_COLUMNAS
                + objTiquete.getIdViaje() + Persistencia.SEPARADOR_COLUMNAS
                + objTiquete.getIdAsiento() + Persistencia.SEPARADOR_COLUMNAS
                + objTiquete.getNombreImagenPublicoTiquete()+ Persistencia.SEPARADOR_COLUMNAS
                + objTiquete.getNombreImagenPrivadoTiquete();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdTiquete(objTiquete.getIdTiquete());
            return dto;
        }

        return null;
    }

    @Override
    public List<TiqueteDto> selectFrom() {
        List<TiqueteDto> arregloTiquete = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int idTiquete = Integer.parseInt(columnas[0].trim());
                int idPasajero = Integer.parseInt(columnas[1].trim());
                int idViaje = Integer.parseInt(columnas[2].trim());
                int idAsiento = Integer.parseInt(columnas[3].trim());

                arregloTiquete.add(new TiqueteDto(idTiquete, idPasajero, idViaje, idAsiento, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(TiqueteServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloTiquete;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(TiqueteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TiqueteDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TiqueteDto updateSet(Integer codigo, TiqueteDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
