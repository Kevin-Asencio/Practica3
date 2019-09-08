package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import static com.example.practica3.MainActivity.ListNombres;
public class Activity_Agregar extends AppCompatActivity {
    private     EditText    edtNombre;
    private     Button      btnProcesar;
    private     ProgressBar pBar;
    private     int         mProgressStatus;
    Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__agregar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("Agrgar un Elemento");
        }
        setTitle("Agregar un Nombre");
        this.edtNombre      =findViewById(R.id.edtNombre);
        this.btnProcesar    =findViewById(R.id.btnProcesar);
        this.pBar           =findViewById(R.id.Pbar);
        this.mProgressStatus = 0;
        this.mHandler       = new Handler();
        this.btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(edtNombre.getText().toString().isEmpty()){
                   Toast.makeText(Activity_Agregar.this, "El Campo Nombre no puede Quedar Vacio!", Toast.LENGTH_SHORT).show();
               }else{
                   new Thread(new Runnable() {
                       @Override
                       public void run() {
                           while (mProgressStatus < 100){
                               mProgressStatus++;
                               SystemClock.sleep(50);
                               mHandler.post(new Runnable() {
                                   @Override
                                   public void run() {
                                       pBar.setProgress(mProgressStatus);
                                   }
                               });
                           }
                           mHandler.post(new Runnable() {
                               @Override
                               public void run() {
                                   if(edtNombre.getTextSize()>0){
                                       ListNombres.add(edtNombre.getText().toString());
                                       finish();
                                   }else{
                                       Toast.makeText(Activity_Agregar.this, "Ingrese un Nombre", Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });
                       }
                   }).start();
               }
            }
        });
    }
}
