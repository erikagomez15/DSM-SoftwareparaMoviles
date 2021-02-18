package sv.edu.udb.discusionresultados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private  EditText etHoras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.txtNombre);
        etHoras = (EditText)findViewById(R.id.txtHoras);

    }

    public void segundaActivitida (View v){
        Intent i = new Intent(this, segundaActivitida.class);
        i.putExtra("txtNombre", etNombre.getText().toString());
        i.putExtra("txtHoras", etHoras.getText().toString());
        startActivity(i);
    }
}