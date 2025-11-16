package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.BusDto;
import org.unimag.modelo.Bus;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class BusServicio implements ApiOperacionBD<BusDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public BusServicio() {

        nombrePersistencia = Persistencia.NOMBRE_BUS;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public BusDto inserInto(BusDto dto, String ruta) {
        Bus objBus = new Bus();

        objBus.setIdBus(getSerial());
        objBus.setModeloBus(dto.getModeloBus());
        objBus.setIdEmpresa(dto.getIdEmpresa());

        objBus.setNombreImagenPublicoBus(dto.getNombreImagenPublicoBus());
        objBus.setNombreImagenPrivadoBus(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objBus.getIdBus() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getModeloBus() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getIdEmpresa() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getNombreImagenPublicoBus()+ Persistencia.SEPARADOR_COLUMNAS
                + objBus.getNombreImagenPrivadoBus();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdBus(objBus.getIdBus());
            return dto;
        }

        return null;
    }

    @Override
    public List<BusDto> selectFrom() {
        List<BusDto> arregloBus = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int codBus = Integer.parseInt(columnas[0].trim());
                String modeloBus = columnas[1].trim();
                int idEmpresa = Integer.parseInt(columnas[2].trim());

                arregloBus.add(new BusDto(codBus, modeloBus, idEmpresa, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloBus;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BusDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BusDto updateSet(Integer codigo, BusDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
