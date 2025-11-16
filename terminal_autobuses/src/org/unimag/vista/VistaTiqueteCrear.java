package org.unimag.vista;

import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.unimag.controlador.TiqueteControladorGrabar;
import org.unimag.dto.AsientoDto;
import org.unimag.dto.PasajeroDto;
import org.unimag.dto.TiqueteDto;
import org.unimag.dto.ViajeDto;
import org.unimag.recurso.constante.Configuracion;
import org.unimag.recurso.utilidad.Formulario;
import org.unimag.recurso.utilidad.GestorImagen;
import org.unimag.recurso.utilidad.Icono;
import org.unimag.recurso.utilidad.Marco;
import org.unimag.recurso.utilidad.Mensaje;
import org.unimag.servicio.AsientoServicio;
import org.unimag.servicio.PasajeroServicio;
import org.unimag.servicio.ViajeServicio;

public class VistaTiqueteCrear extends StackPane {

    private static final int H_GAP = 10;
    private static final int V_GAP = 20;
    private static final int ALTO_FILA = 40;
    private static final int ALTO_CAJA = 35;
    private static final int TAMANIO_FUENTE = 20;
    private static final double ANCHO = 0.8;

    private static final double AJUSTE_TITULO = 0.1;

    private final GridPane miGrilla;
    private final Rectangle miMarco;

    private ComboBox<String> cbmPasajero;
    private ComboBox<String> cbmViaje;
    private ComboBox<String> cbmAsiento;

    private List<PasajeroDto> pasajeros;
    private List<ViajeDto> viajes;
    private List<AsientoDto> asientos;

    // Propiedades para el manejo de la imagen
    private TextField cajaImagen;
    private ImageView imgPorDefecto;
    private ImageView imgPrevisualizar;
    private String rutaImagenSeleccionada;

    // *************************************************************************
    public VistaTiqueteCrear(Stage esce, double ancho, double alto) {
        rutaImagenSeleccionada = "";
        setAlignment(Pos.CENTER);

        miGrilla = new GridPane();

        miMarco = Marco.crear(esce, Configuracion.MARCO_ALTO_PORCENTAJE,
                Configuracion.MARCO_ANCHO_PORCENTAJE,
                Configuracion.DEGRADE_ARREGLO_GENERO,
                Configuracion.DEGRADE_BORDE);

        getChildren().add(miMarco);

        configurarMiGrilla(ancho, alto);
        crearTitulo();
        crearFormulario();
        colocarFrmElegante();
        getChildren().add(miGrilla);
    }

    private void configurarMiGrilla(double ancho, double alto) {
        double miAnchoGrilla = ancho * Configuracion.GRILLA_ANCHO_PORCENTAJE;
        miGrilla.setHgap(H_GAP);
        miGrilla.setVgap(V_GAP);
        miGrilla.setPrefSize(miAnchoGrilla, alto);
        miGrilla.setMinSize(miAnchoGrilla, alto);

        miGrilla.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col0.setPrefWidth(200);
        col1.setPrefWidth(200);
        col2.setPrefWidth(200);

        col1.setHgrow(Priority.ALWAYS);
        miGrilla.getColumnConstraints().addAll(col0, col1, col2);

        for (int i = 0; i < 7; i++) {
            RowConstraints fila = new RowConstraints();
            fila.setMinHeight(ALTO_FILA);
            fila.setMaxHeight(ALTO_FILA);
            miGrilla.getRowConstraints().add(fila);
        }
    }

    private void crearTitulo() {
        Text miTitulo = new Text("FORMULARIO - CREAR TIQUETE");
        miTitulo.setFill(Color.web(Configuracion.MORADO_OSCURO));
        miTitulo.setFont(Font.font("Rockwell", FontWeight.BOLD, 28));
        GridPane.setHalignment(miTitulo, HPos.CENTER);
        GridPane.setMargin(miTitulo, new Insets(30, 0, 0, 0));
        miGrilla.add(miTitulo, 0, 0, 3, 1);
    }

