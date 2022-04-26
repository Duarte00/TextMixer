package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Jogo extends AppCompatActivity {
    private static final String FILE_NAME = "texto.txt";
    private static int intPlayer;
    private static int intRonda;
    private int j=0;
    private int l=0;

    EditText mEdiText;
    TextView labelText;
    TextView jogadorLabel;
    TextView rondaLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        labelText = findViewById(R.id.label2Words);
        mEdiText = findViewById(R.id.textBox);

        jogadorLabel = findViewById(R.id.jogadorLabel);
        Intent intentJ = getIntent();
        String intJJ = intentJ.getStringExtra("nJogadores");
        intPlayer =  Integer.parseInt(intJJ);

        rondaLabel = findViewById(R.id.rondaLabel);
        Intent intentR = getIntent();
        String intRR = intentR.getStringExtra("nRondas");
        intRonda =  Integer.parseInt(intRR);
    }


    public void save() {
        String text = mEdiText.getText().toString() + " ";
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes(StandardCharsets.UTF_8));
            mEdiText.getText().clear();
            Toast.makeText(this, "Saved to" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        load();
    }


    public void load() {
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
            String sbString = sb.toString();
            String[] parts = sbString.split(" ");
            String lastWords =parts[parts.length - 2]+ " " + parts[parts.length - 1];
            labelText.setText(lastWords);
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
    }

    public void buttonClick(View v) {
        String text = mEdiText.getText().toString() + " ";
        if (!(text.split(" ").length < 2                    )) {
            if (j < intPlayer) {
                j++;
                save();
                if (l < intRonda && j == intPlayer) {
                    l++;
                    String strRound = String.valueOf(l + 1);
                    rondaLabel.setText(strRound);
                    j = 0;
                }
                String strPlayer = String.valueOf(j + 1);
                jogadorLabel.setText(strPlayer);
            }
            if (l == intRonda) {
                Intent intent = new Intent(getApplicationContext(), gameResult.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "É preciso adicionar mais palavras!", Toast.LENGTH_SHORT).show();
        }
    }
}

