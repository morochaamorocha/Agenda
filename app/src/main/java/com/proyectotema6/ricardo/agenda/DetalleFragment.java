package com.proyectotema6.ricardo.agenda;


import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment implements View.OnClickListener {

    public static final String CONTACTO_ID = "contacto_id";

    private Contacto contacto;
    private Button btnImagen;
    private EditText txtNombre, txtApellido, txtTelefono, txtCorreo;

    public DetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID idContacto = (UUID)getActivity().getIntent().getSerializableExtra(CONTACTO_ID);
        contacto = ListaContactos.get(getActivity()).getContacto(idContacto);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        btnImagen = (Button)view.findViewById(R.id.img_contacto1);
        btnImagen.setOnClickListener(this);
        txtNombre = (EditText)view.findViewById(R.id.txt_nombre);
        txtApellido = (EditText)view.findViewById(R.id.txt_apellido);
        txtTelefono = (EditText)view.findViewById(R.id.txt_telefono);
        txtCorreo = (EditText)view.findViewById(R.id.txt_correo);

        txtCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                contacto.setNombre(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contacto.setApellido(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contacto.setTelefono(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contacto.setCorreo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_contacto1:

        }
    }

    public static DetalleFragment newInstance(UUID idContacto){
        Bundle args = new Bundle();
        args.putSerializable(CONTACTO_ID, idContacto);

        DetalleFragment fragment = new DetalleFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
