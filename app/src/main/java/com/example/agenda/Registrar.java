package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
        private boolean existe(String id) {
            ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(Registrar.this,
                    Utilerias.NOMBRE_BD, null, 1);
            SQLiteDatabase bd = conexion.getReadableDatabase();
            String[] parametros = {id};
            String[] campos = {Utilerias.CAMPO_NOMBRE};
            Cursor cursor = bd.query(Utilerias.TABLA_PERSONA,
                    campos, Utilerias.CAMPO_ID + "=?", parametros,
                    null,
                    null,
                    null);
            return cursor.moveToFirst(); }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState); setContentView(R.layout.activity_registrar);
            final EditText etIdentificador = findViewById(R.id.etIdentificador),
                    etNombre = findViewById(R.id.etNombre),
                    etTelefono = findViewById(R.id.etTelefono);
            Button btnRegistrar = findViewById(R.id.btnRegistrar);
            btnRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String identificador = etIdentificador.getText().toString(),
                            nombre = etNombre.getText().toString(),
                            telefono = etTelefono.getText().toString();
                    if (existe(identificador)) {
                        Toast.makeText(Registrar.this, "Identificador existente",
                                Toast.LENGTH_SHORT).show(); return;
                    }
                    if (identificador.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) return;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Utilerias.CAMPO_ID, identificador);
                    contentValues.put(Utilerias.CAMPO_NOMBRE, nombre);
                    contentValues.put(Utilerias.CAMPO_TELEFONO, telefono);
                    ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(Registrar.this, Utilerias.NOMBRE_BD, null, 1);
                    SQLiteDatabase bd = conexion.getWritableDatabase();
                    long respuesta = bd.insert(Utilerias.TABLA_PERSONA, null, contentValues);
                    Toast.makeText(Registrar.this, "Registro #" + respuesta, Toast.LENGTH_SHORT).show();
                    bd.close();
                } });
        } }