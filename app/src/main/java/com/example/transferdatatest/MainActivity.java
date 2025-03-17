package com.example.transferdatatest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }




    public void TransferData(View v) {
        Intent i;                                                           //Ανοιγει καινούριo intent (i).....
        i = new Intent(this, SecActivity.class );             //....που σε στελνει στην σελίδα SecActivity
        String name = ((Button)v).getText().toString();                     //Δημιουργει μια μεταβλητη τυπου String  με όνομα name και βαζει εκειμεσα το text του κουμπιου
        i.putExtra("Name",name);                                      //Στέλνει το περιεχόμενο της μεταβλητησ name στο intent i
        startActivity(i);                                                   //Ανοίγει την σελίδα SecActivity
    }
}