/*
 * PersonResource.java
 * Clase que representa el recurso "/persons"
 * Implementa varios métodos para manipular las personas
 */
package co.edu.uniandes.rest.hospital.resources;

import co.edu.uniandes.rest.hospital.converters.PatientConverter;
import co.edu.uniandes.rest.hospital.dtos.PersonDTO;
import co.edu.uniandes.logic.hospital.ejbs.PatientLogic;
import co.edu.uniandes.rest.hospital.exceptions.PersonLogicException;
import co.edu.uniandes.rest.hospital.mocks.PersonLogicMock;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso REST correspondiente a "persons".
 * 
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "persons". 
 * Al ejecutar la aplicación, el recurse será accesibe a través de la 
 * ruta "/api/persons" 
 * 
 * @author Diego F.
 */
@Path("persons")
@Produces("application/json")
public class PersonResource {

	@Inject
	PersonLogicMock personLogic;
        
        @Inject
        PatientLogic patientLogic;

	/**
	 * Obtiene el listado de personas. 
	 * @return lista de personas
	 * @throws PersonLogicException excepción retornada por la lógica  
	 */
    /*@GET
    public List<PersonDTO> getPersons() throws PersonLogicException {
        return personLogic.getPersons();
    }*/
/*    @GET
    public List<PersonDTO> getPersons() throws PersonLogicException {
        return PatientConverter 
    }*/

    /**
     * Obtiene una person
     * @param id identificador de la person
     * @return person encontrada
     * @throws PersonLogicException cuando la person no existe
     */
        //mock
        /*
    @GET
    @Path("{id: \\d+}")
    public PersonDTO getPerson(@PathParam("id") Long id) throws PersonLogicException {
        return personLogic.getPerson(id);
    }*/
    
    @GET
    @Path("{id: \\d+}")
    public PersonDTO getPatient(@PathParam("id") Long id) {
        System.out.println("Consume GET ");
        return PatientConverter.converterEntity2DTO(patientLogic.getPatient(id));
    }

    /**
     * Agrega una person
     * @param person person a agregar
     * @return datos de la person a agregar
     * @throws PersonLogicException cuando ya existe una person con el id suministrado
     */
    @POST
    public PersonDTO createPerson(PersonDTO person) throws PersonLogicException {
        return personLogic.createPerson(person);
    }

    /**
     * Actualiza los datos de una person
     * @param id identificador de la person a modificar
     * @param person person a modificar
     * @return datos de la person modificada 
     * @throws PersonLogicException cuando no existe una person con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public PersonDTO updatePerson(@PathParam("id") Long id, PersonDTO person) throws PersonLogicException {
        return personLogic.updatePerson(id, person);
    }

    /**
     * Elimina los datos de una person
     * @param id identificador de la person a eliminar
     * @throws PersonLogicException cuando no existe una person con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePerson(@PathParam("id") Long id) throws PersonLogicException {
    	personLogic.deletePerson(id);
    }

}
