package THJavaBuoi3.THJavaBuoi3.Services;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import THJavaBuoi3.THJavaBuoi3.Repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
 @Autowired
    private BookRepository bookRepository;
 public List<Book> listAll(){
     return bookRepository.findAll();
 }
 public void save(Book product){
     bookRepository.save(product);

 }
 public Book get(Long id){
     return bookRepository.findById(id).get();
 }
 public void delete(long id){
     bookRepository.deleteById(id);
 }
}
