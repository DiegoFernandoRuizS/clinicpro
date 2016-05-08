/*
 * PersonDTO
 * Objeto de transferencia de datos de Ciudades.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
package co.edu.uniandes.rest.hospital.dtos;

/**
 * Objeto de transferencia de datos de Ciudades.
 *
 * @author Diego F.
 */
public class ServiceDTO {

    private Long id;
    private Double price;
    private String name;

    /**
     * Constructor por defecto
     */
    public ServiceDTO() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador del servicio
     * @param name nombre del servicio.
     * @param price precio del servicio.
     */
    public ServiceDTO(Long id, String name, Double price) {
        super();
        this.id = id;
        this.price=price;
        this.name = name;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\", price : \"" + getPrice()+ " }";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
