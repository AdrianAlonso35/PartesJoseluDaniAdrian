package org.example.proyectofinalpartes.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;
import org.example.proyectofinalpartes.Clases.Profesores;
import org.example.proyectofinalpartes.DAO.ProfesoresDAO;
import org.example.proyectofinalpartes.Utils.Alertas;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class           CrearProfesoresController implements Initializable {
    @FXML
    private PasswordField contrasenaID;

    @FXML
    private Button crearButton;

    @FXML
    private TextField nombreID;

    @FXML
    private TextField numeroAsignadoID;

    @FXML
    private ComboBox<String> tipoID;

    ProfesoresDAO profesoresDAO = new ProfesoresDAO();

    Profesores profesores;

    @FXML
    void onCrearButtonClick(ActionEvent event) {
        if(nombreID.getText().isEmpty()|| numeroAsignadoID.getText().isEmpty() || tipoID.getValue().isEmpty()){
            Alertas.alertaError("Rellena todos los campos");
        }else {
            String nombre= nombreID.getText();
            int numeroAsignado= Integer.parseInt(numeroAsignadoID.getText());
            String contrasenaEncriptada= DigestUtils.sha256Hex(contrasenaID.getText());
            String tipo= tipoID.getValue();
            if (profesoresDAO.comprobarProfesor(numeroAsignado)){
                Alertas.alertaError("Ya hay un profesor con ese numero asignado");
            }else {
                if (contrasenaID.getText().isEmpty()){
                    profesores = new Profesores(null,nombre,numeroAsignado,tipo);
                }else {
                    profesores = new Profesores(contrasenaEncriptada,nombre,numeroAsignado,tipo);
                }
                if (profesoresDAO.crearProfesor(profesores)){
                    Alertas.alertaInfo("Profesor creado correctamente");
                    nombreID.clear();
                    contrasenaID.clear();
                    numeroAsignadoID.clear();
                    tipoID.setValue(null);
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> tipos= new ArrayList<>();
        tipos.add("jefe_de_estudios");
        tipos.add("profesor");
        tipoID.getItems().addAll(tipos);

    }
}
