package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button buttonPLay;
    private TextView editNumberJogador;
    private TextView editNumberRondas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPLay = findViewById(R.id.buttonPlay);
        editNumberJogador = findViewById(R.id.editNumberJogadores);
        editNumberRondas = findViewById(R.id.editNumberRondas);

        buttonPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strJ = editNumberJogador.getText().toString();
                String strR = editNumberRondas.getText().toString();
                if(TextUtils.isEmpty(strJ) || TextUtils.isEmpty(strR)) {
                    editNumberJogador.setError("Your message");
                    editNumberRondas.setError("Your message");
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), Jogo.class);
                intent.putExtra("nJogadores", strJ);
                intent.putExtra("nRondas", strR);
                startActivity(intent);
            }
        });
    }
}