/*
 * ServiceResource.java
 * Clase que representa el recurso "/services"
 * Implementa varios métodos para manipular los servicios
 */
package co.edu.uniandes.rest.hospital.resources;

import co.edu.uniandes.hospital.api.IServiceLogic;
import co.edu.uniandes.hospital.entities.ServiceEntity;
import co.edu.uniandes.rest.hospital.converters.ServiceConverter;
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
	IServiceLogic serviceLogic;

	/**
	 * Obtiene el listado de servicios. 
	 * @return lista de servicios
	 * @throws ServiceLogicException excepción retornada por la lógica  
	 */
    @GET
    public List<ServiceDTO> getServices() throws ServiceLogicException {
        return ServiceConverter.listEntity2DTO(serviceLogic.getServices());
    }

    /**
     * Obtiene una servicio
     * @param id identificador de la service
     * @return service encontrada
     * @throws ServiceLogicException cuando la service no existe
     */
    @GET
    @Path("{id: \\d+}")
    public ServiceDTO getService(@PathParam("id") Long id) throws ServiceLogicException {
        return ServiceConverter.fullEntity2DTO(serviceLogic.getService(id));
    }
    
    @POST
    public ServiceDTO createService(ServiceDTO service) throws ServiceLogicException {
        ServiceEntity entity = ServiceConverter.fullDTO2Entity(service);
        return ServiceConverter.fullEntity2DTO(serviceLogic.createService(entity));
    }

    /**
     * Actualiza los datos de una service
     * @param id identificador de la service a modificar
     * @param service service a modificar
     * @return datos de la service modificada 
     * @throws ServiceLogicException cuando no existe una service con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public ServiceDTO updateService(@PathParam("id") Long id, ServiceDTO service) throws ServiceLogicException {
        ServiceEntity entity = ServiceConverter.fullDTO2Entity(service);
        entity.setId(id);
        ServiceEntity oldEntity = serviceLogic.getService(id);
        //entity.setBooks(oldEntity.getBooks());
        return ServiceConverter.fullEntity2DTO(serviceLogic.updateService(entity));
    }

    /**
     * Elimina los datos de una service
     * @param id identificador de la service a eliminar
     * @throws ServiceLogicException cuando no existe una service con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteService(@PathParam("id") Long id) throws ServiceLogicException {
    	serviceLogic.deleteService(id);
    }

    
}
