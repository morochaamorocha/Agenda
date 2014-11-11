package com.proyectotema6.ricardo.agenda;

import android.app.Fragment;

/**
 * Created by rals1_000 on 08/11/2014.
 */
public class ListContactosActivity extends MiFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ContactoListaFragment();
    }
}
