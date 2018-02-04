package com.example.enric.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.enric.menu.adapter.ImageAdapter;

import java.util.ArrayList;

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
        ArrayList<MenuPrincipalItem> books = new ArrayList<MenuPrincipalItem>();
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
}
