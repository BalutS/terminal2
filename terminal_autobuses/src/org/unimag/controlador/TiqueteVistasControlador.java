package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaTiqueteCrear;

public class TiqueteVistasControlador {

    public static StackPane crearTiquete(Stage esce, double anchito, double altito) {
        return new VistaTiqueteCrear(esce, anchito, altito);
    }
}
