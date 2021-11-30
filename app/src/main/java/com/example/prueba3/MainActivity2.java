package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button Vol;
    TextView tx_white, tx_nul, tx_gb, tx_jak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Vol = (Button) findViewById(R.id.button3);
        tx_white = (TextView) findViewById(R.id.textView7);
        tx_nul = (TextView) findViewById(R.id.textView9);
        tx_gb = (TextView) findViewById(R.id.textView11);
        tx_jak = (TextView) findViewById(R.id.textView13);

        Integer TotBlanc=0, TotNul=0, TotGb=0,TotJak=0;
        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db = conn.getReadableDatabase();
        Cursor C =db.query("Voto", null,null,null,null,null,null);
        if (C!=null)
        {
            if (C.moveToFirst())
            {
                do {
                    if (C.getString(2).equals("")){
                        TotBlanc++;
                    }
                    if (C.getString(2).equals("")){
                        TotNul++;
                    }
                    if (C.getString(2).equals("")){
                        TotGb++;
                    }
                    if (C.getString(2).equals("")){
                        TotJak++;
                    }
                }
                while(C.moveToNext());
            }
        }
        tx_white.setText(""+TotBlanc);
        tx_nul.setText(""+TotNul);
        tx_gb.setText(""+TotGb);
        tx_jak.setText(""+TotJak);

        Vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });

    }
}