package com.example.transferdatatest;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sec);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        Intent i;
        i = getIntent();
        String name=i.getStringExtra("Name");
        //----------IF που ελεγχει σε περίπτωση που το "name" ειναι κενό , για να μη φαινεται κενο το
        //----------το label , βάζουμε μια εξαίρεση να εμφανίζει "Mr NoMane",
        if(name==null){
            ((TextView)findViewById(R.id.textView)).setText("Mr NoMane" + name);
            ((TextView)findViewById(R.id.editTextTextMultiLine)).setText("hello Mr,.....");
        }else{
            ((TextView)findViewById(R.id.textView)).setText("Replay to Mr" + name);
            ((TextView)findViewById(R.id.editTextTextMultiLine)).setText("hello Mr "+ name +",.....");
        }






    }


    public void ReturnPage(View view) {
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }
}