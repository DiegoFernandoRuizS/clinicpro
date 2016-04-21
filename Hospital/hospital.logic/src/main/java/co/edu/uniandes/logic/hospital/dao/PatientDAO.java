/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.logic.hospital.dao;

/**
 *
 * @author diego
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.edu.uniandes.logic.hospital.entity.Patient;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class PatientDAO {

    @PersistenceContext(unitName = "HospitalPU")

    //EntityManagerFactory factory = Persistence.createEntityManagerFactory("HospitalPU");
    protected EntityManager em;

//    private static final Logger logger = Logger.getLogger(AuthorPersistence.class.getName());

    public Patient find(Long id) {
        //    logger.log(Level.INFO, "Consultando paciente con id={0}", id);
        // Query q = em.createQuery("SELECT p FROM Patient p WHERE p.id = :id");
        System.out.println("------------------------");
        System.out.println("Llega id "+id);
        //return (Patient) em.createNamedQuery("Patient.findById", Patient.class).setParameter("id", id).getSingleResult();       
        Query query = em.createQuery("SELECT p FROM Patient p WHERE p.id = :id").setParameter("id", 1);
        System.out.println("----- Antes de la consulta");
        Patient myPatient = (Patient) query.getSingleResult();
        System.out.println("myPatient: " + myPatient.getName());
        return myPatient;

    }

    /* public List<Patient> findAll() {
      //  logger.info("Consultando todos los autores");
        Query q = em.createQuery("SELECT p FROM Patient p");
        return q.getResultList();
    }*/
}
