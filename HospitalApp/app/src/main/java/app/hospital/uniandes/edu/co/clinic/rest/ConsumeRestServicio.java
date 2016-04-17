package app.hospital.uniandes.edu.co.clinic.rest;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import app.hospital.uniandes.edu.co.clinic.PacienteActivity;
import app.hospital.uniandes.edu.co.clinic.ServiciosActivity;
import app.hospital.uniandes.edu.co.clinic.dtos.PersonDTO;
import app.hospital.uniandes.edu.co.clinic.dtos.ServiceDTO;
import app.hospital.uniandes.edu.co.clinic.http.HttpRequest;

/**
 * Created by Diego on 17/04/2016.
 */
public class ConsumeRestServicio extends AsyncTask<String, Long, String> {
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
        List<ServiceDTO> servicios = getServices(response);
        //Envio los datos del objeto
        int i = 0;
        for (ServiceDTO service : servicios) {
            //Integer i = (int) (long) service.getId();
            System.out.println(service);
            new ServiciosActivity().nombresServicios.add(i, service.getName());
            new ServiciosActivity().fullServicios.add(service);
            i++;
        }
        System.out.println(new ServiciosActivity().nombresServicios);
    }

    private List<ServiceDTO> getServices(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ServiceDTO>>() {
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
