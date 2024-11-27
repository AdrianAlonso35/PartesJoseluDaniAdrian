package org.example.proyectofinalpartes.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListaAlumnosController {

    @FXML
    private Button buscarButton;

    @FXML
    private TableColumn<?, ?> expedienteTablaIdAlumno;

    @FXML
    private TableColumn<?, ?> grupoTablaIdAlumno;

    @FXML
    private TableColumn<?, ?> nombreTablaIdAlumno;

    @FXML
    private TextField numeroExpedienteAlumno;

    @FXML
    private TableColumn<?, ?> puntosAcumuladosTablaIdAlumno;

    @FXML
    private TableView<?> tablaId;

    @FXML
    void onbuscarButtonClick(ActionEvent event) {

    }
}