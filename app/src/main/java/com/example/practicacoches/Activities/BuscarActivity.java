package com.example.practicacoches.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicacoches.R;

public class BuscarActivity extends AppCompatActivity {

    // ELEMENTOS DE LA PANTALLA
    Button boton = findViewById(R.id.btn_bus_volver);
    TextView matricula = findViewById(R.id.lbl_bus_resMat);
    TextView modelo = findViewById(R.id.lbl_bus_resMod);
    TextView color = findViewById(R.id.lbl_bus_resCol);
    TextView anio = findViewById(R.id.lbl_bus_resAni);
    TextView precio = findViewById(R.id.lbl_bus_resPre);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscar);


    }
}