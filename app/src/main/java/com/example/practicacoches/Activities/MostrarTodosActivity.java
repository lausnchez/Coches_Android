package com.example.practicacoches.Activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.practicacoches.R;

public class MostrarTodosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_todos);

        // Creamos la recyclerView con el mismo nombre que le hemos puesto en el xml
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Controla como se organizan los elementos de la pantalla
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);           // Muestra los elementos en una lista
        //GridLayoutManager layoutManager = new GridLayoutManager(this);                    // Muestra los elementos en una cuadricula
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(this);  // Muestra los elementos en galería
        recyclerView.setLayoutManager(layoutManager);
    }
}