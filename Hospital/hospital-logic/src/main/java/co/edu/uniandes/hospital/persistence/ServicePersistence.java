package co.edu.uniandes.hospital.persistence;

import co.edu.uniandes.hospital.entities.ServiceEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ServicePersistence {

    private static final Logger logger = Logger.getLogger(ServicePersistence.class.getName());

    @PersistenceContext(unitName = "HospitalPU")
    protected EntityManager em;

    public ServiceEntity create(ServiceEntity entity) {
        logger.info("Creando un servicio nuevo");
        em.persist(entity);
        logger.info("servicio creado");
        return entity;
    }

    public ServiceEntity update(ServiceEntity entity) {
        logger.log(Level.INFO, "Actualizando servicio con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando servicio con id={0}", id);
        ServiceEntity entity = em.find(ServiceEntity.class, id);
        em.remove(entity);
    }

    public ServiceEntity find(Long id) {
        logger.log(Level.INFO, "Consultando servicio con id={0}", id);
        return em.find(ServiceEntity.class, id);
    }

    public List<ServiceEntity> findAll(){
        logger.info("Consultando todos los servicios findAll");
        Query q = em.createQuery("select u from ServiceEntity u");
        return q.getResultList();
    }
}
