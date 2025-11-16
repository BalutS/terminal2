package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaViajeCrear;

public class ViajeVistasControlador {

    public static StackPane crearViaje(Stage esce, double anchito, double altito) {
        return new VistaViajeCrear(esce, anchito, altito);
    }
}
