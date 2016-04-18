package app.hospital.uniandes.edu.co.clinic.rest;

import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Objects;

import app.hospital.uniandes.edu.co.clinic.PacienteActivity;
import app.hospital.uniandes.edu.co.clinic.dtos.PersonDTO;
import app.hospital.uniandes.edu.co.clinic.http.HttpRequest;
import app.hospital.uniandes.edu.co.clinic.PacienteActivity;

/**
 * Created by Diego on 17/04/2016.
 */


public class ConsumeRestPaciente extends AsyncTask<String, Long, String> {
    public static String errorMessage = null;
    public static boolean showError = false;

    protected String doInBackground(String... urls) {
        try {
            return HttpRequest.get(urls[0]).accept("application/json")
                    .body();
        } catch (HttpRequest.HttpRequestException exception) {
            return null;
        }
    }

    protected void onPostExecute(String response) {
        System.out.println("----------------");
        System.out.println(response);
        if (Objects.equals("No existe persona con ese id", response)) {
            showError=true;
            errorMessage = "No existe persona con ese documento";
        } else {
            PersonDTO person = getPersons(response);
            //Envio los datos del objeto
            if (person != null) {
                showError=false;
                errorMessage = null;
                new PacienteActivity().editTextDireccion.setText(person.getAddress());
                new PacienteActivity().editTextNombres.setText(person.getName());
                new PacienteActivity().editTextApellidos.setText(person.getSurname());
            }
        }

    }

    private PersonDTO getPersons(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<PersonDTO>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    private String prettyfyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        return gson.toJson(element);
    }
}
