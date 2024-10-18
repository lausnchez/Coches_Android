package com.example.practicacoches.Activities;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicacoches.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Creamos los elementos
        //------------------------------------------------------------------------------------------
        Button btn_main_agregar = findViewById(R.id.btn_agregar);
        Button btn_main_eliminar = findViewById(R.id.btn_eliminar);
        Button btn_main_leer = findViewById(R.id.btn_leer);
        Button btn_main_actualizar = findViewById(R.id.btn_actualizar);
        EditText eT_main_insertarMatricula = findViewById(R.id.et_main_inserteMatricula);

        // Listeners
        //------------------------------------------------------------------------------------------

        // AGREGAR
        btn_main_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "Agregar", Toast.LENGTH_LONG).show();
                Intent i_agregar = new Intent(MainActivity.this, AgregarEditarActivity.class);
                startActivity(i_agregar);
            }
        });

        // ELIMINAR
        btn_main_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Eliminar", Toast.LENGTH_LONG).show();

            }
        });

        // LEER
        btn_main_leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Leer", Toast.LENGTH_LONG).show();

            }
        });

        // ACTUALIZAR
        btn_main_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Actualizar", Toast.LENGTH_LONG).show();

            }
        });
    }
}