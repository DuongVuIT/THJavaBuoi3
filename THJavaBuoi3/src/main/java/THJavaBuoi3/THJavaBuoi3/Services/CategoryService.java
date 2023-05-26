package THJavaBuoi3.THJavaBuoi3.Services;

import THJavaBuoi3.THJavaBuoi3.Models.Category;
import THJavaBuoi3.THJavaBuoi3.Repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> listAll(){
        return categoryRepository.findAll();
    }
    public void save(Category category){
        categoryRepository.save(category);
    }
    public Category get(Long id){
        return categoryRepository.findById(id).get();
    }
    public void delete(long id){
        categoryRepository.deleteById(id);
    }
}
