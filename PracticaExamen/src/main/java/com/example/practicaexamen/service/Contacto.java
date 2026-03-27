package com.example.practicaexamen.service;

public class Contacto {


    private String name;
    private String number;
    private String id;

    public Contacto (String name, String number, String id){
        this.name = name;
        this.number = number;
        this.id = id;


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName (){
        return name;
    }
    public String getNumber (){
        return number;
    }
    public String getId (){
        return id;
    }


    @Override
    public String toString() {
        return String.format("%-15s | %-10s | %s", name, number, id);
    }



}


