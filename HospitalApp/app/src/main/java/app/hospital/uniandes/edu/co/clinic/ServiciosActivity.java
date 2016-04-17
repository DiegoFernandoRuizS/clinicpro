package app.hospital.uniandes.edu.co.clinic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ServiciosActivity extends AppCompatActivity {

    TextView datosPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        datosPaciente = (TextView) findViewById(R.id.textViewDatos);

        Intent intent = getIntent();

        String documento = intent.getStringExtra("documento");
        String nombres = intent.getStringExtra("nombres");

        datosPaciente.setText("Los datos del paciente son: " + documento + " " + nombres);

        //Fill data Spinner

        final String[] Servicios = new String[]{"Médicina general", "Estomatología",
                "Odontología", "Farmacología clínica", "Gastroenterología", "Traumatología", "Toxicología", "Urología", "Cardiología",
                "Cirugía cardiovascular", "Cirugía general"};

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerServicios);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Servicios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }


}
