package com.example.enric.menu.MenuPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by enric on 5/2/18.
 */

public interface MenuPrincipalConectionInterface {
    String query = "?query=[]";
    @GET("ciudades/"+query)
    Call<List<MenuPrincipalItem>> getMenusPrincipales();
}
