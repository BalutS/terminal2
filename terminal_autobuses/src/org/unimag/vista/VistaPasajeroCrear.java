package org.unimag.vista;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import org.unimag.controlador.PasajeroControladorGrabar;
import org.unimag.dto.PasajeroDto;
import org.unimag.recurso.constante.Configuracion;
import org.unimag.recurso.utilidad.Formulario;
import org.unimag.recurso.utilidad.GestorImagen;
import org.unimag.recurso.utilidad.Icono;
import org.unimag.recurso.utilidad.Marco;
import org.unimag.recurso.utilidad.Mensaje;

public class VistaPasajeroCrear extends StackPane {

    private static final int H_GAP = 10;
    private static final int V_GAP = 20;
    private static final int ALTO_FILA = 40;
    private static final int ALTO_CAJA = 35;
    private static final int TAMANIO_FUENTE = 20;
    private static final double ANCHO = 0.8;

    private static final double AJUSTE_TITULO = 0.1;

    private final GridPane miGrilla;
    private final Rectangle miMarco;

    private TextField txtCedula;
    private TextField txtNombre;
    private TextField txtEdad;
    private RadioButton rbMasculino;
    private RadioButton rbFemenino;

    // Propiedades para el manejo de la imagen
    private TextField cajaImagen;
    private ImageView imgPorDefecto;
    private ImageView imgPrevisualizar;
    private String rutaImagenSeleccionada;

    // *************************************************************************
    public VistaPasajeroCrear(Stage esce, double ancho, double alto) {
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
        Text miTitulo = new Text("FORMULARIO - CREAR PASAJERO");
        miTitulo.setFill(Color.web(Configuracion.MORADO_OSCURO));
        miTitulo.setFont(Font.font("Rockwell", FontWeight.BOLD, 28));
        GridPane.setHalignment(miTitulo, HPos.CENTER);
        GridPane.setMargin(miTitulo, new Insets(30, 0, 0, 0));
        miGrilla.add(miTitulo, 0, 0, 3, 1);
    }

    private void crearFormulario() {
        Label lblCedula = new Label("Cédula");
        lblCedula.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblCedula, 0, 1);

        txtCedula = new TextField();
        txtCedula.setPromptText("Digita la cédula");
        GridPane.setHgrow(txtCedula, Priority.ALWAYS);
        txtCedula.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtCedula, 1, 1);

        Label lblNombre = new Label("Nombre");
        lblNombre.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblNombre, 0, 2);

        txtNombre = new TextField();
        txtNombre.setPromptText("Digita el nombre");
        GridPane.setHgrow(txtNombre, Priority.ALWAYS);
        txtNombre.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtNombre, 1, 2);

        Label lblEdad = new Label("Edad");
        lblEdad.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblEdad, 0, 3);

        txtEdad = new TextField();
        txtEdad.setPromptText("Digita la edad");
        GridPane.setHgrow(txtEdad, Priority.ALWAYS);
        txtEdad.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtEdad, 1, 3);

        Label lblGenero = new Label("Género");
        lblGenero.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblGenero, 0, 4);

        ToggleGroup group = new ToggleGroup();
        rbMasculino = new RadioButton("Masculino");
        rbMasculino.setToggleGroup(group);
        rbFemenino = new RadioButton("Femenino");
        rbFemenino.setToggleGroup(group);
        HBox hbox = new HBox(10, rbMasculino, rbFemenino);
        miGrilla.add(hbox, 1, 4);

        // La sección para la imagen
        // *********************************************************************
        Label lblImagen = new Label("Imagen del pasajero");
        lblImagen.setFont(Font.font("Times New Roman", FontPosture.ITALIC, TAMANIO_FUENTE));
        miGrilla.add(lblImagen, 0, 5);

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
        miGrilla.add(panelHorizontal, 1, 5);

        imgPorDefecto = Icono.obtenerIcono("imgNoDisponible.png", 150);
        GridPane.setHalignment(imgPorDefecto, HPos.CENTER);
        GridPane.setValignment(imgPorDefecto, VPos.CENTER);
        miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
        // *********************************************************************

        Button btnGrabar = new Button("Grabar Pasajero");
        btnGrabar.setTextFill(Color.web(Configuracion.MORADO_OSCURO));
        btnGrabar.setMaxWidth(Double.MAX_VALUE);
        btnGrabar.setFont(Font.font("Times New Roman", TAMANIO_FUENTE));
        btnGrabar.setOnAction((e) -> {
            guardarPasajero();
        });
        miGrilla.add(btnGrabar, 1, 6);
    }

    private void limpiarFormulario() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(false);
        txtCedula.requestFocus();

        rutaImagenSeleccionada = "";
        cajaImagen.setText("");
        miGrilla.getChildren().remove(imgPrevisualizar);
        GridPane.setHalignment(imgPorDefecto, HPos.CENTER);
        miGrilla.add(imgPorDefecto, 2, 1, 1, 5);
    }

    private Boolean formularioCompleto() {
        if (txtCedula.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(), "Alerta", "Agrega una cédula");
            txtCedula.requestFocus();
            return false;
        }

        if (txtNombre.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(), "Alerta", "Agrega un nombre");
            txtNombre.requestFocus();
            return false;
        }

        if (txtEdad.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(), "Alerta", "Agrega una edad");
            txtEdad.requestFocus();
            return false;
        }

        if (!rbMasculino.isSelected() && !rbFemenino.isSelected()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Escoge un género");
            return false;
        }

        if (rutaImagenSeleccionada.isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, null, "Alerta", "Ajá, y la imagen?");
            return false;
        }

        return true;
    }

    private void guardarPasajero() {

        if (formularioCompleto()) {
            PasajeroDto dto = new PasajeroDto();
            dto.setCedulaPasajero(txtCedula.getText());
            dto.setNombrePasajero(txtNombre.getText());
            dto.setEdadPasajero(Integer.parseInt(txtEdad.getText()));
            dto.setGeneroPasajero(rbMasculino.isSelected());
            dto.setNombreImagenPublicoPasajero(cajaImagen.getText());

            if (PasajeroControladorGrabar.crearPasajero(dto, rutaImagenSeleccionada)) {
                Mensaje.mostrar(Alert.AlertType.INFORMATION, null, "Exito", "La información ha sido guardada exitosamente");
                txtCedula.requestFocus();
                limpiarFormulario();
            } else {
                Mensaje.mostrar(Alert.AlertType.ERROR, null, "Exito", "La información no ha podido ser guardada");
                txtCedula.requestFocus();
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
