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
import org.unimag.controlador.ViajeControladorGrabar;
import org.unimag.dto.BusDto;
import org.unimag.dto.ConductorDto;
import org.unimag.dto.RutaDto;
import org.unimag.dto.ViajeDto;
import org.unimag.recurso.constante.Configuracion;
import org.unimag.recurso.utilidad.Formulario;
import org.unimag.recurso.utilidad.GestorImagen;
import org.unimag.recurso.utilidad.Icono;
import org.unimag.recurso.utilidad.Marco;
import org.unimag.recurso.utilidad.Mensaje;
import org.unimag.servicio.BusServicio;
import org.unimag.servicio.ConductorServicio;
import org.unimag.servicio.RutaServicio;

public class VistaViajeCrear extends StackPane {

    private static final int H_GAP = 10;
    private static final int V_GAP = 20;
    private static final int ALTO_FILA = 40;
    private static final int ALTO_CAJA = 35;
    private static final int TAMANIO_FUENTE = 20;
    private static final double ANCHO = 0.8;

    private static final double AJUSTE_TITULO = 0.1;

    private final GridPane miGrilla;
    private final Rectangle miMarco;

    private ComboBox<String> cbmRuta;
    private ComboBox<String> cbmConductor;
    private ComboBox<String> cbmBus;
    private TextField txtFecha;
    private TextField txtHora;

    private List<RutaDto> rutas;
    private List<ConductorDto> conductores;
    private List<BusDto> buses;

    // Propiedades para el manejo de la imagen
    private TextField cajaImagen;
    private ImageView imgPorDefecto;
    private ImageView imgPrevisualizar;
    private String rutaImagenSeleccionada;

    // *************************************************************************
    public VistaViajeCrear(Stage esce, double ancho, double alto) {
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
        Text miTitulo = new Text("FORMULARIO - CREAR VIAJE");
        miTitulo.setFill(Color.web(Configuracion.MORADO_OSCURO));
        miTitulo.setFont(Font.font("Rockwell", FontWeight.BOLD, 28));
        GridPane.setHalignment(miTitulo, HPos.CENTER);
        GridPane.setMargin(miTitulo, new Insets(30, 0, 0, 0));
        miGrilla.add(miTitulo, 0, 0, 3, 1);
    }

    private void crearFormulario() {
        Label lblRuta = new Label("Ruta");
        lblRuta.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblRuta, 0, 1);

        cbmRuta = new ComboBox<>();
        cbmRuta.setMaxWidth(Double.MAX_VALUE);
        cbmRuta.setPrefHeight(ALTO_CAJA);
        cbmRuta.getItems().add("Selecciona una ruta");
        RutaServicio rutaServicio = new RutaServicio();
        rutas = rutaServicio.selectFrom();
        for (RutaDto ruta : rutas) {
            cbmRuta.getItems().add(ruta.getCiudadOrigen() + "-" + ruta.getCiudadDestino());
        }
        cbmRuta.getSelectionModel().select(0);
        miGrilla.add(cbmRuta, 1, 1);

