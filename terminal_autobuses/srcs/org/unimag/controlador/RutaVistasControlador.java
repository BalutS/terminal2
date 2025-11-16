package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaRutaCrear;

public class RutaVistasControlador {

    public static StackPane crearRuta(Stage esce, double anchito, double altito) {
        return new VistaRutaCrear(esce, anchito, altito);
    }
}
