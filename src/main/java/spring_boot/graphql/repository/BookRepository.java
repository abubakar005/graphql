package spring_boot.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.graphql.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
