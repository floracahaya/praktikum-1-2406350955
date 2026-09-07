package panduan.solid.apap;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> findAll();
    Book findBookById(UUID id) throws Exception;
    Book addBook(Book book);
}