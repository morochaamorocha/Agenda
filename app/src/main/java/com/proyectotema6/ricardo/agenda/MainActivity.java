package com.proyectotema6.ricardo.agenda;


import android.app.Fragment;
import java.util.UUID;


public class MainActivity extends MiFragmentActivity{


    @Override
    protected Fragment createFragment() {

        UUID idContacto = (UUID)getIntent().getSerializableExtra(DetalleFragment.CONTACTO_ID);
        return new DetalleFragment().newInstance(idContacto);
    }
}
