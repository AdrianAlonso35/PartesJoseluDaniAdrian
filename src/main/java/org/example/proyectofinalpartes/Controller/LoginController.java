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

    ProfesoresDAO profesoresDAO= new ProfesoresDAO();

    @FXML
    void onIniciarSesionButtonClick(ActionEvent event){
        String contrasena=DigestUtils.sha256Hex(contrasenaInicioSesion.getText());
        System.out.println(contrasena);
        if (numeroAsignadoInicioSesion.getText().isEmpty() ||contrasenaInicioSesion.getText().isEmpty()){
            Alertas.alertaError("Rellena todos los campos");
        }else {
            int numeroAsignado= Integer.parseInt(numeroAsignadoInicioSesion.getText());
            String contrasenaEncriptada= DigestUtils.sha256Hex(contrasenaInicioSesion.getText());
            if (profesoresDAO.comprobarProfesor(numeroAsignado)){
                if (profesoresDAO.comprobarProfesorContrasena(numeroAsignado, contrasenaEncriptada)){
                    String nombreProfesor = profesoresDAO.obtenerNombrePorNumero(Integer.parseInt(numeroAsignadoInicioSesion.getText()));
                    String tipoProfesor = profesoresDAO.obtenerTipo(numeroAsignado);
                    Profesores profesores = new Profesores(contrasenaEncriptada,nombreProfesor,numeroAsignado,tipoProfesor);
                    Sesion.setProfesores(profesores); //guardar el profesor que ha iniciado sesion en la clase sesion

                    NuevaPantalla.nuevaPantalla("menuProfesor.fxml", "Menu Profesores");
                }else {
                    Alertas.alertaError("Contrasena incorrecta");
                }
            }else {
                Alertas.alertaError("Profesor no existe");

            }
        }
    }


}
