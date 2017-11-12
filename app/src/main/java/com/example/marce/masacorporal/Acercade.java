package com.example.marce.masacorporal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Acercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }

    protected void regresar(View view){
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
        finish();
    }

}
