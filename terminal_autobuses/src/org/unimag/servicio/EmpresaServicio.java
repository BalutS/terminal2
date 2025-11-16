package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.EmpresaDto;
import org.unimag.modelo.Empresa;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class EmpresaServicio implements ApiOperacionBD<EmpresaDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public EmpresaServicio() {

        nombrePersistencia = Persistencia.NOMBRE_EMPRESA;

        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(EmpresaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;

        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(EmpresaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public EmpresaDto inserInto(EmpresaDto dto, String ruta) {
        Empresa objEmpresa = new Empresa();

        objEmpresa.setIdEmpresa(getSerial());
        objEmpresa.setNombreEmpresa(dto.getNombreEmpresa());

        objEmpresa.setNombreImagenPublicoEmpresa(dto.getNombreImagenPublicoEmpresa());
        objEmpresa.setNombreImagenPrivadoEmpresa(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objEmpresa.getIdEmpresa() + Persistencia.SEPARADOR_COLUMNAS
                + objEmpresa.getNombreEmpresa() + Persistencia.SEPARADOR_COLUMNAS
                + objEmpresa.getNombreImagenPublicoEmpresa()+ Persistencia.SEPARADOR_COLUMNAS
                + objEmpresa.getNombreImagenPrivadoEmpresa();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdEmpresa(objEmpresa.getIdEmpresa());
            return dto;
        }

        return null;
    }

    @Override
    public List<EmpresaDto> selectFrom() {
        List<EmpresaDto> arregloEmpresa = new ArrayList<>();
        List<String> arregloDatos = miArchivo.obtenerDatos();

        for (String cadena : arregloDatos) {
            try {
                cadena = cadena.replace("@", "");
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

                int codEmpresa = Integer.parseInt(columnas[0].trim());
                String nomEmpresa = columnas[1].trim();

                arregloEmpresa.add(new EmpresaDto(codEmpresa, nomEmpresa, ""));

            } catch (NumberFormatException error) {
                Logger.getLogger(EmpresaServicio.class.getName()).log(Level.SEVERE, null, error);
            }
        }
        return arregloEmpresa;
    }

    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();

        } catch (IOException ex) {
            Logger.getLogger(EmpresaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EmpresaDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EmpresaDto updateSet(Integer codigo, EmpresaDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
