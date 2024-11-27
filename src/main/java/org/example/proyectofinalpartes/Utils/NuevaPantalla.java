package org.example.proyectofinalpartes.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.proyectofinalpartes.Controller.ListaPartesController;
import org.example.proyectofinalpartes.Main;

import java.awt.*;
import java.util.Arrays;

public class NuevaPantalla {
    public static void  nuevaPantalla(String ruta, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            Alertas.alertaError(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    public static void  nuevaPantallaStageNormal(String ruta, String title, Button button) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            Alertas.alertaError(e.getMessage());
            System.out.println(e.getMessage());

        }
    }
}
