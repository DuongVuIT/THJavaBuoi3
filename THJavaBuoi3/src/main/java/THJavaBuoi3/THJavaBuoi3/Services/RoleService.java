package THJavaBuoi3.THJavaBuoi3.Services;

import THJavaBuoi3.THJavaBuoi3.Models.Category;
import THJavaBuoi3.THJavaBuoi3.Models.Role;
import THJavaBuoi3.THJavaBuoi3.Repositories.CategoryRepository;
import THJavaBuoi3.THJavaBuoi3.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> listAll(){
        return roleRepository.findAll();
    }
    public void save(Role role){
        roleRepository.save(role);
    }
    public Role get(Long id){
        return roleRepository.findById(id).get();
    }
    public void delete(long id){
        roleRepository.deleteById(id);
    }
}
