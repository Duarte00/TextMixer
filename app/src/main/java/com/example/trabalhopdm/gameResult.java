package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class gameResult extends AppCompatActivity {
    private static final String FILE_NAME = "texto.txt";

    TextView textResult;
    EditText titleText;
    Button salvar_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        textResult = findViewById(R.id.textResult);
        titleText = findViewById(R.id.titleText);
        salvar_texto = findViewById(R.id.salvar_texto);

        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("  ");
            }
            textResult.setText(sb);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        File dir = getFilesDir();
        File file = new File(dir, "texto.txt");
        boolean deleted = file.delete();

    }

    public void backToBeginnig(View v){
        Intent intent = new Intent(getApplicationContext(), MainPanel.class);
        startActivity(intent);
    }

    public void saveTextDB(View v){
        if(TextUtils.isEmpty(titleText.getText().toString())) {
            titleText.setError("Your message");
            return;
        }
        dataBase db = new dataBase(this);
        db.addResult(titleText.getText().toString(),textResult.getText().toString());
        salvar_texto.setEnabled(false);
        Toast.makeText(this, "Texto salvado com sucesso", Toast.LENGTH_SHORT).show();
    }
}


/*iliminar atividade anterior e conteudo do ficheiro*/



