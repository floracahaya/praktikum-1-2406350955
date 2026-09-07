package panduan.solid.apap;

import java.util.List;
import java.util.UUID;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    private static BookServiceImpl instance;

    private BookServiceImpl() {
        bookRepository = BookRepositoryImpl.getInstance();
    }

    public static BookServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(UUID id) throws Exception {
        Book book = bookRepository.findBookById(id);

        if (book == null) {
            throw new Exception("Book not found");
        }

        return book;
    }

    @Override
    public Book addBook(Book book) {
        if (book.getStock() < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        return bookRepository.addBook(book);
    }
}