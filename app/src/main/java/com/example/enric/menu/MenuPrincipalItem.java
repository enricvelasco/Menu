package com.example.enric.menu;

import android.widget.ImageView;

/**
 * Created by enric on 31/1/18.
 */

public class MenuPrincipalItem {
    String nombre;
    int imagen;

    public MenuPrincipalItem(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
