    package springboot.project.services;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Service;
    import springboot.project.main.Book;
    import springboot.project.main.Bookstore;
    import springboot.project.repository.BookstoreRepository;

    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class BookstoreService {
         @Autowired
        private BookstoreRepository bookstoreRepository;

         public List<Bookstore> getAllBooks(){
             return bookstoreRepository.findAll();
         }
          public Bookstore getBooksById(int id){
             return bookstoreRepository.findById(id).get();
          }
          public List<Bookstore>  getBooksByAuthor(String author){

              return bookstoreRepository.findByAuthorNative(author);



          }
          public Bookstore addBook(Bookstore book){
    //         bookstoreRepository.save(book);
              return bookstoreRepository.save(book);
          }

          public List<Bookstore> addmultiplebook(List<Bookstore> book){
             return bookstoreRepository.saveAll(book);
          }
          public Bookstore updateBook(int id,Bookstore book){
              Bookstore b=bookstoreRepository.findById(id).get();
              b.setAuthor(book.getAuthor());
              b.setPrice(book.getPrice());
              b.setId(book.getId());
              b.setStock(b.getStock());
              b.setTitle(book.getTitle());
              return bookstoreRepository.save(b);
          }

          public Bookstore updateBookPriceOrStock(int id, double price, int stock){
             Bookstore b=bookstoreRepository.findById(id)
              .orElseThrow(()->new RuntimeException("not found with id:"+id));

             b.setPrice(price);
             b.setStock(stock);
             return bookstoreRepository.save(b);
          }
          public Bookstore updateprice(int id,double price){
              Bookstore b=bookstoreRepository.findById(id)
                      .orElseThrow(()->new RuntimeException("not found with id:"+id));

              b.setPrice(price);
              return bookstoreRepository.save(b);
          }
          public Bookstore updatestock(int id,int stock){
              Bookstore b=bookstoreRepository.findById(id)
                      .orElseThrow(()->new RuntimeException("not found with id:"+id));

              b.setStock(stock);
              return bookstoreRepository.save(b);
          }


          public void deleteBook(int id){
              bookstoreRepository.deleteById(id);


          }
          public void  deleteAllBooks(){
             bookstoreRepository.deleteAll();
          }

          public List<Bookstore> searchBooksbytitle(String keyword){
              return bookstoreRepository.findByTitleContainingIgnoreCase(keyword);

          }
        public List<Bookstore> getBooksSortedByPrice() {
            return bookstoreRepository.findAll(Sort.by("price"));
        }


        public Bookstore Buybook(int id,int quantty){
             Bookstore b1=bookstoreRepository.findById(id).get();
             if(b1.getStock()<quantty){
                 throw new RuntimeException("not enough stock"+ b1.getStock());
             }
             b1.setStock(b1.getStock()-quantty);
             return bookstoreRepository.save(b1);
        }







    }
