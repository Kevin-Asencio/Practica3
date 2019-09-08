package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import static  com.example.practica3.MainActivity.ListNombres;
public class List_Activity extends AppCompatActivity {

    private ArrayAdapter<String> dapter;
    ListView lstNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle("Lista de Nombres");
        }

        this.lstNombres=findViewById(R.id.lstNombres);


        dapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListNombres);
        dapter.setNotifyOnChange(true);
        lstNombres.setAdapter(dapter);

    }
}
