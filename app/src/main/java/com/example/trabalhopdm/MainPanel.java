package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPanel extends AppCompatActivity {

    private Button buttonClassic;
    private Button buttonCustom;
    private Button buttonTexts;
    private Button buttonExplain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel);

        buttonClassic = findViewById(R.id.buttonClassic);
        buttonClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        buttonCustom = findViewById(R.id. buttonCustom);
        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomGamePregame.class);
                startActivity(intent);
            }
        });

        buttonTexts = findViewById(R.id. buttonTexts);
        buttonTexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase db = new dataBase(MainPanel.this);
                if(db.readTitles().size()>0) {
                    Intent intent = new Intent(getApplicationContext(), Texts.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainPanel.this,"Sem Textos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonExplain = findViewById(R.id. buttonExplain);
        buttonExplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Explain.class);
                startActivity(intent);
            }
        });
    }
}

