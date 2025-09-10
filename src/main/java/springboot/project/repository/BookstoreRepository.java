package springboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.project.main.Bookstore;

import java.util.List;

@Repository
public interface BookstoreRepository extends JpaRepository<Bookstore, Integer> {
    List<Bookstore> findByTitleContaining(String keyword);

    List<Bookstore> findByAuthorIgnoreCase(String author);
    @Query(value = "SELECT * FROM bookstore WHERE LOWER(author) = LOWER(:author)", nativeQuery = true)
    List<Bookstore> findByAuthorNative(@Param("author") String author);
    List<Bookstore> findByTitleContainingIgnoreCase(String keyword);


}
