package com.edu.sv.ejemplodbrealfirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.edu.sv.ejemplodbrealfirebase.datos.Persona;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre, edtfecha, edtgenero, edtpeso, edtaltura;
    String key="",nombre="",dui="", fecha="", genero="", peso="", altura="",accion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtfecha = findViewById(R.id.edtfecha);
        edtgenero= findViewById(R.id.edtgenero);
        edtpeso=findViewById(R.id.edtpeso);
        edtaltura= findViewById(R.id.edtaltura);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        fecha=datos.getString("fecha");
        genero= datos.getString("genero");
        peso=datos.getString("peso");
        altura=datos.getString("altura");
        accion=datos.getString("accion");

        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtfecha.setText(fecha);
        edtgenero.setText(genero);
        edtpeso.setText(peso);
        edtaltura.setText(altura);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String fecha = edtfecha.getText().toString();
        String genero = edtgenero.getText().toString();
        String peso = edtpeso.getText().toString();
        String altura = edtaltura.getText().toString();
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre, fecha, genero, peso, altura);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}
