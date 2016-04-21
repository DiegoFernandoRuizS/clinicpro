/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.hospital.converters;

/**
 *
 * @author diego
 */
import co.edu.uniandes.rest.hospital.dtos.PersonDTO;
import co.edu.uniandes.logic.hospital.entity.Patient;
public abstract class PatientConverter {
    
      public static PersonDTO converterEntity2DTO(Patient entity) {
        if (entity != null) {
            PersonDTO dto = new PersonDTO();
            dto.setId((long)entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setCedula((long)entity.getCedula());
            dto.setAddress(entity.getAddress());
           
            return dto;
        } else {
            return null;
        }
    }
    
}
