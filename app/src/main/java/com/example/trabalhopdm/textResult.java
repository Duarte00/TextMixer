package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class textResult extends AppCompatActivity {

    TextView textText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_result);

        textText = findViewById(R.id.textText);
        dataBase sb = new dataBase(this);
        Intent i = getIntent();

        textText.setText(sb.readText(i.getStringExtra("title")));
    }

    public void backToBeginnig(View v){
        Intent intent = new Intent(getApplicationContext(), MainPanel.class);
        startActivity(intent);
    }
}