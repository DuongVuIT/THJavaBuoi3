package THJavaBuoi3.THJavaBuoi3.Controller;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import THJavaBuoi3.THJavaBuoi3.Models.Role;
import THJavaBuoi3.THJavaBuoi3.Services.BookService;
import THJavaBuoi3.THJavaBuoi3.Services.CategoryService;
import THJavaBuoi3.THJavaBuoi3.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public String viewAllRole(Model model){
        List<Role> listRole = roleService.listAll();
        model.addAttribute("roles",listRole);
        return "role/index";
    }

    @GetMapping("/new")
    public String showNewRole(Model model){
        Role role = new Role();
        model.addAttribute("role",role);
        model.addAttribute("roles",roleService.listAll());
        return "role/new_role";
    }
    @PostMapping("/save")
    public String saveRole(@ModelAttribute("role") Role role){
        roleService.save(role);
        return "redirect:/roles";
    }
    @GetMapping("/edit/{id}")
    public String showEditRolePage(@PathVariable("id") Long id, Model model){
        Role role = roleService.get(id);
        if(role == null){
            return "not found";
        }else {
            model.addAttribute("roles",roleService.listAll());
            model.addAttribute("role",role);
            return "role/edit";
        }

    }
    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id){
        Role role = roleService.get(id);
        if(role == null){
            return "notfound";
        }else{
            roleService.delete(id);
            return "redirect:/roles";
        }
    }
}
