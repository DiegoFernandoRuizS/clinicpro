/*
 * PersonResource.java
 * Clase que representa el recurso "/persons"
 * Implementa varios métodos para manipular las personas
 */
package co.edu.uniandes.rest.hospital.resources;

import co.edu.uniandes.hospital.api.IPersonLogic;
import co.edu.uniandes.hospital.entities.PersonEntity;
import co.edu.uniandes.rest.hospital.converters.PersonConverter;
import co.edu.uniandes.rest.hospital.dtos.PersonDTO;
import co.edu.uniandes.rest.hospital.exceptions.PersonLogicException;
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
        IPersonLogic personLogic;
	/**
	 * Obtiene el listado de personas. 
	 * @return lista de personas
	 * @throws PersonLogicException excepción retornada por la lógica  
	 */
       
    @GET
    public List<PersonDTO> getPersons() throws PersonLogicException {
        return PersonConverter.listEntity2DTO(personLogic.getPersons());
    }
          
    /**
     * Obtiene una person
     * @param id identificador de la person
     * @return person encontrada
     * @throws PersonLogicException cuando la person no existe
     */
    @GET
    @Path("{id: \\d+}")
    public PersonDTO getPerson(@PathParam("id") Long id) throws PersonLogicException {
        return PersonConverter.fullEntity2DTO(personLogic.getPersonByCedula(id));
    }

    /**
     * Agrega una person
     * @param person person a agregar
     * @return datos de la person a agregar
     * @throws PersonLogicException cuando ya existe una person con el id suministrado
     */
    
    @POST
    public PersonDTO createAuthor(PersonDTO dto) {     
        PersonEntity entity = PersonConverter.fullDTO2Entity(dto);
        return PersonConverter.fullEntity2DTO(personLogic.createPerson(entity));
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
        PersonEntity entity = PersonConverter.fullDTO2Entity(person);
        entity.setId(id);
        PersonEntity oldEntity = personLogic.getPerson(id);
        //entity.setBooks(oldEntity.getBooks());
        return PersonConverter.fullEntity2DTO(personLogic.updatePerson(entity));
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
