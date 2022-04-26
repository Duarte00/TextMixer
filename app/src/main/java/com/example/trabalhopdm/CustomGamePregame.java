package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomGamePregame extends AppCompatActivity {

    private Button buttonPLay2;
    private TextView editNumberJogador2;
    private TextView editNumberRondas2;
    private TextView editNumberPalavras2;
    private TextView mostrarPalavras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_game_pregame);

        buttonPLay2 = findViewById(R.id.buttonPlay2);
        editNumberJogador2 = findViewById(R.id.editNumberJogadores2);
        editNumberRondas2 = findViewById(R.id.editNumberRondas2);
        editNumberPalavras2 = findViewById(R.id.editNumberPalavras2);
        mostrarPalavras = findViewById(R.id.mostrarPalavras);

        buttonPLay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strJ = editNumberJogador2.getText().toString();
                String strR = editNumberRondas2.getText().toString();
                String strW = editNumberPalavras2.getText().toString();
                String strM = mostrarPalavras.getText().toString();
                if(TextUtils.isEmpty(strJ) || TextUtils.isEmpty(strR) || TextUtils.isEmpty(strW) || TextUtils.isEmpty(strM)) {
                    editNumberJogador2.setError("Your message");
                    editNumberRondas2.setError("Your message");
                    editNumberPalavras2.setError("Your message");
                    mostrarPalavras.setError("Your message");
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), CustomGame.class);
                intent.putExtra("nJogadores", strJ);
                intent.putExtra("nRondas", strR);
                intent.putExtra("nWords", strW);
                intent.putExtra("nMostrar", strM);
                startActivity(intent);
            }
        });
    }
}