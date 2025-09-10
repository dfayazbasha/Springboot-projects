package springboot.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.project.main.Book;
import springboot.project.repository.BookRepository;

import java.util.List;
@Service
public class Bookservice {

    @Autowired
    private BookRepository bookRepository;
    public Book addbook(Book book){
         return bookRepository.save(book);
    }
    public List<Book> addmultilevelbooks(List<Book> book){
        return bookRepository.saveAll(book);
    }
    public List<Book> getallbooks(){
        return bookRepository.findAll();
    }
    public Book getbookbyid(int id){
        return bookRepository.findById(id).get();
    }
    public Book updatebook(int id ,Book book){
        Book book1 = bookRepository.findById(id).get();
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        book1.setAvailable(book.isAvailable());
        return bookRepository.save(book1);
    }
    public String  deletebook(int id){
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }
}
