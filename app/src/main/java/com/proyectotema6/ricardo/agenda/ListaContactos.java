package com.proyectotema6.ricardo.agenda;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by rals1_000 on 06/11/2014.
 */
public class ListaContactos {

    private ArrayList<Contacto> contactos;

    private static ListaContactos listaContactos;
    private Context context;

    private ListaContactos(Context context){
        this.context = context;
        contactos = new ArrayList<Contacto>();
        for (int i = 0;i < 100; i++){
            Contacto contacto = new Contacto();
            contacto.setNombre("Nombre Contacto #" + i);
            contacto.setApellido("Apellido Contacto #" + i);
            contacto.setTelefono("Telefono Contacto #" + i);
            contacto.setCorreo("Correo Contacto #" + i);
            contactos.add(contacto);
        }
    }

    public static ListaContactos get(Context context){
        if (listaContactos == null){
            listaContactos = new ListaContactos(context.getApplicationContext());
        }
        return listaContactos;
    }

    public ArrayList<Contacto> getContactos(){
        return contactos;
    }

    public Contacto getContacto(UUID idContacto){
        for (Contacto c : contactos){
            if (c.getIdContacto().equals(idContacto)){
                return c;
            }
        }
        return null;
    }
}
