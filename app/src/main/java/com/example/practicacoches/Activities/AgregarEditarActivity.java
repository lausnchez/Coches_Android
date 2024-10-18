package com.example.practicacoches.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicacoches.R;

public class AgregarEditarActivity extends AppCompatActivity{

    // Creamos los elementos de la pantalla
    //------------------------------------------------------------------------------------------
    Button btn_act_agregar = findViewById(R.id.btn_act_agregarEditar);
    EditText et_act_matricula = findViewById(R.id.eT_act_matricula);
    EditText et_act_modelo = findViewById(R.id.et_act_modelo);
    EditText et_act_color = findViewById(R.id.et_act_color);
    EditText et_act_anio = findViewById(R.id.et_act_anio);
    EditText et_act_precio = findViewById(R.id.et_act_precio);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_editar);

        // OnClickListener
        //------------------------------------------------------------------------------------------
        btn_act_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AgregarEditarActivity.this, MainActivity.class);
                // Comprobamos que todos los campos están llenos
                if(comprobacionDeDatos()){
                    int anioInt = Integer.parseInt(et_act_anio.toString());
                    int precioInt = Integer.parseInt(et_act_precio.toString());
                }
                //getOnBackPressedDispatcher().onBackPressed();
                finish();
            }
        });
    }

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