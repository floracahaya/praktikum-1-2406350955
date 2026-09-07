package panduan.solid.apap;

import java.util.List;
import java.util.UUID;

public interface BookRepository {
    List<Book> findAll();
    Book findBookById(UUID id);
    Book addBook(Book book);
}