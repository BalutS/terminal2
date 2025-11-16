package org.unimag.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.unimag.vista.VistaEmpresaCrear;

public class EmpresaVistasControlador {

    public static StackPane crearEmpresa(Stage esce, double anchito, double altito) {
        return new VistaEmpresaCrear(esce, anchito, altito);
    }
}
