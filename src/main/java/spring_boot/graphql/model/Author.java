package spring_boot.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
