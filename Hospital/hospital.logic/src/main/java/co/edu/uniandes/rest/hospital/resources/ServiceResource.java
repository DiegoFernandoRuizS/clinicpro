/*
 * PersonResource.java
 * Clase que representa el recurso "/services"
 * Implementa varios métodos para manipular los servicios
 */
package co.edu.uniandes.rest.hospital.resources;

import co.edu.uniandes.rest.hospital.dtos.ServiceDTO;
import co.edu.uniandes.rest.hospital.exceptions.ServiceLogicException;
import co.edu.uniandes.rest.hospital.mocks.ServiceLogicMock;

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
 * Clase que implementa el recurso REST correspondiente a "services".
 * 
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "services". 
 * Al ejecutar la aplicación, el recurse será accesibe a través de la 
 * ruta "/api/services" 
 * 
 * @author Diego F.
 */
@Path("services")
@Produces("application/json")
public class ServiceResource {

	@Inject
	ServiceLogicMock serviceLogic;

	/**
	 * Obtiene el listado de servicios. 
	 * @return lista de servicios
	 * @throws ServiceLogicException excepción retornada por la lógica  
	 */
    @GET
    public List<ServiceDTO> getServices() throws ServiceLogicException {
        return serviceLogic.getServices();
    }

    /**
     * Obtiene una servicio
     * @param id identificador de la person
     * @return person encontrada
     * @throws PersonLogicException cuando la person no existe
     */
    @GET
    @Path("{id: \\d+}")
    public ServiceDTO getService(@PathParam("id") Long id) throws ServiceLogicException {
        return serviceLogic.getService(id);
    }
    
    
    
}