        Label lblConductor = new Label("Conductor");
        lblConductor.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblConductor, 0, 2);

        cbmConductor = new ComboBox<>();
        cbmConductor.setMaxWidth(Double.MAX_VALUE);
        cbmConductor.setPrefHeight(ALTO_CAJA);
        cbmConductor.getItems().add("Selecciona un conductor");
        ConductorServicio conductorServicio = new ConductorServicio();
        conductores = conductorServicio.selectFrom();
        for (ConductorDto conductor : conductores) {
            cbmConductor.getItems().add(conductor.getNombreConductor());
        }
        cbmConductor.getSelectionModel().select(0);
        miGrilla.add(cbmConductor, 1, 2);

        Label lblBus = new Label("Bus");
        lblBus.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblBus, 0, 3);

        cbmBus = new ComboBox<>();
        cbmBus.setMaxWidth(Double.MAX_VALUE);
        cbmBus.setPrefHeight(ALTO_CAJA);
        cbmBus.getItems().add("Selecciona un bus");
        BusServicio busServicio = new BusServicio();
        buses = busServicio.selectFrom();
        for (BusDto bus : buses) {
            cbmBus.getItems().add(bus.getIdBus() + ", " + bus.getModeloBus());
        }
        cbmBus.getSelectionModel().select(0);
        miGrilla.add(cbmBus, 1, 3);

        Label lblFecha = new Label("Fecha");
        lblFecha.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblFecha, 0, 4);

        txtFecha = new TextField();
        txtFecha.setPromptText("Digita la fecha");
        GridPane.setHgrow(txtFecha, Priority.ALWAYS);
        txtFecha.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtFecha, 1, 4);

        Label lblHora = new Label("Hora");
        lblHora.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblHora, 0, 5);

        txtHora = new TextField();
        txtHora.setPromptText("Digita la hora");
        GridPane.setHgrow(txtHora, Priority.ALWAYS);
        txtHora.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtHora, 1, 5);

        // La sección para la imagen
        // *********************************************************************
        Label lblImagen = new Label("Imagen del viaje");
        lblImagen.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblImagen, 0, 6);

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
        miGrilla.add(panelHorizontal, 1, 6);

        imgPorDefecto = Icono.obtenerIcono("imgNoDisponible.png", 150);
        GridPane.setHalignment(imgPorDefecto, HPos.CENTER);
        GridPane.setValignment(imgPorDefecto, VPos.CENTER);
        miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
        // *********************************************************************

        Button btnGrabar = new Button("Grabar Viaje");
        btnGrabar.setTextFill(Color.web(Configuracion.MORADO_OSCURO));
        btnGrabar.setMaxWidth(Double.MAX_VALUE);
        btnGrabar.setFont(Font.font("Times New Roman", TAMANIO_FUENTE));
        btnGrabar.setOnAction((e) -> {
            guardarViaje();
        });
        miGrilla.add(btnGrabar, 1, 7);
    }

    private void limpiarFormulario() {
        cbmRuta.getSelectionModel().select(0);
        cbmConductor.getSelectionModel().select(0);
        cbmBus.getSelectionModel().select(0);
        txtFecha.setText("");
        txtHora.setText("");
        cbmRuta.requestFocus();

        rutaImagenSeleccionada = "";
        cajaImagen.setText("");
        miGrilla.getChildren().remove(imgPrevisualizar);
        GridPane.setHalignment(imgPorDefecto, HPos.CENTER);
        miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
    }

    private Boolean formularioCompleto() {
        if (cbmRuta.getSelectionModel().getSelectedIndex() == 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge una ruta");
            cbmRuta.requestFocus();
            return false;
        }

        if (cbmConductor.getSelectionModel().getSelectedIndex() == 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge un conductor");
            cbmConductor.requestFocus();
            return false;
        }

        if (cbmBus.getSelectionModel().getSelectedIndex() == 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge un bus");
            cbmBus.requestFocus();
            return false;
        }

        if (txtFecha.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(), "Alerta", "Agrega una fecha");
            txtFecha.requestFocus();
            return false;
        }

        if (txtHora.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(), "Alerta", "Agrega una hora");
            txtHora.requestFocus();
            return false;
        }

        if (rutaImagenSeleccionada.isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Ajá, y la imagen?");
            return false;
        }

        return true;
    }

    private void guardarViaje() {

        if (formularioCompleto()) {
            ViajeDto dto = new ViajeDto();
            int indexRuta = cbmRuta.getSelectionModel().getSelectedIndex() - 1;
            dto.setIdRuta(rutas.get(indexRuta).getIdRuta());
            int indexConductor = cbmConductor.getSelectionModel().getSelectedIndex() - 1;
            dto.setIdConductor(conductores.get(indexConductor).getIdConductor());
            int indexBus = cbmBus.getSelectionModel().getSelectedIndex() - 1;
            dto.setIdBus(buses.get(indexBus).getIdBus());
            dto.setFechaViaje(txtFecha.getText());
            dto.setHoraViaje(txtHora.getText());
            dto.setNombreImagenPublicoViaje(cajaImagen.getText());

            if (ViajeControladorGrabar.crearViaje(dto, rutaImagenSeleccionada)) {
                Mensaje.mostrar(Alert.AlertType.INFORMATION, null, "Exito", "La información ha sido guardada exitosamente");
                cbmRuta.requestFocus();
                limpiarFormulario();
            } else {
                Mensaje.mostrar(Alert.AlertType.ERROR, null, "Exito", "La información no ha podido ser guardada");
                cbmRuta.requestFocus();
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
