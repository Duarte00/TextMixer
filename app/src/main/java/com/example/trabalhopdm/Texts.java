package com.example.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Texts extends AppCompatActivity {

    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texts);

        ll=findViewById(R.id.ll);

        dataBase db = new dataBase(this);

        ArrayList<String> titles= db.readTitles();

        displayTitles(titles);
    }

    private void displayTitles(ArrayList<String> a){
        ll.removeAllViews();
        for(int i=0; i<a.size(); i++){
            Button b = new Button(this);
            b.setText(a.get(i));
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Texts.this, textResult.class);
                    i.putExtra("title", b.getText());
                    startActivity(i);
                }
            });
            ll.addView(b);
        }
    }

}