package com.example.enric.menu;

import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by enric on 31/1/18.
 */

public class MenuPrincipalItem {
    String nombre;
    int imagen;
    String color;

    int tamanoHorizontal;

    public MenuPrincipalItem(String nombre, String color) {
        this.nombre = nombre;
        //this.imagen = imagen;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamanoHorizontal() {
        return tamanoHorizontal;
    }

    public void setTamanoHorizontal(int tamanoHorizontal) {
        this.tamanoHorizontal = tamanoHorizontal;
    }
}
