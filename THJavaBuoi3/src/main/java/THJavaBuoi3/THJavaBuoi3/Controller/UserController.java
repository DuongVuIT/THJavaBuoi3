package THJavaBuoi3.THJavaBuoi3.Controller;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import THJavaBuoi3.THJavaBuoi3.Models.User;
import THJavaBuoi3.THJavaBuoi3.Services.BookService;
import THJavaBuoi3.THJavaBuoi3.Services.CategoryService;
import THJavaBuoi3.THJavaBuoi3.Services.RoleService;
import THJavaBuoi3.THJavaBuoi3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping
    public String viewAllUser(Model model){
        List<User> listUser = userService.listAll();
        model.addAttribute("users",listUser);
        return "user/index";
    }

    @GetMapping("/new")
    public String showNewUserPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("roles",roleService.listAll());
        return "user/new_user";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user)
     throws IOException {
         user.setPassword(passwordEncoder.encode((user.getPassword())));
         userService.save(user);
         return "redirect:/users";
        }

    @GetMapping("/edit/{id}")
    public String showEditUserPage(@PathVariable("id") Long id, Model model){
        User user = userService.get(id);
        if(user == null){
            return "not found";
        }else {
            model.addAttribute("roles",roleService.listAll());
            model.addAttribute("user",user);
            return "user/edit";
        }

    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        User user = userService.get(id);
        if(user == null){
            return "notfound";
        }else{
            userService.delete(id);
            return "redirect:/users";
        }
    }

}
