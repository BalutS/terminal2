package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaAsientoCrear;

public class AsientoVistasControlador {

    public static StackPane crearAsiento(Stage esce, double anchito, double altito) {
        return new VistaAsientoCrear(esce, anchito, altito);
    }
}
