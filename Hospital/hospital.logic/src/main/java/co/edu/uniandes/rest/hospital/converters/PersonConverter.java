package co.edu.uniandes.rest.hospital.converters;

import co.edu.uniandes.rest.hospital.dtos.PersonDTO;
import co.edu.uniandes.hospital.entities.PersonEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class PersonConverter {

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private PersonConverter() {
    }

    /**
     * Realiza la conversión de PersonEntity a PersonDTO.
     * Se invoca cuando otra entidad tiene una referencia a PersonEntity.
     * Entrega únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de PersonEntity a convertir
     * @return instancia de PersonDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PersonDTO refEntity2DTO(PersonEntity entity) {
        if (entity != null) {
            PersonDTO dto = new PersonDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setCedula(entity.getCedula());
            dto.setAddress(entity.getAddress());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversión de PersonDTO a PersonEntity Se invoca cuando otro DTO
     * tiene una referencia a PersonDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de PersonDTO a convertir
     * @return instancia de PersonEntity con los datos recibidos por parámetro
     * @generated
     */
    public static PersonEntity refDTO2Entity(PersonDTO dto) {
        if (dto != null) {
            PersonEntity entity = new PersonEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PersonEntity a PersonDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de PersonEntity a convertir
     * @return Instancia de PersonDTO con los datos recibidos por parámetro
     * @generated
     */
    private static PersonDTO basicEntity2DTO(PersonEntity entity) {
        if (entity != null) {
            PersonDTO dto = new PersonDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
             dto.setSurname(entity.getSurname());
            dto.setCedula(entity.getCedula());
            dto.setAddress(entity.getAddress());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PersonDTO a PersonEntity Se invoca cuando se
     * necesita convertir una instancia de PersonDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
     *
     * @param dto instancia de PersonDTO a convertir
     * @return Instancia de PersonEntity creada a partir de los datos de dto
     * @generated
     */
    private static PersonEntity basicDTO2Entity(PersonDTO dto) {
        if (dto != null) {
            PersonEntity entity = new PersonEntity();
            entity.setCedula(dto.getCedula());
            entity.setName(dto.getName());
            entity.setSurname(dto.getSurname());
            entity.setAddress(dto.getAddress());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte instancias de PersonEntity a PersonDTO incluyendo sus relaciones
     * Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de PersonEntity a convertir
     * @return Instancia de PersonDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PersonDTO fullEntity2DTO(PersonEntity entity) {
        if (entity != null) {
            PersonDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PersonDTO a PersonEntity.
     * Incluye todos los atributos de PersonEntity.
     *
     * @param dto Instancia de PersonDTO a convertir
     * @return Instancia de PersonEntity con los datos recibidos por parámetro
     * @generated
     */
    public static PersonEntity fullDTO2Entity(PersonDTO dto) {
        if (dto != null) {
            PersonEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de PersonEntity a PersonDTO. Para cada
     * instancia de PersonEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo PersonDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de PersonDTO
     * @generated
     */
    public static List<PersonDTO> listEntity2DTO(List<PersonEntity> entities) {
        List<PersonDTO> dtos = new ArrayList<PersonDTO>();
        if (entities != null) {
            for (PersonEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de PersonDTO a instancias de
     * PersonEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de PersonDTO a convertir
     * @return Collección de instancias de PersonEntity
     * @generated
     */
    public static List<PersonEntity> listDTO2Entity(List<PersonDTO> dtos) {
        List<PersonEntity> entities = new ArrayList<PersonEntity>();
        if (dtos != null) {
            for (PersonDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
