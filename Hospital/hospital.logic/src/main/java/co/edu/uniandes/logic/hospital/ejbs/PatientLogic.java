/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.logic.hospital.ejbs;

/**
 *
 * @author diego
 */
import co.edu.uniandes.logic.hospital.dao.PatientDAO;
import co.edu.uniandes.rest.hospital.dtos.PersonDTO;
import co.edu.uniandes.logic.hospital.entity.Patient;
import co.edu.uniandes.rest.hospital.converters.PatientConverter;
import co.edu.uniandes.rest.hospital.exceptions.PersonLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
 

@Stateless
public class PatientLogic {
    //private static final Logger logger = Logger.getLogger(AuthorLogic.class.getName());

    @Inject
    private PatientDAO persistence;

    public Patient getPatient(Long id) {
        return persistence.find(id);
    }
}
