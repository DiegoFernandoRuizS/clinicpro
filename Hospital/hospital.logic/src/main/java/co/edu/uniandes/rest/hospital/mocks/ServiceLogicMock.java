package co.edu.uniandes.rest.hospital.mocks;

/**
 * Mock del recurso Personas (Mock del servicio REST)
 * @author Diego F.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


import co.edu.uniandes.rest.hospital.dtos.ServiceDTO;
import co.edu.uniandes.rest.hospital.exceptions.ServiceLogicException;

/**
 * Mock del recurso Servicios (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class ServiceLogicMock {
	
	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(ServiceLogicMock.class.getName());
	
	// listado de los servicios
    private static ArrayList<ServiceDTO> services;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ServiceLogicMock() {

    	if (services == null) {
            services = new ArrayList<>();
            services.add(new ServiceDTO(1L, "Médicina general", 35000D));
            services.add(new ServiceDTO(2L, "Estomatología", 32000D));
            services.add(new ServiceDTO(3L, "Odontología", 55000D));
            services.add(new ServiceDTO(4L, "Farmacología clínica", 56000D));
            services.add(new ServiceDTO(5L, "Gastroenterología", 60000D));
            services.add(new ServiceDTO(6L, "Traumatología", 45000D));
            services.add(new ServiceDTO(7L, "Toxicología", 76000D));
            services.add(new ServiceDTO(8L, "Urología", 90000D));
            services.add(new ServiceDTO(9L, "Cardiología", 43000D));
            services.add(new ServiceDTO(10L, "Cirugía cardiovascular", 87000D));
            services.add(new ServiceDTO(11L, "Cirugía general", 450000D));
            
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de servicios");
    	logger.info("services" + services );
    }    
    
	/**
	 * Obtiene el listado de servicios
	 * @return lista de servicios
	 * @throws ServiceLogicException cuando no existe la lista en memoria  
	 */    
    public List<ServiceDTO> getServices() throws ServiceLogicException {
    	if (services == null) {
    		logger.severe("Error interno: lista de servicios no existe.");
    		throw new ServiceLogicException("Error interno: lista de servicios no existe.");    		
    	}
    	
    	logger.info("retornando todos servicios");
    	return services;
    }

    /**
     * Obtiene una servicio
     * @param id identificador del servicio
     * @return servicio encontrada
     * @throws ServicioLogicException cuando el servicio no existe
     */
    public ServiceDTO getService(Long id) throws ServiceLogicException {
    	logger.info("recibiendo solicitud de servicio con id " + id);
    	
    	// busca la persona con el id suministrado - en realidad la cedula
        for (ServiceDTO service : services) {
            if (Objects.equals(service.getId(), id)){
            	logger.info("retornando servicio " + service.getName());
                return service;
            }
        }
        
        // si no encuentra el servicio
        logger.severe("No existe servicio con ese id");
        throw new ServiceLogicException("No existe servicio con ese id");
    }

   
}
