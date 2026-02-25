package com.example.demojavafx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormController {
        @FXML
        private TextField txtNombre;
        @FXML
        private TextField txtCorreo;
        @FXML
        private TextField txtEdad;
        @FXML
        private Label lblResultado;
        @FXML
        private void onValidate(ActionEvent event){
            String nombre = txtNombre.getText() == null ? "" : txtNombre.getText();
            String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText();
            String edad= txtEdad.getText() == null ? "" : txtEdad.getText();

            List<String>  errores = new ArrayList<>();

            if (nombre.trim().isEmpty() || nombre.isBlank() || nombre.length() <3){
                errores.add ("el nombre es incorrecto");
            }

            if (correo.trim().isEmpty() || !correo.contains("@") || !correo.contains(".")){
                errores.add("El correo es invalido");
            }
            int edadValido = 0;
            try {
                edadValido = Integer.parseInt(edad);
                if (edadValido <= 0 || edadValido > 120){
                    System.out.println("Edad fuera de rango");
                }

            }catch (Exception e){
                System.out.println("Dato no numerico");

            }

            if (errores.isEmpty()){
                lblResultado.setText("El formulario es correcto");
                lblResultado.setStyle("-fx-text-fill: green;");
            } else {
                lblResultado.setText("Error de: " +String.join( ",", errores));
                lblResultado.setStyle("-fx-text-fill: red;");
            }
        }


}