    private void crearFormulario() {
        Label lblPasajero = new Label("Pasajero");
        lblPasajero.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblPasajero, 0, 1);

        cbmPasajero = new ComboBox<>();
        cbmPasajero.setMaxWidth(Double.MAX_VALUE);
        cbmPasajero.setPrefHeight(ALTO_CAJA);
        cbmPasajero.getItems().add("Selecciona un pasajero");
        PasajeroServicio pasajeroServicio = new PasajeroServicio();
        pasajeros = pasajeroServicio.selectFrom();
        for (PasajeroDto pasajero : pasajeros) {
            cbmPasajero.getItems().add(pasajero.getNombrePasajero());
        }
        cbmPasajero.getSelectionModel().select(0);
        miGrilla.add(cbmPasajero, 1, 1);

        Label lblViaje = new Label("Viaje");
        lblViaje.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblViaje, 0, 2);

        cbmViaje = new ComboBox<>();
        cbmViaje.setMaxWidth(Double.MAX_VALUE);
        cbmViaje.setPrefHeight(ALTO_CAJA);
        cbmViaje.getItems().add("Selecciona un viaje");
        ViajeServicio viajeServicio = new ViajeServicio();
        viajes = viajeServicio.selectFrom();
        for (ViajeDto viaje : viajes) {
            cbmViaje.getItems().add(viaje.getIdViaje() + ", " + viaje.getFechaViaje() + ", " + viaje.getHoraViaje());
        }
        cbmViaje.getSelectionModel().select(0);
        miGrilla.add(cbmViaje, 1, 2);

        Label lblAsiento = new Label("Asiento");
        lblAsiento.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblAsiento, 0, 3);

        cbmAsiento = new ComboBox<>();
        cbmAsiento.setMaxWidth(Double.MAX_VALUE);
        cbmAsiento.setPrefHeight(ALTO_CAJA);
        cbmAsiento.getItems().add("Selecciona un asiento");
        AsientoServicio asientoServicio = new AsientoServicio();
        asientos = asientoServicio.selectFrom();
        for (AsientoDto asiento : asientos) {
            cbmAsiento.getItems().add(String.valueOf(asiento.getIdAsiento()));
        }
        cbmAsiento.getSelectionModel().select(0);
        miGrilla.add(cbmAsiento, 1, 3);

        // La sección para la imagen
        // *********************************************************************
        Label lblImagen = new Label("Imagen del tiquete");
        lblImagen.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblImagen, 0, 4);

        cajaImagen = new TextField();
        cajaImagen.setDisable(true);
        cajaImagen.setPrefHeight(ALTO_CAJA);
        String[] extensiones = {"*.png", "*.jpg", "*.jpeg"};
        FileChooser objSeleccionar = Formulario.selectorImagen(
                "Selecciona la foto", "Imagenes", extensiones);
        Button btnSeleccionarImagen = new Button("+");
        btnSeleccionarImagen.setPrefHeight(ALTO_CAJA);
        btnSeleccionarImagen.setOnAction((e) -> {
            rutaImagenSeleccionada = GestorImagen.obtenerRutaImagen(
                    cajaImagen, objSeleccionar);
            if (rutaImagenSeleccionada.isEmpty()) {
                miGrilla.getChildren().remove(imgPorDefecto);
                miGrilla.getChildren().remove(imgPrevisualizar);
                miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
            }else{
                miGrilla.getChildren().remove(imgPorDefecto);
                miGrilla.getChildren().remove(imgPrevisualizar);
                imgPrevisualizar = Icono.previsualizar(
                        rutaImagenSeleccionada, 150);
                GridPane.setHalignment(imgPrevisualizar, HPos.CENTER);
                miGrilla.add(imgPrevisualizar, 2, 1, 1, 5);
            }
        });

        HBox.setHgrow(cajaImagen, Priority.ALWAYS);
        HBox panelHorizontal = new HBox(2);
        panelHorizontal.setAlignment(Pos.BOTTOM_RIGHT);
        panelHorizontal.getChildren().addAll(cajaImagen, btnSeleccionarImagen);
        miGrilla.add(panelHorizontal, 1, 4);

        imgPorDefecto = Icono.obtenerIcono("imgNoDisponible.png", 150);
        GridPane.setHalignment(imgPorDefecto, HPos.CENTER);
        GridPane.setValignment(imgPorDefecto, VPos.CENTER);
        miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
        // *********************************************************************

        Button btnGrabar = new Button("Grabar Tiquete");
        btnGrabar.setTextFill(Color.web(Configuracion.MORADO_OSCURO));
        btnGrabar.setMaxWidth(Double.MAX_VALUE);
        btnGrabar.setFont(Font.font("Times New Roman", TAMANIO_FUENTE));
        btnGrabar.setOnAction((e) -> {
            guardarTiquete();
        });
        miGrilla.add(btnGrabar, 1, 5);
    }

    private void limpiarFormulario() {
        cbmPasajero.getSelectionModel().select(0);
        cbmViaje.getSelectionModel().select(0);
        cbmAsiento.getSelectionModel().select(0);
        cbmPasajero.requestFocus();

        rutaImagenSeleccionada = "";
        cajaImagen.setText("");
        miGrilla.getChildren().remove(imgPrevisualizar);
        GridPane.setHalignment(imgPorDefecto, HPos.CENTER);
        miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
    }

    private Boolean formularioCompleto() {
        if (cbmPasajero.getSelectionModel().getSelectedIndex() == 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge un pasajero");
            cbmPasajero.requestFocus();
            return false;
        }

        if (cbmViaje.getSelectionModel().getSelectedIndex() == 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge un viaje");
            cbmViaje.requestFocus();
            return false;
        }

        if (cbmAsiento.getSelectionModel().getSelectedIndex() == 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge un asiento");
            cbmAsiento.requestFocus();
            return false;
        }

        if (rutaImagenSeleccionada.isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Ajá, y la imagen?");
            return false;
        }

        return true;
    }

    private void guardarTiquete() {

        if (formularioCompleto()) {
            TiqueteDto dto = new TiqueteDto();
            int indexPasajero = cbmPasajero.getSelectionModel().getSelectedIndex() - 1;
            dto.setIdPasajero(pasajeros.get(indexPasajero).getIdPasajero());
            int indexViaje = cbmViaje.getSelectionModel().getSelectedIndex() - 1;
            dto.setIdViaje(viajes.get(indexViaje).getIdViaje());
            int indexAsiento = cbmAsiento.getSelectionModel().getSelectedIndex() - 1;
            dto.setIdAsiento(asientos.get(indexAsiento).getIdAsiento());
            dto.setNombreImagenPublicoTiquete(cajaImagen.getText());

            if (TiqueteControladorGrabar.crearTiquete(dto, rutaImagenSeleccionada)) {
                Mensaje.mostrar(Alert.AlertType.INFORMATION, null, "Exito", "La información ha sido guardada exitosamente");
                cbmPasajero.requestFocus();
                limpiarFormulario();
            } else {
                Mensaje.mostrar(Alert.AlertType.ERROR, null, "Exito", "La información no ha podido ser guardada");
                cbmPasajero.requestFocus();
            }
        }
    }

    private void colocarFrmElegante() {
        Runnable calcular = () -> {

            double alturaMarco = miMarco.getHeight();

            if (alturaMarco > 0) {

                double desplazamiento = alturaMarco * AJUSTE_TITULO;
                miGrilla.setTranslateY(-alturaMarco / 2 + desplazamiento);
            }
        };

        calcular.run();

        miMarco.heightProperty().addListener((obs, antes, despues) -> {
            calcular.run();
        });

    }
}
