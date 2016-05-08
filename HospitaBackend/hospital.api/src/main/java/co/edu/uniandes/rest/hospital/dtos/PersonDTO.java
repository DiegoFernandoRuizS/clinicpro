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
public class PersonDTO {

    private Long id;
    private Long cedula;
    private String name;
    private String surname;
    private String address;

    /**
     * Constructor por defecto
     */
    public PersonDTO() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador de la person
     * @param name nombre de la person
     * @param address surname de la person
     * @param surname address de la person
     * @param cedula cedula de la person
     */
    public PersonDTO(Long id, String name, String surname, String address, Long cedula) {
        super();
        this.id = id;
        this.cedula = cedula;
        this.name = name;
        this.surname = surname;
        this.address = address;
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

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\", surname : \"" + getSurname() + ", address : \"" + getAddress() + ", cedula : \"" + getCedula()+ " }";
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the cedula
     */
    public Long getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
}
