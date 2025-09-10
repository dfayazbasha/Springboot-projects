package springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.project.main.Book;
import springboot.project.services.Bookservice;

import java.util.List;

@RestController
@RequestMapping("/POST")
public class Bookcontroller {
    @Autowired

    private Bookservice bookservice;
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookservice.addbook(book);
    }
      @PostMapping("/books/bulk")
    public List<Book> createBook(@RequestBody List<Book> books) {
        return bookservice.addmultilevelbooks(books);
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        return bookservice.getbookbyid(id);
    }
    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookservice.getallbooks();
    }
    @PutMapping ("/update/{id}")
    public Book updateBook(@PathVariable int id,@RequestBody Book book) {
        return bookservice.updatebook(id,book);
    }
    @DeleteMapping("/Delete/{id}")
    public String   deletebook(@PathVariable int id){
         bookservice.deletebook(id);
        return "deleted successfully";
    }


}
