package com.example.enric.menu.MenuPrincipal;

import java.util.ArrayList;

/**
 * Created by enric on 31/1/18.
 */

public class MenuPrincipalItem {
    private String nombre;
    private int imagen;
    private String color;
    private String nombreActivity;

    private int tamanoHorizontal;

    private ArrayList<MenuPrincipalItem> submenus = new ArrayList<>();


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

    public ArrayList<MenuPrincipalItem> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(ArrayList<MenuPrincipalItem> submenus) {
        this.submenus = submenus;
    }

    public String getNombreActivity() {
        return nombreActivity;
    }

    public void setNombreActivity(String nombreActivity) {
        this.nombreActivity = nombreActivity;
    }
}
