package org.example.proyectofinalpartes.Controller.crearPartes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import org.example.proyectofinalpartes.Clases.*;
import org.example.proyectofinalpartes.DAO.AlumnosDAO;
import org.example.proyectofinalpartes.DAO.Parte_incidenciaDAO;
import org.example.proyectofinalpartes.Utils.Alertas;
import org.example.proyectofinalpartes.Utils.NuevaPantalla;
import org.example.proyectofinalpartes.Utils.Sesion;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CrearParteNaranjaController implements Initializable {

    @FXML
    private Button CrearButton;

    @FXML
    private TextArea DescripcionID;

    @FXML
    private DatePicker FechaID;

    @FXML
    private TextField NumeroExpedienteID;

    @FXML
    private ComboBox<String> comboBoxHora;

    @FXML
    private TextArea sancionRecibirAlumno;

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
    private TextField nombreGrupoId;

    ArrayList<String> listaHora = new ArrayList<>();
    AlumnosDAO alumnosDAO = new AlumnosDAO();
    String grupoAlumno;
    String numeroExpedienteAlumno;
    Parte_incidenciaDAO parte_incidenciaDAO = new Parte_incidenciaDAO();

    @FXML
    void onCrearButtonClick(ActionEvent event) {
        int idGrupo = alumnosDAO.cogerGrupoAlumno(numeroExpedienteAlumno);
        Grupos idGrupo1 = new Grupos(idGrupo);
        int idAlumno = alumnosDAO.getAlumnoPorId(numeroExpedienteAlumno);
        Alumnos alumnosId = new Alumnos(idAlumno);
        int idProfesor = Sesion.getProfesores().getId_profesor();
        Profesores profesores = new Profesores(idProfesor);
        int puntosParte = 6; //cambiar por los colores en el enum
        Puntuacion_partes puntuacion = new Puntuacion_partes(puntosParte);
        String descripcion = DescripcionID.getText();
        LocalDate fecha = FechaID.getValue();
        String hora = comboBoxHora.getValue();
        String sancion = sancionRecibirAlumno.getText();
        System.out.println(idAlumno);
        Partes_incidencia parte = new Partes_incidencia(descripcion,fecha,hora,sancion,alumnosId,idGrupo1,profesores,puntuacion);

        parte_incidenciaDAO.crearParte(parte,idGrupo1);
        Alertas.alertaInfo("Se ha agregado el parte");
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
        rellenarHoras(listaHora);
        ObservableList<String> horas = FXCollections.observableArrayList(listaHora);
        comboBoxHora.setItems(horas);
    }

    public void rellenarHoras(ArrayList<String> horas) {
        horas.add("8:30 - 9:20");
        horas.add("9:25 - 10:15");
        horas.add("10:20 - 11:10");
        horas.add("11:40 - 12:30");
        horas.add("12:35 - 13:25");
        horas.add("13:30 - 14:20");
    }

    public void onChangeNombreGrupo(KeyEvent keyEvent) {
        numeroExpedienteAlumno = NumeroExpedienteID.getText();
        String grupo =grupoAlumno = String.valueOf(alumnosDAO.cogerGrupoAlumno(numeroExpedienteAlumno));
        String nombreGrupo = alumnosDAO.devolverNombreGrupo(grupo);
        if (nombreGrupo == null) {
            nombreGrupoId.setText("Grupo no encontrado");
        } else {
            nombreGrupoId.setText(nombreGrupo);
        }
    }
}

