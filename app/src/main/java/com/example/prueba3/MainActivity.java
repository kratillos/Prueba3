package com.example.prueba3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Resu, Vo;
    RadioButton nu,GB,JAK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resu = (Button) findViewById(R.id.button2);
        Vo =(Button) findViewById(R.id.button);
        nu = (RadioButton) findViewById(R.id.rb_nu);
        GB = (RadioButton) findViewById(R.id.rb_gb);
        JAK = (RadioButton) findViewById(R.id.rb_jak);

        Vo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db;
                Dbhelper conn = new Dbhelper(getApplicationContext());
                db = conn.getWritableDatabase();
                ContentValues CV = new ContentValues();
                if (nu.isChecked() == false || GB.isChecked() == false || JAK.isChecked() == false) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("¿Seguro que quiere dejar en blanco el voto?")
                            .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    db.insert("Voto", null, CV);
                                    Intent I = new Intent(getApplicationContext(), MainActivity2.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();
                }
                if (nu.isChecked() == true) {
                    CV.put("rb_nu", nu.getText().toString());
                    db.insert("Voto", null, CV);
                    Toast.makeText(getApplicationContext(), "Seleccion Aplicada", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(I);
                }
                if (GB.isChecked() == true) {
                    CV.put("rb_gb", GB.getText().toString());
                    db.insert("Voto", null, CV);
                    Toast.makeText(getApplicationContext(), "Seleccion Aplicada", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(I);
                }
                if (JAK.isChecked() == true) {
                    CV.put("rb_jak", JAK.getText().toString());
                    db.insert("Voto", null, CV);
                    Toast.makeText(getApplicationContext(), "Seleccion Aplicada", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(I);
                }


            }
        });

        Resu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(I);
            }
        });
    }
}