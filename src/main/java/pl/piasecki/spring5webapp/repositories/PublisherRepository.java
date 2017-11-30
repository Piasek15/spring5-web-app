package pl.piasecki.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.piasecki.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
