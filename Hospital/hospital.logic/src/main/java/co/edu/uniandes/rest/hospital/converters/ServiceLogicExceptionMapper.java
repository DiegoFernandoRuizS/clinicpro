package co.edu.uniandes.rest.hospital.converters;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.edu.uniandes.rest.hospital.exceptions.ServiceLogicException;

/**
 * Convertidor de Excepciones PersonLogicException a mensajes REST.
 */
@Provider
public class ServiceLogicExceptionMapper implements ExceptionMapper<ServiceLogicException> {

	/**
	 * Generador de una respuesta a partir de una excepción
	 * @param ex excecpión a convertir a una respuesta REST
	 */
	@Override
	public Response toResponse(ServiceLogicException ex) {
		// retorna una respuesta
		return Response
				.status(Response.Status.NOT_FOUND)	// estado HTTP 404
				.entity(ex.getMessage())                // mensaje adicional
				.type("text/plain")
				.build();
	}
	
}
