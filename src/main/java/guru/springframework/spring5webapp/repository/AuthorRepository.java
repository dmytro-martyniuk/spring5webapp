package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
