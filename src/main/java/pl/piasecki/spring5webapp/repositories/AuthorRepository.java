package pl.piasecki.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.piasecki.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{



}
