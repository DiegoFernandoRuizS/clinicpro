package co.edu.uniandes.rest.hospital.converters;

import co.edu.uniandes.rest.hospital.dtos.ServiceDTO;
import co.edu.uniandes.hospital.entities.ServiceEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class ServiceConverter {

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private ServiceConverter() {
    }

    /**
     * Realiza la conversión de ServiceEntity a ServiceDTO.
     * Se invoca cuando otra entidad tiene una referencia a ServiceEntity.
     * Entrega únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de ServiceEntity a convertir
     * @return instancia de ServiceDTO con los datos recibidos por parámetro
     * @generated
     */
    public static ServiceDTO refEntity2DTO(ServiceEntity entity) {
        if (entity != null) {
            ServiceDTO dto = new ServiceDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversión de ServiceDTO a ServiceEntity Se invoca cuando otro DTO
     * tiene una referencia a ServiceDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de ServiceDTO a convertir
     * @return instancia de ServiceEntity con los datos recibidos por parámetro
     * @generated
     */
    public static ServiceEntity refDTO2Entity(ServiceDTO dto) {
        if (dto != null) {
            ServiceEntity entity = new ServiceEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de ServiceEntity a ServiceDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de ServiceEntity a convertir
     * @return Instancia de ServiceDTO con los datos recibidos por parámetro
     * @generated
     */
    private static ServiceDTO basicEntity2DTO(ServiceEntity entity) {
        if (entity != null) {
            ServiceDTO dto = new ServiceDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de ServiceDTO a ServiceEntity Se invoca cuando se
     * necesita convertir una instancia de ServiceDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
     *
     * @param dto instancia de ServiceDTO a convertir
     * @return Instancia de ServiceEntity creada a partir de los datos de dto
     * @generated
     */
    private static ServiceEntity basicDTO2Entity(ServiceDTO dto) {
        if (dto != null) {
            ServiceEntity entity = new ServiceEntity();
           // entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setPrice(dto.getPrice());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte instancias de ServiceEntity a ServiceDTO incluyendo sus relaciones
     * Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de ServiceEntity a convertir
     * @return Instancia de ServiceDTO con los datos recibidos por parámetro
     * @generated
     */
    public static ServiceDTO fullEntity2DTO(ServiceEntity entity) {
        if (entity != null) {
            ServiceDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de ServiceDTO a ServiceEntity.
     * Incluye todos los atributos de ServiceEntity.
     *
     * @param dto Instancia de ServiceDTO a convertir
     * @return Instancia de ServiceEntity con los datos recibidos por parámetro
     * @generated
     */
    public static ServiceEntity fullDTO2Entity(ServiceDTO dto) {
        if (dto != null) {
            ServiceEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de ServiceEntity a ServiceDTO. Para cada
     * instancia de ServiceEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo ServiceDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de ServiceDTO
     * @generated
     */
    public static List<ServiceDTO> listEntity2DTO(List<ServiceEntity> entities) {
        List<ServiceDTO> dtos = new ArrayList<ServiceDTO>();
        if (entities != null) {
            for (ServiceEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de ServiceDTO a instancias de
     * ServiceEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de ServiceDTO a convertir
     * @return Collección de instancias de ServiceEntity
     * @generated
     */
    public static List<ServiceEntity> listDTO2Entity(List<ServiceDTO> dtos) {
        List<ServiceEntity> entities = new ArrayList<ServiceEntity>();
        if (dtos != null) {
            for (ServiceDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
