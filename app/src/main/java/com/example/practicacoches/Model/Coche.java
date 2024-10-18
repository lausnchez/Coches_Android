package com.example.practicacoches.Model;

import java.io.Serializable;

/**
 *
 * @author Trabajo
 */
public class Coche implements Serializable{
    private String matricula, modelo, color; 
    private int ano_fabricacion, precio;

    public Coche(String matricula, String modelo, String color, int ano_fabricacion, int precio) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.ano_fabricacion = ano_fabricacion;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnoFabricacion() {
        return ano_fabricacion;
    }

    public void setAno_fabricacion(int ano_fabricacion) {
        this.ano_fabricacion = ano_fabricacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }  
}
