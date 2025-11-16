package org.unimag.controlador;

import org.unimag.dto.PasajeroDto;
import org.unimag.servicio.PasajeroServicio;

public class PasajeroControladorGrabar {

    public static Boolean crearPasajero(PasajeroDto dto, String rutaDeLaImagen) {

        Boolean correcto = false;
        PasajeroServicio pasajeroServicio = new PasajeroServicio();
        PasajeroDto dtoRespuesta;
        dtoRespuesta = pasajeroServicio.inserInto(dto, rutaDeLaImagen);

        if (dtoRespuesta != null) {
            correcto = true;
        }

        return correcto;
    }
}
