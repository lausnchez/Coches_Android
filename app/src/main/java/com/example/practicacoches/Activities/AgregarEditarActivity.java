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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_editar);


        btn_act_agregar = findViewById(R.id.btn_act_agregarEditar);
        et_act_modelo = findViewById(R.id.et_act_modelo);
        et_act_matricula = findViewById(R.id.eT_act_matricula);
        et_act_color = findViewById(R.id.et_act_color);
        et_act_anio = findViewById(R.id.et_act_anio);
        et_act_precio = findViewById(R.id.et_act_precio);
        // OnClickListener
        //------------------------------------------------------------------------------------------
        btn_act_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AgregarEditarActivity.this, MainActivity.class);
                // Comprobamos que todos los campos están llenos
                if(comprobacionDeDatos()){
                    String matricula = et_act_matricula.getText().toString();
                    String modelo = et_act_matricula.getText().toString();
                    String color = et_act_color.getText().toString();
                    int anioInt = Integer.parseInt(et_act_anio.toString());
                    int precioInt = Integer.parseInt(et_act_precio.toString());
                    // Según el método si no nos ha agregado un coche nos devolverá un null
                    if(CochesModelo.getInstancia().agregarCoche(new Coche(matricula, modelo, color, anioInt, precioInt)) == null){
                        Toast.makeText(AgregarEditarActivity.this, "No se pudo agregar el coche", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AgregarEditarActivity.this, "Coche agregado con éxito", Toast.LENGTH_SHORT).show();
                    }
                }
                //getOnBackPressedDispatcher().onBackPressed();
                finish();
            }
        });
    }

    // Comprobar si los datos están vacíos
    private boolean comprobacionDeDatos(){
        // Comprobamos que todos los datos están completos
        if(et_act_matricula.toString().isEmpty() ||
                et_act_modelo.toString().isEmpty() ||
                et_act_color.toString().isEmpty() ||
                et_act_anio.toString().isEmpty() ||
                et_act_precio.toString().isEmpty()
        ){
            return true;
        }
        return false;
    }
}