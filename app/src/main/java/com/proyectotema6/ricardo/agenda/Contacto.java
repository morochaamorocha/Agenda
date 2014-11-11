package com.proyectotema6.ricardo.agenda;

import android.graphics.Bitmap;

import java.util.UUID;

/**
 * Created by rals1_000 on 04/11/2014.
 */
public class Contacto {

    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private Bitmap imgContacto;
    private UUID idContacto;

    public Contacto() {
        this.idContacto = UUID.randomUUID();
    }

    public Contacto(String nombre, String apellido, String telefono, String correo) {
        this.idContacto = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Contacto(String nombre, String apellido, String telefono, String correo, Bitmap imgContacto) {
        this.idContacto = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.imgContacto = imgContacto;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public UUID getIdContacto() {
        return idContacto;
    }

    public Bitmap getImgContacto() {
        return imgContacto;
    }

    public void setImgContacto(Bitmap imgContacto) {
        this.imgContacto = imgContacto;
    }
}
