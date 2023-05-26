package THJavaBuoi3.THJavaBuoi3.Controller;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import THJavaBuoi3.THJavaBuoi3.Models.Category;
import THJavaBuoi3.THJavaBuoi3.Services.BookService;
import THJavaBuoi3.THJavaBuoi3.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cates")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String viewAllCate(Model model){
        List<Category> listCate = categoryService.listAll();
        model.addAttribute("cates",listCate);
        return "cate/index";
    }
    @GetMapping("/new")
    public String showNewCatePage(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "cate/new_cate";
    }
    @PostMapping("/save")
    public String saveCate(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/cates";
    }
    @GetMapping("/edit/{id}")
    public String showEditCatePage(@PathVariable("id") Long id, Model model){
        Category category = categoryService.get(id);
        if(category == null){
            return "notfound";
        }else {

            model.addAttribute("category",category);
            return "cate/edit";
        }

    }
    @GetMapping("/delete/{id}")
    public String deleteCate(@PathVariable("id") Long id){
        Category category = categoryService.get(id);
        if(category == null){
            return "notfound";
        }else{
            categoryService.delete(id);
            return "redirect:/cates";
        }
    }
}
