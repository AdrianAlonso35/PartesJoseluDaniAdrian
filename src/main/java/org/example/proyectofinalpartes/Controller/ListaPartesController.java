package org.example.proyectofinalpartes.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListaPartesController {
    @FXML
    private Button buscarButton;

    @FXML
    private Button buscarFechaButton;

    @FXML
    private TableColumn<?, ?> descripcionTablaId;

    @FXML
    private TableColumn<?, ?> expedienteTablaId;

    @FXML
    private DatePicker fecha1Buscar;

    @FXML
    private DatePicker fecha2Buscar;

    @FXML
    private TableColumn<?, ?> fechaTablaId;

    @FXML
    private TableColumn<?, ?> grupoTablaId;

    @FXML
    private TableColumn<?, ?> nombreTablaId;

    @FXML
    private TextField numeroExpedienteBuscar;

    @FXML
    private TableColumn<?, ?> profesorTablaId;

    @FXML
    private TableColumn<?, ?> sancionTablaId;

    @FXML
    private TableView<?> tablaId;

    @FXML
    void onbuscarButtonClick(ActionEvent event) {

    }

    @FXML
    void onbuscarFechaButtonClick(ActionEvent event) {

    }

}
