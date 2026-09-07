package panduan.solid.apap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;

    private static BookRepositoryImpl instance;

    private BookRepositoryImpl() {
        books = new ArrayList<>();
    }

    public static BookRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BookRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findBookById(UUID id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        book.setId(UUID.randomUUID());
        books.add(book);
        return book;
    }
}