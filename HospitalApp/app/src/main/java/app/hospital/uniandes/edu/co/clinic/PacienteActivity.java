package app.hospital.uniandes.edu.co.clinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import app.hospital.uniandes.edu.co.clinic.dtos.PersonDTO;
import app.hospital.uniandes.edu.co.clinic.rest.ConsumeRestPaciente;
import app.hospital.uniandes.edu.co.clinic.rest.ConsumeRestServicio;


public class PacienteActivity extends AppCompatActivity {

    PersonDTO myPerson;
    private Button btnBuscar;
    private Button btnServicios;
    public static EditText editTextDocumento;
    public static EditText editTextApellidos;
    public static EditText editTextNombres;
    public static EditText editTextDireccion;
    public static ArrayList<String> nombresServicios = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnServicios = (Button) findViewById(R.id.btnBuscarServicios);

        editTextDocumento = (EditText) findViewById(R.id.editTextDocumento);
        editTextApellidos = (EditText) findViewById(R.id.editTextApellidos);
        editTextNombres = (EditText) findViewById(R.id.editTextNombres);
        editTextDireccion = (EditText) findViewById(R.id.editTextDireccion);
        editTextApellidos.setEnabled(false);
        editTextNombres.setEnabled(false);
        editTextDireccion.setEnabled(false);

        btnBuscar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Buscando.. " + editTextDocumento.getText().toString(),
                        Toast.LENGTH_LONG).show();
                int numero = Integer.parseInt(editTextDocumento.getText().toString());
                //Consumiendo el servicio REST
                String url = String.format(
                        // "http://localhost:8080/hospital.logic/api/persons/",numero);
                        "http://10.0.2.2:8080/hospital.logic/api/persons/" + numero, numero);
                new ConsumeRestPaciente().execute(url);
            }
        });

        btnServicios.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int numero = 0;

                String url = String.format(
                        // "http://localhost:8080/hospital.logic/api/persons/",numero);
                        "http://10.0.2.2:8080/hospital.logic/api/services/", numero);
                new ConsumeRestServicio().execute(url);

                Toast.makeText(getApplicationContext(), "Ir a los servicios ",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ServiciosActivity.class);
                intent.putExtra("documento", editTextDocumento.getText().toString());
                intent.putExtra("nombres", editTextNombres.getText().toString());
                intent.putStringArrayListExtra("array",nombresServicios);
                startActivity(intent);
            }
        });
    }
}
