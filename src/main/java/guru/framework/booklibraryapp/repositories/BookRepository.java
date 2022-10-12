package guru.framework.booklibraryapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.framework.booklibraryapp.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
