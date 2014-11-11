package com.proyectotema6.ricardo.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;


public class ContactoListaFragment extends ListFragment {


    private static final int  CONTACTO_REQUEST = 1;
    private ArrayList<Contacto> contactos;

    public ContactoListaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.lista_name);
        contactos = ListaContactos.get(getActivity()).getContactos();

        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos);
        setListAdapter(contactoAdapter);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onResume() {
        super.onResume();
        ((ContactoAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Contacto c = ((ContactoAdapter)getListAdapter()).getItem(position);

        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra(DetalleFragment.CONTACTO_ID, c.getIdContacto());
        startActivityForResult(intent, CONTACTO_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CONTACTO_REQUEST){
            //Se maneja la información recibida
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_contacto, container, false);
        return view;
    }

    private class ContactoAdapter extends ArrayAdapter<Contacto>{

    public ContactoAdapter(ArrayList<Contacto> contactos) {
        super(getActivity(), 0, contactos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = getActivity().getLayoutInflater().inflate(R.layout.lista_contacto, null);
        }

        Contacto c = getItem(position);

        ImageView imgContacto = (ImageView)convertView.findViewById(R.id.img_contacto1);
        TextView lblNombre = (TextView)convertView.findViewById(R.id.txt_nombre1);
        TextView lblNumero = (TextView)convertView.findViewById(R.id.txt_numero1);

        imgContacto.setImageBitmap(c.getImgContacto());
        lblNombre.setText(c.getApellido() +", "+ c.getNombre());
        lblNumero.setText(c.getTelefono());

        return convertView;
    }
}

}
