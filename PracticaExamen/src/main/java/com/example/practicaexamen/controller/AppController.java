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

   private ObservableList<Contacto> listaParentesco= FXCollections.observableArrayList();
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
    public void onAgregar(){
       System.out.println("holaaa");
       String name  = txtNombre.getText().trim();
       String number = txtTelefono.getText().trim();
       String id = opc.getValue();

       contactos.add(new Contacto(name, number,id));
       listaContacto.setAll(contactos);
       list.setItems(listaContacto);
       System.out.println(contactos);

   }


   @FXML
    public void onActualizar (){
       String name  = txtNombre.getText().trim();
       String number = txtTelefono.getText().trim();
       String id = opc.getValue();
       boolean encontrado = false;
       for (int i = 0; i < contactos.size(); i++) {
           if (contactos.get(i).getName().equalsIgnoreCase(name)) {

               contactos.set(i, new Contacto(name, number, id));
               encontrado = true;
               break;
           }
       }
       if (encontrado) {
           actualizarList();
           System.out.println("¡Contacto actualizado!");
       } else {
           System.out.println("Error: No se encontró un contacto con ese nombre.");
       }


   }

    @FXML
    public void onBuscar() {
        String nombreBusqueda = txtNombre.getText().trim();

        if (nombreBusqueda.isEmpty()) {
            System.out.println("Escribe un nombre para buscar.");
            return;
        }

        boolean encontrado = false;

        for (Contacto c : contactos) {
            if (c.getName().equalsIgnoreCase(nombreBusqueda)) {


                txtNombre.setText(c.getName());
                txtTelefono.setText(c.getNumber());
                opc.setValue(c.getId());

                encontrado = true;
                System.out.println("Contacto encontrado.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Error: El contacto '" + nombreBusqueda + "' no existe.");
            txtTelefono.clear();
            opc.setValue(null);
        }
    }

    @FXML
    public void onEliminar() {
        String nombreAEliminar = txtNombre.getText().trim();

        if (nombreAEliminar.isEmpty()) {
            System.out.println("Error: Escribe el nombre del contacto a eliminar.");
            return;
        }

        boolean eliminado = contactos.removeIf(contacto ->
                contacto.getName().equalsIgnoreCase(nombreAEliminar)
        );

        if (eliminado) {
            actualizarList();
            onLimpiar();
            System.out.println("Contacto '" + nombreAEliminar + "' eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró ningún contacto con ese nombre.");
        }
    }

    @FXML
    public void onLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        opc.setValue(null);
    }

}
