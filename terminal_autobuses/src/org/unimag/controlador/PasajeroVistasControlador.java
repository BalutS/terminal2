package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaPasajeroCrear;

public class PasajeroVistasControlador {

    public static StackPane crearPasajero(Stage esce, double anchito, double altito) {
        return new VistaPasajeroCrear(esce, anchito, altito);
    }
}
