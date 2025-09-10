package springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.project.main.Bookstore;
import springboot.project.services.BookstoreService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;
    @PostMapping("/add")
    public Bookstore addBook(@RequestBody Bookstore bookstore) {
        return bookstoreService .addBook(bookstore);
    }
    @PostMapping("/addmultiple")
    public List<Bookstore> addMultipleBooks(@RequestBody List<Bookstore> bookstore) {
        return bookstoreService.addmultiplebook(bookstore);

    }
    @GetMapping("/allbooks")
    public List<Bookstore> getAllBooks() {
        return bookstoreService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Bookstore getBooksById(@PathVariable int id){
        return bookstoreService.getBooksById(id);
    }
    @GetMapping("/author/{author}")
    public List<Bookstore> getBooksByAuthor(@PathVariable String author){
        List<Bookstore> books = bookstoreService.getBooksByAuthor(author);
//        if (books.isEmpty()) {
////            throw new RuntimeException("No books found for author: " + author);
//
//        }
        return books;
    }
    @GetMapping("/search")
    public List<Bookstore> searchBooks(@RequestParam String keyword){
        List<Bookstore> b=bookstoreService.searchBooksbytitle(keyword);
        if(b.isEmpty()){
            System.out.println("No book is teher with this key word!!!!");
            return b;
        }else{
            return b;
        }
    }
    @GetMapping("/sort/price")
    public List<Bookstore> getBooksByPrice(){
        return bookstoreService.getBooksSortedByPrice();
    }
    @PutMapping("/{id}")
    public Bookstore updateBooks(@PathVariable int id, @RequestBody Bookstore bookstore){
        return bookstoreService.updateBook(id, bookstore);
    }
    @PutMapping("/updateprice/{id}")
    public Bookstore updatePrice(@PathVariable int id,@RequestBody double price){
        return bookstoreService.updateprice(id,price);
    }
    @PutMapping("/updatestock/{id}")
    public Bookstore updateStock(@PathVariable int id,@RequestBody int stock){
        return bookstoreService.updatestock(id, stock);
    }
    @DeleteMapping("/{id}")
    public String deleteBooks(@PathVariable int id){
        bookstoreService.deleteBook(id);
        return "book deleted";
    }
    @DeleteMapping("/deleteall")
    public String deleteAllBooks(){
         bookstoreService.deleteAllBooks();
        return "all books are deleted";
    }

    @PatchMapping("/buybook/{id}")
    public Bookstore buyBook(@PathVariable int id,@RequestBody int quantity){
        return bookstoreService.Buybook(id, quantity);
    }

}
