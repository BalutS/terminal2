package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaConductorCrear;

public class ConductorVistasControlador {

    public static StackPane crearConductor(Stage esce, double anchito, double altito) {
        return new VistaConductorCrear(esce, anchito, altito);
    }
}
