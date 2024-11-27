package org.example.proyectofinalpartes.Controller.crearPartes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.proyectofinalpartes.Utils.NuevaPantalla;
import org.example.proyectofinalpartes.Utils.Sesion;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class CrearParteRojoController implements Initializable {

    @FXML
    private Button CrearButton;

    @FXML
    private TextArea DescripcionID;

    @FXML
    private DatePicker FechaID;

    @FXML
    private ChoiceBox<?> NombreGrupoID;

    @FXML
    private TextField NumeroExpedienteID;

    @FXML
    private Button ParteNaranjaButton;

    @FXML
    private Button ParteRojoButton;

    @FXML
    private Button ParteVerdeButton;

    @FXML
    private Label ProfesorID;

    @FXML
    private Label HoraID;

    @FXML
    void onCrearButtonClick(ActionEvent event) {

    }

    @FXML
    void onParteNaranjaButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantallaStageNormal("crearParteNaranja.fxml", "Parte Naranja",ParteNaranjaButton);
    }

    @FXML
    void onParteRojoButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantallaStageNormal("crearParteRojo.fxml", "Parte Rojo",ParteRojoButton);

    }

    @FXML
    void onParteVerdeButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantallaStageNormal("crearParteVerde.fxml", "Parte Verde",ParteVerdeButton);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProfesorID.setText(Sesion.getProfesores().getNombre());
        HoraID.setText(String.valueOf(LocalDateTime.now().getHour())+ ":" + String.valueOf(LocalDateTime.now().getMinute()));
    }
}
