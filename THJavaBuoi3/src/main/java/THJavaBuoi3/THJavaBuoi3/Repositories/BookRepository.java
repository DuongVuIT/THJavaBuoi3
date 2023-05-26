package THJavaBuoi3.THJavaBuoi3.Repositories;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
