package Modelo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMSUNG E1
 */
public class Cantante {
    String nombre;
    String album;
    Integer nCanciones;

    public Cantante() {
    }   

    public Cantante(String nombre, String album, Integer nCanciones) {
        this.nombre = nombre;
        this.album = album;
        this.nCanciones = nCanciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getnCanciones() {
        return nCanciones;
    }

    public void setnCanciones(Integer nCanciones) {
        this.nCanciones = nCanciones;
    }
    
    
}
