package org.example.proyectofinalpartes.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.proyectofinalpartes.DAO.ProfesoresDAO;
import org.example.proyectofinalpartes.Utils.NuevaPantalla;
import org.example.proyectofinalpartes.Utils.Sesion;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuSuperiorController implements Initializable{

    @FXML
    private Button crearParteButton;

    @FXML
    private Button listaPartesButton;

    @FXML
    private Button listaAlumnosButtonClick;

    @FXML
    private Button crearProfesorButton;

    ProfesoresDAO profesoresDAO = new ProfesoresDAO();

    @FXML
    void onCrearParteButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantalla("crearParteVerde.fxml", "Crear Partes");
    }

    @FXML
    void onlistaPartesButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantalla("listaPartes.fxml", "Lista Partes");
    }

    @FXML
    void onlistaAlumnosButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantalla("listaAlumnos.fxml", "Lista Alumnos");
    }

    @FXML
    void oncrearProfesorButtonClick(ActionEvent event) {
        NuevaPantalla.nuevaPantalla("crearProfesores.fxml", "Crear Profesores");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Gola");
        // Deshabilitar botones si se cumple una condición
        if (Objects.equals(Sesion.getProfesores().getTipo(), "profesor")) {
            crearProfesorButton.setDisable(true);
            listaPartesButton.setDisable(true);
            listaAlumnosButtonClick.setDisable(true);
        }
    }
}
