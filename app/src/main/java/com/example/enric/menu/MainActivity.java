package com.example.enric.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


        //MenuPrincipalItem[] books = new ArrayList;
        ArrayList<MenuPrincipalItem> books = new ArrayList<MenuPrincipalItem>();
        MenuPrincipalItem b1 = new MenuPrincipalItem("b1", R.drawable.ic_add_circle_black_48dp);
        books.add(b1);
        MenuPrincipalItem b2 = new MenuPrincipalItem("b1", R.drawable.icons8_advertisement_page);
        books.add(b2);

        gridView = (GridView) findViewById(R.id.gridView1);

        ImageAdapter booksAdapter = new ImageAdapter(this, books);
        gridView.setAdapter(booksAdapter);

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
