package spring_boot.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.graphql.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
