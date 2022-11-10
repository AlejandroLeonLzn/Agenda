package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = findViewById(R.id.btnRegistrar),
                btnConsultar = findViewById(R.id.btnConsultar),
                btnListar = findViewById(R.id.btnListar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Registrar.class);
            startActivity(intent);
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Consultar.class);
                startActivity(intent);
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Listar.class);
                startActivity(intent);
            }
        }); }
}