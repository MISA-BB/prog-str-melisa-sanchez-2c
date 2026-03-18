package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result= new ArrayList<>();
        for(String line : lines){
            if(line==null || line.isBlank()) continue;

            String[] parts= line.split(",");
            String name=parts[0];
            String email=parts[1];
            String edad=parts[2];
            result.add(name+"-"+email+"-"+edad);
        }
        return result;
    }

        public void updatePerson(int index, String nombre, String email, String age) throws IOException {
        validate(nombre, email, age);
        List<String> listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLines.add(line); // esta linea es buena, ya que no es null y no esta en blanco

            }
        }
        cleanLines.set(index,nombre+","+email+","+age);
        repo.savefile(cleanLines); // sustituir la informacion en el archivo actualizada


        }
    public void deletePerson(int index) throws IOException {

        List<String> listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLines.add(line);

            }
        }
        cleanLines.remove(index);
        repo.savefile(cleanLines); // sustituir la informacion en el archivo actualizada


    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name,email,edad);
        repo.addNewLine(name+","+email+","+edad);
    }


    private void validate(String name, String email, String edad){
        if (name== null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("el nombre es incorrecto");
        }
        String em =(email==null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("el email es invalido");
        }

        try{
            int newNumber = Integer.parseInt(edad);//exp
            if ( newNumber < 18){
                throw new IllegalArgumentException("tiene que ser mayor de edad para el registro");
            }
            if ( newNumber < 0){
                throw new IllegalArgumentException("numero invalido");
            }
        } catch (NumberFormatException e) { //correjido bro
            throw new IllegalArgumentException("datos invalidos ");
        }
    }
}
