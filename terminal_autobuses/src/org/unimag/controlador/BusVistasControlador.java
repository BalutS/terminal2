package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaBusCrear;

public class BusVistasControlador {

    public static StackPane crearBus(Stage esce, double anchito, double altito) {
        return new VistaBusCrear(esce, anchito, altito);
    }
}
