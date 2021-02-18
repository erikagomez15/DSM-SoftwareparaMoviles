package com.example.ejerciciocomplementario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private TextView valor;
    public int cont=0;
    String v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        valor = (TextView)findViewById(R.id.valor1);
    }

    @Override
    protected void onStart(){
    super.onStart();
    Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle estado) {

        super.onSaveInstanceState(estado);
        v = valor.getText().toString();
        cont = Integer.parseInt(v);
        estado.putString("text", v);
    }


    @Override
    protected void onRestoreInstanceState(Bundle estado2) {

        super.onRestoreInstanceState(estado2);
        v = estado2.getString("text");
        cont = Integer.parseInt(v);
        valor.setText(v);
    }

    public void incremento(View view) {
        cont = cont +1;
        if(cont == 10){
            cont = 0;
        }
        String valor2 = valueOf(cont);
        valor.setText(valor2);
    }






    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }










}