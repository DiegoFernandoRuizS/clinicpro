package co.edu.uniandes.hospital.api;
import co.edu.uniandes.hospital.entities.ServiceEntity;
import co.edu.uniandes.hospital.exceptions.BusinessLogicException;
import java.util.List;

public interface IServiceLogic {

    public List<ServiceEntity> getServices();

    public ServiceEntity getService(Long id) ;

    public ServiceEntity createService(ServiceEntity entity);

    public ServiceEntity updateService(ServiceEntity entity);

    public void deleteService(Long id);

    //public BookEntity addBook(Long bookId, Long authorId) throws BusinessLogicException;

   // public void removeBook(Long bookId, Long authorId);

   // public List<BookEntity> replaceBooks(List<BookEntity> books, Long authorId) throws BusinessLogicException;

   // public List<BookEntity> getBooks(Long authorId);

  //  public BookEntity getBook(Long authorId, Long bookId);
}
