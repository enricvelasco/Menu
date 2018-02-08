package com.example.enric.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.enric.menu.MenuPrincipal.MenuPrincipalAdapter.ImageAdapter;
import com.example.enric.menu.MenuPrincipal.MenuPrincipalConectionInterface;
import com.example.enric.menu.MenuPrincipal.MenuPrincipalItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    static final String[] MOBILE_OS = new String[] { "Android", "iOS",
            "Windows", "Blackberry" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tamaño de la pantalla
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels; // ancho absoluto en pixels
        int height = metrics.heightPixels; // alto absoluto en pixels
        int densityDpi = metrics.densityDpi;
        float xdpi = metrics.xdpi;
        float ydpi = metrics.ydpi;

        float densidadHorizontal = (width*160)/densityDpi;
        float densidadVertical = (height*160)/densityDpi;

        System.out.println("HORIZONTAL1 PIXELS-"+width);
        System.out.println("VERTICAL2 PIXELS-"+height);
        System.out.println("HORIZONTAL1-"+xdpi);
        System.out.println("HORIZONTAL2-"+densidadHorizontal);
        System.out.println("VERTICAL1-"+ydpi);
        System.out.println("VERTICAL1-"+densidadVertical);


        //MenuPrincipalItem[] books = new ArrayList;
        final ArrayList<MenuPrincipalItem> books = new ArrayList<MenuPrincipalItem>();
        MenuPrincipalItem b1 = new MenuPrincipalItem("POS", "#B8ECD6");
        b1.setTamanoHorizontal(width/2);
        b1.setImagen(R.drawable.menu_pos_cash_register);
        books.add(b1);
        MenuPrincipalItem b2 = new MenuPrincipalItem("Order", "#B0CC99");
        b2.setTamanoHorizontal(width/2);
        b2.setImagen(R.drawable.menu_order_camarero);
        books.add(b2);
        MenuPrincipalItem b3 = new MenuPrincipalItem("Kitchen","#292929");
        b3.setTamanoHorizontal(width/2);
        b3.setImagen(R.drawable.menu_kitchen_cocina);
        books.add(b3);
        MenuPrincipalItem b4 = new MenuPrincipalItem("Stock", "#594F4E");
        b4.setTamanoHorizontal(width/2);
        b4.setImagen(R.drawable.menu_stock_hangar);
        b4.setNombreActivity("StockActivity");
        books.add(b4);
        MenuPrincipalItem b5 = new MenuPrincipalItem("Elaborator", "#B9121A");
        b5.setTamanoHorizontal(width/2);
        b5.setImagen(R.drawable.menu_elaborator_ingredientes);
        books.add(b5);
        MenuPrincipalItem b6 = new MenuPrincipalItem("Managment","#F7F2B2");
        b6.setTamanoHorizontal(width/2);
        b6.setImagen(R.drawable.menu_managment);
        books.add(b6);

        gridView = (GridView) findViewById(R.id.gridView1);

        ImageAdapter booksAdapter = new ImageAdapter(this, books);
        gridView.setAdapter(booksAdapter);
        gridView.setColumnWidth(width/2);

        //gridView.setAdapter(new ImageAdapter(this, MOBILE_OS));

        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.grid_item_label))
                                .getText(), Toast.LENGTH_SHORT).show();

            }
        });*/
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String val = values[i]; // arg2 is the index of item
                MenuPrincipalItem valor = books.get(i);
                System.out.println("He clicado sobre: "+valor.getNombre());
                Class ourClass  = null;
                try {
                    ourClass = Class.forName("com.example.enric.menu.activities."+valor.getNombre().toLowerCase()+"."+valor.getNombreActivity());
                    Intent intent = new Intent(MainActivity.this, ourClass);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("NO HAY ACTIVITY ASIGNADO PARA ESTE MENU: "+valor.getNombre());
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void connectionServer(){
        System.out.println("DETECTA EL CLICK");
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.102:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        MenuPrincipalConectionInterface gerritAPI = retrofit.create(MenuPrincipalConectionInterface.class);
        Call<List<MenuPrincipalItem>> call = gerritAPI.getMenusPrincipales();
        call.enqueue(new Callback<List<MenuPrincipalItem>>() {
            @Override
            public void onResponse(Call<List<MenuPrincipalItem>> call, Response<List<MenuPrincipalItem>> response) {
                        /*final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());*/
                //final TextView textView = (TextView) findViewById(R.id.textView);
                if(response.isSuccessful()) {
                    List<MenuPrincipalItem> menusPrincipales = response.body();
                    System.out.println("RESPONSE 1"+response.body());
                    for (MenuPrincipalItem temp : menusPrincipales) {
                        System.out.println("MENU NOMBRE: "+temp.getNombre());
                    }
                    String json = new Gson().toJson(menusPrincipales);
                    System.out.println("RESULTADO MENUS: "+json);
                    //textView.setText(json);

                    //changesList.forEach(change -> System.out.println(change.subject));
                } else {
                    System.out.println("RESPONSE 2");
                    System.out.println(response.errorBody());
                    System.out.println(response);
                }

            }
            @Override
            public void onFailure(Call<List<MenuPrincipalItem>> call, Throwable t) {
                //final TextView textView = (TextView) findViewById(R.id.textView);
                System.out.println("Something went wrong: " + t.getMessage());
                //textView.setText("Something went wrong: " + t.getMessage());
            }
        });
    }
}
