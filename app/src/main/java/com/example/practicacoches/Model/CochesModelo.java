package com.example.practicacoches.Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class CochesModelo {
    private HashMap<String, Coche> lista_coches;
    private static CochesModelo instancia;
    
    public CochesModelo(){
        this.lista_coches = new HashMap<>();
        this.lista_coches.put("1111BCD", new Coche("1111BCD", "Toyota Corolla", "Rojo", 2020, 22000));
        this.lista_coches.put("2222FRT", new Coche("2222FRT", "Honda Civic", "Azul", 1990, 19323));
        this.lista_coches.put("1345DDY", new Coche("1345DDY", "Chevrolet Cruze", "Negro", 2013, 13212));
        this.lista_coches.put("5123CCM", new Coche("5123CCM", "Honda Civic", "Blanco", 2014, 14567));
        this.lista_coches.put("7653BCT", new Coche("7653BCT", "Nissan Sentra", "Gris", 2018, 23123));
        this.lista_coches.put("2423FCD", new Coche("2423FCD", "Ford Focus", "Blanco", 2001, 21123));
        instancia = this;
    }
    
    public Coche agregarCoche(Coche coche_agregar){
        if (!this.lista_coches.containsKey(coche_agregar.getMatricula())){
            this.lista_coches.put(coche_agregar.getMatricula(), coche_agregar);
            return coche_agregar;
        }
        return null;
    }
    
    public HashMap<String, Coche> getListaCoches(){
        return this.lista_coches;
    }

    // Getter Instancia
    public static CochesModelo getInstancia(){
        if(instancia == null){
            instancia = new CochesModelo();
        }
        return instancia;
    }
    
    public Coche buscarMatricula(String matricula){
        return this.lista_coches.get(matricula);
    }
    
    public Coche eliminaCoche(String matricula){
        return this.lista_coches.remove(matricula);
    }
    
    
    public boolean serializar(String nombre){
        try {
            FileOutputStream fos = new FileOutputStream(nombre);
            ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(fos);
            escribiendo_fichero.writeObject(this.lista_coches);
            escribiendo_fichero.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    public boolean deserializar(String nombre){
        try {
            ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream(nombre));
            this.lista_coches = (HashMap<String, Coche>) recuperando_fichero.readObject();
            recuperando_fichero.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
