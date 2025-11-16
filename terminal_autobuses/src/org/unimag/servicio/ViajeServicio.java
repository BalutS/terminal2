package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.ViajeDto;
import org.unimag.modelo.Viaje;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class ViajeServicio implements ApiOperacionBD<ViajeDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public ViajeServicio() {

        nombrePersistencia = Persistencia.NOMBRE_VIAJE;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(ViajeServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(ViajeServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public ViajeDto inserInto(ViajeDto dto, String ruta) {
        Viaje objViaje = new Viaje();

        objViaje.setIdViaje(getSerial());
        objViaje.setIdRuta(dto.getIdRuta());
        objViaje.setIdConductor(dto.getIdConductor());
        objViaje.setIdBus(dto.getIdBus());
        objViaje.setFechaViaje(dto.getFechaViaje());
        objViaje.setHoraViaje(dto.getHoraViaje());

        objViaje.setNombreImagenPublicoViaje(dto.getNombreImagenPublicoViaje());
        objViaje.setNombreImagenPrivadoViaje(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objViaje.getIdViaje() + Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getIdRuta() + Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getIdConductor() + Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getIdBus() + Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getFechaViaje() + Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getHoraViaje() + Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getNombreImagenPublicoViaje()+ Persistencia.SEPARADOR_COLUMNAS
                + objViaje.getNombreImagenPrivadoViaje();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdViaje(objViaje.getIdViaje());
            return dto;
        }

        return null;
    }

    @Override
    public List<ViajeDto> selectFrom() {
        List<ViajeDto> arregloViaje = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int idViaje = Integer.parseInt(columnas[0].trim());
                int idRuta = Integer.parseInt(columnas[1].trim());
                int idConductor = Integer.parseInt(columnas[2].trim());
                int idBus = Integer.parseInt(columnas[3].trim());
                String fechaViaje = columnas[4].trim();
                String horaViaje = columnas[5].trim();

                arregloViaje.add(new ViajeDto(idViaje, idRuta, idConductor, idBus, fechaViaje, horaViaje, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(ViajeServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloViaje;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(ViajeServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ViajeDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ViajeDto updateSet(Integer codigo, ViajeDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
