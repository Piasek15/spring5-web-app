package pl.piasecki.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.piasecki.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
