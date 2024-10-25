package com.example.practicacoches.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicacoches.Model.Coche;
import com.example.practicacoches.Model.CochesModelo;
import com.example.practicacoches.R;

public class AgregarEditarActivity extends AppCompatActivity{

    // Creamos los elementos de la pantalla
    //------------------------------------------------------------------------------------------
    Button btn_act_agregar;
    EditText et_act_matricula;
    EditText et_act_modelo;
    EditText et_act_color;
    EditText et_act_anio;
    EditText et_act_precio;

    boolean editar;
    String matricula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_editar);

        // Valores del intent
        Intent intent = getIntent();
        matricula = intent.getExtras().getString("matricula");
        editar = intent.getExtras().getBoolean("editar");

        btn_act_agregar = findViewById(R.id.btn_act_agregarEditar);
        et_act_modelo = findViewById(R.id.et_act_modelo);
        et_act_matricula = findViewById(R.id.eT_act_matricula);
        et_act_color = findViewById(R.id.et_act_color);
        et_act_anio = findViewById(R.id.et_act_anio);
        et_act_precio = findViewById(R.id.et_act_precio);


        // Ajustes de la pantalla de editar
        if(editar){
            et_act_matricula.setText(matricula);
            et_act_modelo.setText(CochesModelo.getInstancia().buscarMatricula(matricula).getModelo());
            et_act_color.setText(CochesModelo.getInstancia().buscarMatricula(matricula).getColor());
            et_act_anio.setText(String.valueOf(CochesModelo.getInstancia().buscarMatricula(matricula).getAnoFabricacion()));
            et_act_precio.setText(String.valueOf(CochesModelo.getInstancia().buscarMatricula(matricula).getPrecio()));
            et_act_matricula.setFocusable(false);
        }

        // OnClickListener
        //------------------------------------------------------------------------------------------
        btn_act_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // PANTALLA DE ACTUALIZAR ----------------------------------------------------------
                if(editar){
                            // Intent i = new Intent(AgregarEditarActivity.this, MainActivity.class);
                    // Comprobamos que todos los campos están llenos
                    if(comprobacionDeDatos()){
                        String matricula = et_act_matricula.getText().toString();
                        String modelo = et_act_matricula.getText().toString();
                        String color = et_act_color.getText().toString();
                        String anio = et_act_anio.getText().toString();
                        String precio = et_act_precio.getText().toString();
                        // Según el método si no nos ha editado un coche nos devolverá un false
                        if(CochesModelo.getInstancia().editarCoche(matricula,modelo,color,Integer.parseInt(anio), Integer.parseInt(precio))){
                            Toast.makeText(AgregarEditarActivity.this, "Coche editado con éxito", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AgregarEditarActivity.this, "No se pudo editar el coche", Toast.LENGTH_SHORT).show();
                        }
                        //getOnBackPressedDispatcher().onBackPressed();
                        finish();
                    } else Toast.makeText(AgregarEditarActivity.this, "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();
                }
                // PANTALLA DE AGREGAR -------------------------------------------------------------
                else{
                            // Intent i = new Intent(AgregarEditarActivity.this, MainActivity.class);
                    // Comprobamos que todos los campos están llenos
                    if(comprobacionDeDatos()){
                        String matricula = et_act_matricula.getText().toString();
                        String modelo = et_act_matricula.getText().toString();
                        String color = et_act_color.getText().toString();
                        String anio = et_act_anio.getText().toString();
                        String precio = et_act_precio.getText().toString();
                        // Según el método si no nos ha agregado un coche nos devolverá un null
                        if(CochesModelo.getInstancia().agregarCoche(new Coche(matricula, modelo, color, Integer.parseInt(anio), Integer.parseInt(precio))) == null){
                            Toast.makeText(AgregarEditarActivity.this, "No se pudo agregar el coche", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AgregarEditarActivity.this, "Coche agregado con éxito", Toast.LENGTH_SHORT).show();
                            //getOnBackPressedDispatcher().onBackPressed();
                            finish();
                        }
                    } else Toast.makeText(AgregarEditarActivity.this, "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Comprobar si los datos están vacíos
    private boolean comprobacionDeDatos(){
        // Comprobamos que todos los datos están completos
        if(et_act_matricula.getText().toString().isEmpty() ||
            et_act_modelo.getText().toString().isEmpty() ||
            et_act_color.getText().toString().isEmpty() ||
            et_act_anio.getText().toString().isEmpty() ||
            et_act_precio.getText().toString().isEmpty()
        ){
            Toast.makeText(AgregarEditarActivity.this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
}