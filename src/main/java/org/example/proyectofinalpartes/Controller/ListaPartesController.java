package org.example.proyectofinalpartes.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.proyectofinalpartes.Clases.Alumnos;
import org.example.proyectofinalpartes.Clases.Grupos;
import org.example.proyectofinalpartes.Clases.Partes_incidencia;
import org.example.proyectofinalpartes.Clases.Profesores;
import org.example.proyectofinalpartes.DAO.PartesDAO;
import org.example.proyectofinalpartes.Utils.Alertas;
import org.example.proyectofinalpartes.Utils.NuevaPantalla;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListaPartesController implements Initializable {
    @FXML
    private Button buscarButton;

    @FXML
    private Button buscarFechaButton;

    @FXML
    private TableColumn<Partes_incidencia, String> descripcionTablaId;

    @FXML
    private TableColumn<Partes_incidencia, String> expedienteTablaId;

    @FXML
    private DatePicker fecha1Buscar;

    @FXML
    private DatePicker fecha2Buscar;

    @FXML
    private TableColumn<Partes_incidencia, String> fechaTablaId;

    @FXML
    private TableColumn<Partes_incidencia, String> grupoTablaId;

    @FXML
    private TableColumn<Partes_incidencia, String> nombreTablaId;

    @FXML
    private TableColumn<Partes_incidencia, Button> botonTablaId;

    @FXML
    private TextField numeroExpedienteBuscar;

    @FXML
    private TableColumn<Partes_incidencia, String> profesorTablaId;

    @FXML
    private TableColumn<Partes_incidencia, String> sancionTablaId;

    @FXML
    private TableView<Partes_incidencia> tablaId;

    PartesDAO partesDAO = new PartesDAO();

    Partes_incidencia parte = new Partes_incidencia();

    FilteredList<Partes_incidencia> filteredList;

    @FXML
    void onbuscarButtonClick(ActionEvent event) {
        if (numeroExpedienteBuscar.getText().isEmpty()){
            cargarTabla();
        }else {

            ArrayList<Partes_incidencia> listaPartesIncidencia= partesDAO.obtenerPartesPorNumero(numeroExpedienteBuscar.getText()) ;
            ObservableList<Partes_incidencia> partes = FXCollections.observableArrayList(listaPartesIncidencia);
            tablaId.setItems(partes);

        }
    }
    public void cargarTabla(){
        ArrayList<Partes_incidencia> listaPartesIncidencia = partesDAO.obtenerPartes();
        tablaId.setItems(FXCollections.observableArrayList(listaPartesIncidencia));
    }

    @FXML
    void onbuscarFechaButtonClick(ActionEvent event) {
        ArrayList<Partes_incidencia>listaPartesIncidencia = new ArrayList<>();
        if (fecha1Buscar.getValue() == null && fecha2Buscar.getValue() == null){
            Alertas.alertaError("seleccione un rango de fechas");
            cargarTabla();

        }else if(fecha2Buscar.getValue() == null) {
            LocalDate fecha1 = fecha1Buscar.getValue();
            listaPartesIncidencia = partesDAO.obtenerPartesPorFecha1(fecha1);

        }else if(fecha1Buscar.getValue() != null && fecha2Buscar.getValue() != null) {
            LocalDate fecha1 = fecha1Buscar.getValue();
            LocalDate fecha2 = fecha2Buscar.getValue();
            listaPartesIncidencia = partesDAO.obtenerPartesPorRangoFechas(fecha1, fecha2);
        }else if(fecha1Buscar.getValue()==null) {
            LocalDate fecha2 = fecha2Buscar.getValue();
            listaPartesIncidencia = partesDAO.obtenerPartesPorFecha2(fecha2);
        }
        tablaId.setItems(FXCollections.observableArrayList(listaPartesIncidencia));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        expedienteTablaId.setCellValueFactory(cellData -> {
            Alumnos alumnos = cellData.getValue().getAlumno();
            return new SimpleStringProperty(alumnos.getNumero_expediente());
        });

        nombreTablaId.setCellValueFactory(cellData -> {
            Alumnos alumnos = cellData.getValue().getAlumno();
            return new SimpleStringProperty(alumnos.getNombre_alum());
        });
        grupoTablaId.setCellValueFactory(cellData -> {
            Grupos grupos = cellData.getValue().getGrupo();
            return new SimpleStringProperty(grupos.getNombre_grupo());
        });
        profesorTablaId.setCellValueFactory(cellData ->{
            Profesores profesores = cellData.getValue().getProfesor();
            return new SimpleStringProperty(profesores.getNombre());
        });
        botonTablaId.setCellFactory(column -> new TableCell<>() {
            private final Button bt_verMas = new Button("Ver más");
            {
                bt_verMas.setStyle("-fx-background-color: #328ae8; -fx-text-fill: #eceaea;");

                bt_verMas.setOnAction(event -> {
                    parte = getTableView().getItems().get(getIndex());
                    abrirParte(parte);
                });
            }
            @Override
            protected void updateItem(Button item, boolean empty){
                super.updateItem(item, empty);

                if (empty){
                    setGraphic(null); //Si la celda es null no asigna el boton
                }else{
                    setGraphic(bt_verMas); //Si exeiste le asigna el boton
                }
            }
        });



        fechaTablaId.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        descripcionTablaId.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        sancionTablaId.setCellValueFactory(new PropertyValueFactory<>("sancion"));

        ArrayList<Partes_incidencia> listaPartesIncidencia = partesDAO.obtenerPartes();
        ObservableList<Partes_incidencia> parteIncidenciasObservable = FXCollections.observableArrayList(listaPartesIncidencia);
        tablaId.setItems(parteIncidenciasObservable);

        filteredList = new FilteredList<>(parteIncidenciasObservable, alumno -> true);
        tablaId.setItems(filteredList);
        //configurarPaginacion(filteredList);

    }
    public void abrirParte(Partes_incidencia parte) {
        NuevaPantalla.nuevaPantalla("crearParteVerde.fxml", "Parte verde");
    }
}
