package app.hospital.uniandes.edu.co.clinic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import app.hospital.uniandes.edu.co.clinic.dtos.ServiceDTO;
import app.hospital.uniandes.edu.co.clinic.rest.ConsumeRestServicio;

public class ServiciosActivity extends AppCompatActivity {

    TextView datosPaciente;
    TextView servicioSeleccionadoView;
    TextView costo;
    public static ArrayAdapter<String> adapterServicios;
    public static ArrayList<String> nombresServicios = new ArrayList<String>();
    public static ArrayList<ServiceDTO> fullServicios = new ArrayList<ServiceDTO>();
    public String servicioSeleccionado;
    private Button btnCalcular;
    private Button btnGenerarRecibo;
    private Double costoServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        datosPaciente = (TextView) findViewById(R.id.textViewDatosPaciente);
        btnCalcular= (Button) findViewById(R.id.btnCosto);
        btnGenerarRecibo= (Button) findViewById(R.id.btnGenerar);

        //Recibiendo datos de la anterior activity
        Intent intent = getIntent();

        final String documento = intent.getStringExtra("documento");
        final String nombres = intent.getStringExtra("nombres");
        final String apellidos = intent.getStringExtra("apellidos");
        final String direccion = intent.getStringExtra("direccion");
        ArrayList<String> servicios= intent.getStringArrayListExtra("array");

        System.out.println("---Otra actividad---");
        System.out.println(servicios);
        datosPaciente.setText("Los datos del paciente son: " + documento + "\n Nombres:" + nombres + " " + apellidos);
        servicioSeleccionadoView= (TextView) findViewById(R.id.textViewServicioSeleccionado);
        costo= (TextView) findViewById(R.id.textViewCosto);

        //Fill data Spinner
        System.out.println("..... Servicios Nombres ----- ");
        System.out.println(nombresServicios);
        System.out.println("..... Servicios Full ----- ");
        System.out.println(fullServicios);
        adapterServicios = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nombresServicios);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerServicios);
        adapterServicios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterServicios);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                servicioSeleccionado = parent.getItemAtPosition(pos).toString();
                Toast.makeText(parent.getContext(),
                        "" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                System.out.println(servicioSeleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ServiceDTO servicio : fullServicios) {
                    if (Objects.equals(servicioSeleccionado, servicio.getName())) {
                        servicioSeleccionadoView.setText("Servicio: " + servicioSeleccionado);
                        costo.setText("Costo: $" + servicio.getPrice());
                        costoServicio=servicio.getPrice();
                        System.out.println("Precio " + servicio.getPrice());
                    }
                }
            }
        });

        //Generando el recibo en pdf
        btnGenerarRecibo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BillActivity.class);
                intent.putExtra("documento",documento);
                intent.putExtra("nombres",nombres);
                intent.putExtra("apellidos",apellidos);
                intent.putExtra("costo", costoServicio);
                intent.putExtra("servicio",servicioSeleccionado);
                intent.putExtra("direccion",direccion);
                startActivity(intent);
            }
        });
    }
}
