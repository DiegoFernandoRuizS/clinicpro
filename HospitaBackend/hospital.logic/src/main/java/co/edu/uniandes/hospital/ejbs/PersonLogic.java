package co.edu.uniandes.hospital.ejbs;

import co.edu.uniandes.hospital.api.IPersonLogic;
import co.edu.uniandes.hospital.entities.PersonEntity;
import co.edu.uniandes.hospital.exceptions.BusinessLogicException;
import co.edu.uniandes.hospital.persistence.PersonPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonLogic implements IPersonLogic {

    private static final Logger logger = Logger.getLogger(PersonLogic.class.getName());

    @Inject
    private PersonPersistence persistence;

    /*@Inject
    IBookLogic bookLogic;*/
    @Override
    public List<PersonEntity> getPersons() {
        logger.info("Inicia proceso de consultar todos los pacientes");
        List<PersonEntity> persons = persistence.findAll();
        logger.info("Termina proceso de consultar todos los pacientes");
        return persons;
    }

    @Override
    public PersonEntity getPerson(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar person con id={0}", id);
        PersonEntity person = persistence.find(id);
        if (person == null) {
            logger.log(Level.SEVERE, "El paciente con el id {0} no existe", id);
            throw new IllegalArgumentException("El paciente solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar person con id={0}", id);
        return person;
    }

    @Override
    public PersonEntity createPerson(PersonEntity entity) {
        logger.info("Inicia proceso de creación de paciente");
        persistence.create(entity);
        logger.info("Termina proceso de creación de paciente");
        return entity;
    }

    @Override
    public PersonEntity updatePerson(PersonEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar paciente con id={0}", entity.getId());
        PersonEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar paciente con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deletePerson(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar paciente con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar paciente con id={0}", id);
    }

    @Override
    public PersonEntity getPersonByCedula(Long cc){
        logger.log(Level.INFO, "Inicia proceso de consultar person con cc={0}", cc);
        PersonEntity person = persistence.findByCedula(cc);
        if (person == null) {
            logger.log(Level.SEVERE, "El paciente con el cc {0} no existe", cc);
            throw new IllegalArgumentException("El paciente solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar person con cc={0}", cc);
        return person;
    }
}
