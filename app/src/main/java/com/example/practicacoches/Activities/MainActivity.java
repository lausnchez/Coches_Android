package com.example.practicacoches.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicacoches.Model.CochesModelo;
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
        Button btn_main_buscar = findViewById(R.id.btn_buscar);
        Button btn_main_actualizar = findViewById(R.id.btn_actualizar);
        Button btn_main_mostrarTodos = findViewById(R.id.btn_mostrarTodos);
        EditText eT_main_insertarMatricula = findViewById(R.id.et_main_inserteMatricula);

        // Listeners
        //------------------------------------------------------------------------------------------

        // AGREGAR
        btn_main_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Agregar", Toast.LENGTH_LONG).show();
                Intent i_agregar = new Intent(MainActivity.this, AgregarEditarActivity.class);
                startActivity(i_agregar);
            }
        });

        // ELIMINAR
        btn_main_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this, "Eliminar", Toast.LENGTH_LONG).show();
                Intent i_eliminar = new Intent(MainActivity.this, AgregarEditarActivity.class);
                i_eliminar.putExtra("matricula", eT_main_insertarMatricula.getText().toString());
                startActivity(i_eliminar);
            }
        });

        // BUSCAR
        btn_main_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Buscar", Toast.LENGTH_LONG).show();
                Intent i_buscar = new Intent(MainActivity.this, BuscarActivity.class);
                i_buscar.putExtra("matricula" , eT_main_insertarMatricula.getText().toString());
                startActivity(i_buscar);
            }
        });

        // ACTUALIZAR
        btn_main_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this, "Actualizar", Toast.LENGTH_LONG).show();
                Intent i_actualizar = new Intent(MainActivity.this, AgregarEditarActivity.class);
                i_actualizar.putExtra("matricula", eT_main_insertarMatricula.getText().toString());
                startActivity(i_actualizar);
            }
        });

        // MOSTRAR TODOS
        btn_main_mostrarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i_mostrar = new Intent(MainActivity.this, AgregarEditarActivity.class);

            }
        });

        // Manejo de datos
        CochesModelo listadoCoches = new CochesModelo();

    }
}