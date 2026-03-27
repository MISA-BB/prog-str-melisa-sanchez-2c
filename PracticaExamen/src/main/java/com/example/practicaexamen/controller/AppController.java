package com.example.practicaexamen.controller;

import com.example.practicaexamen.service.Contacto;
import javafx.fxml.FXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class AppController {


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
   @FXML
   private ComboBox<String> opc;



   @FXML
    private ListView<Contacto> list;
   private ObservableList<Contacto> listaContacto = FXCollections.observableArrayList();


   private List<Contacto>  contactos = new ArrayList<>();

   private final String[]parentesco = {
           "Padre" ,
                   "Madre" ,
                   "Hermano" ,
                   "Hermana" ,
                   "Abuelo" ,
                   "Abuela" ,
                   "Tío" ,
                   "Tía"

   };

   @FXML
    public void initialize(){

       opc.setItems(FXCollections.observableArrayList(parentesco));

       list.getSelectionModel().selectedItemProperty().addListener(
               (obs, oldValue, newValue)->{
                   String nombre = oldValue.getName();
                   String telefono = oldValue.getNumber();
                   String parentesco = oldValue.getId();
                   txtNombre.setText(nombre);
                   txtTelefono.setText(telefono);
                   opc.setValue(parentesco);

               }
       );

   }
   public void actualizarList (){
       listaContacto.setAll(contactos);
       list.setItems(listaContacto);
   }


    @FXML
    public void onAgregar() {
        String name = txtNombre.getText().trim();
        String number = txtTelefono.getText().trim();
        String parentesco = opc.getValue();

        if (name.isEmpty() || number.isEmpty() || parentesco == null) {
            new Alert(Alert.AlertType.WARNING, "Por favor, llena todos los campos.").show();
            return;
        }

        if (number.length() != 10) {
            new Alert(Alert.AlertType.ERROR, "El teléfono debe tener exactamente 10 dígitos.").show();
            return;
        }

        for (Contacto c : contactos) {
            if (c.getName().equalsIgnoreCase(name)) {
                new Alert(Alert.AlertType.ERROR, "Este nombre ya está registrado.").show();
                return;
            }
        }

        contactos.add(new Contacto(name, number, parentesco));
        actualizarList();
        onLimpiar();

        new Alert(Alert.AlertType.INFORMATION, "Contacto guardado correctamente").show();
    }

    @FXML
    public void onActualizar() {
        String name = txtNombre.getText().trim();
        String number = txtTelefono.getText().trim();
        String parentesco = opc.getValue();

        if (name.isEmpty() || number.isEmpty() || parentesco == null) {
            new Alert(Alert.AlertType.WARNING, "Faltan datos para actualizar.").show();
            return;
        }

        if (number.length() != 10) {
            new Alert(Alert.AlertType.ERROR, "El teléfono debe tener 10 dígitos.").show();
            return;
        }

        boolean encontrado = false;

        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getName().equalsIgnoreCase(name)) {
                contactos.set(i, new Contacto(name, number, parentesco));
                encontrado = true;
                actualizarList();
                break;
            }
        }

        if (encontrado) {
            new Alert(Alert.AlertType.INFORMATION, "¡Contacto actualizado con éxito!").show();
            onLimpiar();
        } else {
            new Alert(Alert.AlertType.ERROR, "No se encontró el contacto '" + name + "'.").show();
        }
    }
    @FXML
    public void onBuscar() {
        String nombreBusqueda = txtNombre.getText().trim();
        boolean encontrado = false;

        for (Contacto c : contactos) {
            if (c.getName().equalsIgnoreCase(nombreBusqueda)) {
                txtNombre.setText(c.getName());
                txtTelefono.setText(c.getNumber());
                opc.setValue(c.getId());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            // Alerta de no encontrado
            new Alert(Alert.AlertType.ERROR, "No se encontró ningún contacto con ese nombre.").show();
        }
    }

    @FXML
    public void onEliminar() {
        String nombreAEliminar = txtNombre.getText().trim();

        boolean eliminado = contactos.removeIf(c -> c.getName().equalsIgnoreCase(nombreAEliminar));

        if (eliminado) {
            actualizarList();
            onLimpiar();
            new Alert(Alert.AlertType.INFORMATION, "Contacto eliminado con éxito.").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "No se pudo eliminar: El nombre no existe.").show();
        }
    }
    @FXML
    public void onLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        opc.setValue(null);
    }

}
