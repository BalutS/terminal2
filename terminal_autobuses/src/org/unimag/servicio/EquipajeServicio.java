package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.EquipajeDto;
import org.unimag.modelo.Equipaje;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class EquipajeServicio implements ApiOperacionBD<EquipajeDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public EquipajeServicio() {

        nombrePersistencia = Persistencia.NOMBRE_EQUIPAJE;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(EquipajeServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(EquipajeServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public EquipajeDto inserInto(EquipajeDto dto, String ruta) {
        Equipaje objEquipaje = new Equipaje();

        objEquipaje.setIdEquipaje(getSerial());
        objEquipaje.setPesoEquipaje(dto.getPesoEquipaje());
        objEquipaje.setIdPasajero(dto.getIdPasajero());

        objEquipaje.setNombreImagenPublicoEquipaje(dto.getNombreImagenPublicoEquipaje());
        objEquipaje.setNombreImagenPrivadoEquipaje(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objEquipaje.getIdEquipaje() + Persistencia.SEPARADOR_COLUMNAS
                + objEquipaje.getPesoEquipaje() + Persistencia.SEPARADOR_COLUMNAS
                + objEquipaje.getIdPasajero() + Persistencia.SEPARADOR_COLUMNAS
                + objEquipaje.getNombreImagenPublicoEquipaje()+ Persistencia.SEPARADOR_COLUMNAS
                + objEquipaje.getNombreImagenPrivadoEquipaje();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdEquipaje(objEquipaje.getIdEquipaje());
            return dto;
        }

        return null;
    }

    @Override
    public List<EquipajeDto> selectFrom() {
        List<EquipajeDto> arregloEquipaje = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int idEquipaje = Integer.parseInt(columnas[0].trim());
                double pesoEquipaje = Double.parseDouble(columnas[1].trim());
                int idPasajero = Integer.parseInt(columnas[2].trim());

                arregloEquipaje.add(new EquipajeDto(idEquipaje, pesoEquipaje, idPasajero, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(EquipajeServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloEquipaje;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(EquipajeServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EquipajeDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EquipajeDto updateSet(Integer codigo, EquipajeDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
