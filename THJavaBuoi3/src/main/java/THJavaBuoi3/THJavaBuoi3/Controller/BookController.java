package THJavaBuoi3.THJavaBuoi3.Controller;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import THJavaBuoi3.THJavaBuoi3.Services.BookService;
import THJavaBuoi3.THJavaBuoi3.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String viewAllBook(Model model){
        List<Book> listBook = bookService.listAll();
        model.addAttribute("books",listBook);
        return "book/index";
    }
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/new")
    public String showNewBookPage(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        model.addAttribute("categories",categoryService.listAll());
        return "book/new_book";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute ("book") Book book){
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String showEditBookPage(@PathVariable("id") Long id,Model model){
        Book book = bookService.get(id);
        if(book == null){
            return "not found";
        }else {
            model.addAttribute("categories",categoryService.listAll());
            model.addAttribute("book",book);
            return "book/edit";
        }

    }
    @GetMapping("/delete/{id}")
        public String deleteBook(@PathVariable("id") Long id){
            Book book = bookService.get(id);
            if(book == null){
                return "notfound";
            }else{
                 bookService.delete(id);
                return "redirect:/books";
            }
    }
}
