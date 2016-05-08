package co.edu.uniandes.hospital.api;

import co.edu.uniandes.hospital.entities.PersonEntity;
import co.edu.uniandes.hospital.exceptions.BusinessLogicException;
import java.util.List;

public interface IPersonLogic {

    public List<PersonEntity> getPersons();

    public PersonEntity getPerson(Long id) ;
    
    public PersonEntity getPersonByCedula(Long cc) ;

    public PersonEntity createPerson(PersonEntity entity);

    public PersonEntity updatePerson(PersonEntity entity);

    public void deletePerson(Long id);

    //public BookEntity addBook(Long bookId, Long authorId) throws BusinessLogicException;

   // public void removeBook(Long bookId, Long authorId);

   // public List<BookEntity> replaceBooks(List<BookEntity> books, Long authorId) throws BusinessLogicException;

   // public List<BookEntity> getBooks(Long authorId);

  //  public BookEntity getBook(Long authorId, Long bookId);
}
