package com.example.marce.masacorporal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pes, est;
    private ImageView imag;
    private Toast msj;
    private double  estatura,imc;
    private String categ, modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pes = (EditText) findViewById(R.id.peso);
        est = (EditText)findViewById(R.id.estatura);
        imag = (ImageView)findViewById(R.id.img);

    }

    protected void calcular(View view) {

        try {
            String s_pes = pes.getText().toString();
            String s_est = est.getText().toString();
            double vpes, vest;
            vpes = Integer.parseInt(s_pes);
            vest = Integer.parseInt(s_est);
            estatura = vest / 100;
            imc = vpes / (estatura*estatura);

            msj = Toast.makeText(getApplicationContext(), getResources().getString(R.string.indice) + "\n" + imc + " Kg/m2", Toast.LENGTH_SHORT);
            msj.show();


            if (imc < 18.50) {
                categ = getResources().getString(R.string.cat_bajoPeso);
                imag.setImageResource(R.drawable.delgada);
                if (imc < 16.0) {
                    modo = getResources().getString(R.string.delgadez_severa);
                } else {
                    if (imc >= 16.0 && imc <= 16.99) {
                        modo = getResources().getString(R.string.delgadez_moderada);
                    } else {
                        if (imc > 16.99 && imc <= 18.49) {
                            modo = getResources().getString(R.string.delgadez_leve);
                        }
                    }
                }
            } else {
                if (imc >= 18.50 && imc <= 24.99) {
                    categ = getResources().getString(R.string.cat_normal);
                    imag.setImageResource(R.drawable.normal);
                    modo = "Normal";
                } else {
                    if (imc > 24.99 && imc < 30) {
                        categ = getResources().getString(R.string.cat_sobrepeso);
                        imag.setImageResource(R.drawable.sobrepeso);
                        modo = getResources().getString(R.string.preobeso);
                    }
                    else {
                        if (imc >= 30) {
                            categ = getResources().getString(R.string.cat_obesidad);
                            imag.setImageResource(R.drawable.obesidad);
                            if (imc >= 30.0 && imc <= 34.99) {
                                modo = getResources().getString(R.string.obeso);
                            } else {
                                if (imc > 34.99 && imc <= 39.99) {
                                    modo = getResources().getString(R.string.obes_Media);
                                } else {
                                    if (imc > 39.99) {
                                        modo = getResources().getString(R.string.obes_Morbida);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            msj = Toast.makeText(getApplicationContext(), categ + "\n" + getResources().getString(R.string.clasificacion) + ": " + modo, Toast.LENGTH_SHORT);
            msj.show();

        }

        catch (Exception e){
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }


    }


    protected void acerca(View view){
        Intent i = new Intent(this, Acercade.class );
        startActivity(i);
        finish();
    }
}
