package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private Intent i;
    private Button btnVer;
    private Button btnAgregar;
    private Button btnDatos;
    String aux;
    static public ArrayList<String> ListNombres;
    //obtener el Bundle con los EXTRA que agregue al Intent Implicito
    Bundle Nuevo;
    static final String ACTION_VERD = "com.example.practica3.action.VERD";

    static final String ACTION_VER = "com.example.practica3.action.VER";
    static final String ACTION_ADDNAME = "com.example.practica3.action.ADDNAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Prcatica 3");
        ListNombres =new ArrayList<String>();
        this.btnVer=        findViewById(R.id.btnVer);
        this.btnAgregar=    findViewById(R.id.btnAgregar);
        this.btnDatos=      findViewById(R.id.btnDatos);
        this.btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prueba=new Intent();
                prueba.setAction(ACTION_VERD);
                startActivity(prueba);
            }
        });
        this.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ListNombres.size()>0)
                {
                    Intent intent=new Intent();
                    intent.setAction(ACTION_VER);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "No se a regitrado ningun nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(ACTION_ADDNAME);
                startActivity(intent);

            }
        });
    }
    void nose()
    {
        i = new Intent(Intent.ACTION_SEND);

        String title = getResources().getString(R.string.chooser_title);

        Intent chooser = Intent.createChooser(i, title);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

    }

    //en este metodo recivo el nombre nuevo a agregar que es psado por  un Bundle a traves de un intent implicito
    /*protected void onResume(){
        super.onResume();
        Nuevo=getIntent().getExtras();
        if(Nuevo !=null){
            this.ListNombres.add(Nuevo.getString("com.example.practica3.Nuevo"));
        }

    }*/
}
