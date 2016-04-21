/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import co.edu.uniandes.logic.hospital.entity.Patient;
import static co.edu.uniandes.logic.hospital.entity.Patient_.id;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class PatientTest {
    
    public PatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    /*
     @Test
     public void hello() {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("HospitalPU");
        EntityManager manager = factory.createEntityManager();
        Query query= manager.createQuery("SELECT p.name FROM Patient p");
        List<String> lista= query.getResultList();
     
        for (String string : lista) {
            System.out.println(string);
        }
        manager.close();

     }
     @Test
     public void hello2() {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("HospitalPU");
        EntityManager manager = factory.createEntityManager();
        
        Query query= manager.createQuery("SELECT p FROM Patient p WHERE p.id = :id").setParameter("id", 1);

       Patient myPatient=(Patient) query.getSingleResult();
         System.out.println("my aaa" +myPatient.getSurname());
       
        manager.close();

     }*/
}
