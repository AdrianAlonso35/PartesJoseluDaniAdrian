package org.example.proyectofinalpartes.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;
import org.example.proyectofinalpartes.Clases.Profesores;
import org.example.proyectofinalpartes.DAO.ProfesoresDAO;
import org.example.proyectofinalpartes.Main;
import org.example.proyectofinalpartes.Utils.Alertas;
import org.example.proyectofinalpartes.Utils.NuevaPantalla;
import org.example.proyectofinalpartes.Utils.Sesion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    public PasswordField contrasenaInicioSesion;

    @FXML
    private Button iniciarSesionButton;

    @FXML
    private TextField numeroAsignadoInicioSesion;

    ProfesoresDAO profesoresDAO = new ProfesoresDAO();

    @FXML
    void onIniciarSesionButtonClick(ActionEvent event) {
        String contrasena = DigestUtils.sha256Hex(contrasenaInicioSesion.getText());
        System.out.println(contrasena);
        if (numeroAsignadoInicioSesion.getText().isEmpty()) {
            Alertas.alertaError("Introduce tu numero asignado");
        } else {
            int numeroAsignado = Integer.parseInt(numeroAsignadoInicioSesion.getText());
            String contrasenaEncriptada = DigestUtils.sha256Hex(contrasenaInicioSesion.getText());
            String nombreProfesor;
            String tipoProfesor;

            if (profesoresDAO.comprobarProfesor(numeroAsignado)) {
                if (contrasenaInicioSesion.getText().isEmpty()) {
                    if (profesoresDAO.comprobarProfesorContrasenaNull(numeroAsignado)) {
                        nombreProfesor = profesoresDAO.obtenerNombrePorNumero(Integer.parseInt(numeroAsignadoInicioSesion.getText()));
                        tipoProfesor = profesoresDAO.obtenerTipo(numeroAsignado);
                        Profesores profesores = new Profesores(nombreProfesor, numeroAsignado, tipoProfesor);
                        Sesion.setProfesores(profesores); //guardar el profesor que ha iniciado sesion en la clase sesion

                        NuevaPantalla.nuevaPantalla("menuProfesor.fxml", "Menu Profesores");
                    }else {
                        Alertas.alertaError("Contrasena incorrecta");
                    }

                } else {
                    if (profesoresDAO.comprobarProfesorContrasena(numeroAsignado, contrasenaEncriptada)) {
                        nombreProfesor = profesoresDAO.obtenerNombrePorNumero(Integer.parseInt(numeroAsignadoInicioSesion.getText()));
                        tipoProfesor = profesoresDAO.obtenerTipo(numeroAsignado);
                        Profesores profesores = new Profesores(contrasenaEncriptada, nombreProfesor, numeroAsignado, tipoProfesor);
                        Sesion.setProfesores(profesores);

                        NuevaPantalla.nuevaPantalla("menuProfesor.fxml", "Menu Profesores");
                    } else {
                        Alertas.alertaError("Contrasena incorrecta");
                    }
                }
                numeroAsignadoInicioSesion.clear();
                contrasenaInicioSesion.clear();
            }else{
                Alertas.alertaError("Profesor no existe");
            }
        }
    }
}
