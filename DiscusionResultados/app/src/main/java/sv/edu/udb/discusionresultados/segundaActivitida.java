package sv.edu.udb.discusionresultados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class segundaActivitida extends AppCompatActivity {

    private TextView tviss;
    private TextView tvafp;
    private TextView tvrenta;
    private TextView tvsueldoneto;
    private TextView tvnombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_activitida);

        double descuentoiss, descuentoafp, sueldobase;
        double descuentorenta, sueldoneto;

        tviss=(TextView)findViewById(R.id.tvisss);
        tvafp=(TextView)findViewById(R.id.tvafp);
        tvrenta=(TextView)findViewById(R.id.tvrenta);
        tvsueldoneto=(TextView)findViewById(R.id.tvsueldoneto);
        tvnombre=(TextView)findViewById(R.id.tvnombre);

        Bundle bundle = getIntent().getExtras();
        String nombre =bundle.getString("txtNombre");

        String horas1 = bundle.getString("txtHoras");
        int horas = Integer.parseInt(horas1);

        sueldobase =horas*8.50;
        descuentoiss = sueldobase * 0.02;
        descuentoafp = sueldobase *0.03;
        descuentorenta =sueldobase*0.04;
        sueldoneto = sueldobase -descuentoafp-descuentoiss-descuentorenta;
        tviss.setText("Total Descuento ISSS:" +descuentoiss);
        tvafp.setText("Total Descuento AFP:" +descuentoafp);
        tvrenta.setText("Total Descuento RENTA:" +descuentorenta);
        tvsueldoneto.setText("Total Salario:" + sueldoneto);
        tvnombre.setText(nombre);

    }

    public void finalizar(View v) {
        finish();
    }
}