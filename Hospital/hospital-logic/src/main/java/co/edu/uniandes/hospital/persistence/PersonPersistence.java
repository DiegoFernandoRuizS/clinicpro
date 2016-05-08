package co.edu.uniandes.hospital.persistence;

import co.edu.uniandes.hospital.entities.PersonEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PersonPersistence {

    private static final Logger logger = Logger.getLogger(PersonPersistence.class.getName());

    @PersistenceContext(unitName = "HospitalPU")
    protected EntityManager em;

    public PersonEntity create(PersonEntity entity) {
        logger.info("Creando un paciente nuevo");
        em.persist(entity);
        logger.info("paciente creado");
        return entity;
    }

    public PersonEntity update(PersonEntity entity) {
        logger.log(Level.INFO, "Actualizando paciente con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando paciente con id={0}", id);
        PersonEntity entity = em.find(PersonEntity.class, id);
        em.remove(entity);
    }

    public PersonEntity find(Long id) {
        logger.log(Level.INFO, "Consultando paciente con id={0}", id);
        return em.find(PersonEntity.class, id);
    }

    public PersonEntity findByCedula(Long cc) {
        logger.log(Level.INFO, "Consultando paciente con cc={0}", cc);
        Query q = em.createQuery("select u from PersonEntity u where u.cedula=:cc",PersonEntity.class);
        return (PersonEntity) q.setParameter("cc", cc).getSingleResult();
    }

    public List<PersonEntity> findAll(){
        logger.info("Consultando todos los pacientes findAll");
        Query q = em.createQuery("select u from PersonEntity u");
        return q.getResultList();
    }
}
