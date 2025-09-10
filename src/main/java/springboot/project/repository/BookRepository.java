package springboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.project.main.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
