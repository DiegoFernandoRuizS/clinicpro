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


import co.edu.uniandes.rest.hospital.dtos.PersonDTO;
import co.edu.uniandes.rest.hospital.exceptions.PersonLogicException;

/**
 * Mock del recurso Persona (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class PersonLogicMock {
	
	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(PersonLogicMock.class.getName());
	
	// listado de personas
    private static ArrayList<PersonDTO> persons;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public PersonLogicMock() {

    	if (persons == null) {
            persons = new ArrayList<>();
            persons.add(new PersonDTO(1L, "Diego","Ruiz","Dg 5 f bis a 23 23",1000L));
            persons.add(new PersonDTO(2L, "Jorge","Vera","Calle 3 # 23 23",2000L));
            persons.add(new PersonDTO(3L, "Andrés","Delgado","Cra 57 # 32 32",3000L));
            persons.add(new PersonDTO(4L, "Abimelec","Cuesta","Calle 170 # 23 23",4000L));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de personas");
    	logger.info("personas" + persons );
    }    
    
	/**
	 * Obtiene el listado de personas. 
	 * @return lista de personas
	 * @throws PersonLogicException cuando no existe la lista en memoria  
	 */    
    public List<PersonDTO> getPersons() throws PersonLogicException {
    	if (persons == null) {
    		logger.severe("Error interno: lista de personas no existe.");
    		throw new PersonLogicException("Error interno: lista de personas no existe.");    		
    	}
    	
    	logger.info("retornando todas las personas");
    	return persons;
    }

    /**
     * Obtiene una persona
     * @param id identificador de la persona
     * @return persona encontrada
     * @throws PersonLogicException cuando la persona no existe
     */
    public PersonDTO getPerson(Long id) throws PersonLogicException {
    	logger.info("recibiendo solicitud de persona con id " + id);
    	
    	// busca la persona con el id suministrado - en realidad la cedula
        for (PersonDTO person : persons) {
            if (Objects.equals(person.getCedula(), id)){
            	logger.info("retornando persona " + person);
                return person;
            }
        }
        
        // si no encuentra la persona
        logger.severe("No existe persona con ese id");
        throw new PersonLogicException("No existe persona con ese id");
    }

    /**
     * Agrega una persona a la lista.
     * @param newPerson persona a adicionar
     * @throws PersonLogicException cuando ya existe una persona con el id suministrado
     * @return persona agregada
     */
    public PersonDTO createPerson(PersonDTO newPerson) throws PersonLogicException {
    	logger.info("recibiendo solicitud de agregar persona " + newPerson);
    	
    	// la nueva persona tiene id ?
    	if ( newPerson.getId() != null ) {
	    	// busca la persona con el id suministrado
	        for (PersonDTO person : persons) {
	        	// si existe una persona con ese id
	            if (Objects.equals(person.getId(), newPerson.getId())){
	            	logger.severe("Ya existe una persona con ese id");
	                throw new PersonLogicException("Ya existe una persona con ese id");
	            }
	        }
	        
	    // la nueva persona no tiene id ? 
    	} else {

    		// genera un id para la persona
    		logger.info("Generando id paa la nueva persona");
    		long newId = 1;
	        for (PersonDTO person : persons) {
	            if (newId <= person.getId()){
	                newId =  person.getId() + 1;
	            }
	        }
	        newPerson.setId(newId);
    	}
    	
        // agrega la persona
    	logger.info("agregando persona " + newPerson);
        persons.add(newPerson);
        return newPerson;
    }

    /**
     * Actualiza los datos de una persona
     * @param id identificador de la persona a modificar
     * @param updatePerson persona a modificar
     * @return datos de la persona modificada 
     * @throws PersonLogicException cuando no existe una persona con el id suministrado
     */
    public PersonDTO updatePerson(Long id, PersonDTO updatedPerson) throws PersonLogicException {
    	logger.info("recibiendo solictud de modificar persona " + updatedPerson);
    	
    	// busca la persona con el id suministrado
        for (PersonDTO person : persons) {
            if (Objects.equals(person.getId(), id)) {
            	
            	// modifica la persona
            	person.setId(updatedPerson.getId());
                person.setName(updatedPerson.getName());
                person.setSurname(updatedPerson.getSurname());
                person.setAddress(updatedPerson.getAddress());
                
                // retorna la persona modificada
            	logger.info("Modificando persona " + person);
                return person;
            }
        }
        
        // no encontró la persona con ese id ?
        logger.severe("No existe una persona con ese id");
        throw new PersonLogicException("No existe una persona con ese id");
    }

    /**
     * Elimina los datos de una persona
     * @param id identificador de la persona a eliminar
     * @throws PersonLogicException cuando no existe una persona con el id suministrado
     */
    public void deletePerson(Long id) throws PersonLogicException {
    	logger.info("recibiendo solictud de eliminar persona con id " + id);
    	
    	// busca la persona con el id suministrado
        for (PersonDTO person : persons) {
            if (Objects.equals(person.getCedula(), id)) {
            	
            	// elimina la persona
            	logger.info("eliminando persona " + person);
                persons.remove(person);
                return;
            }
        }

        // no encontró la persona con ese id ?
        logger.severe("No existe una persona con ese id");
        throw new PersonLogicException("No existe una persona con ese id");
    }
}
