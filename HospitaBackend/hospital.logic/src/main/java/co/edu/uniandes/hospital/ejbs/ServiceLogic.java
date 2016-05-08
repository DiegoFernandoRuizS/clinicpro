package co.edu.uniandes.hospital.ejbs;

import co.edu.uniandes.hospital.api.IServiceLogic;
import co.edu.uniandes.hospital.entities.ServiceEntity;
import co.edu.uniandes.hospital.exceptions.BusinessLogicException;
import co.edu.uniandes.hospital.persistence.ServicePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ServiceLogic implements IServiceLogic {

    private static final Logger logger = Logger.getLogger(ServiceLogic.class.getName());

    @Inject
    private ServicePersistence persistence;

    /*@Inject
    IBookLogic bookLogic;*/
    @Override
    public List<ServiceEntity> getServices() {
        logger.info("Inicia proceso de consultar todos los servicios");
        List<ServiceEntity> Services = persistence.findAll();
        logger.info("Termina proceso de consultar todos los servicios");
        return Services;
    }

    @Override
    public ServiceEntity getService(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar service con id={0}", id);
        ServiceEntity service = persistence.find(id);
        if (service == null) {
            logger.log(Level.SEVERE, "El servicio con el id {0} no existe", id);
            throw new IllegalArgumentException("El servicio solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar service con id={0}", id);
        return service;
    }

    @Override
    public ServiceEntity createService(ServiceEntity entity) {
        logger.info("Inicia proceso de creación de servicio");
        persistence.create(entity);
        logger.info("Termina proceso de creación de servicio");
        return entity;
    }

    @Override
    public ServiceEntity updateService(ServiceEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar servicio con id={0}", entity.getId());
        ServiceEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar servicio con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteService(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar servicio con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar servicio con id={0}", id);
    }
    
}
