package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
