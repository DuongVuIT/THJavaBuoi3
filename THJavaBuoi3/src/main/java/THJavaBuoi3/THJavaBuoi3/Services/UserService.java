package THJavaBuoi3.THJavaBuoi3.Services;

import THJavaBuoi3.THJavaBuoi3.Models.Role;
import THJavaBuoi3.THJavaBuoi3.Models.User;
import THJavaBuoi3.THJavaBuoi3.Repositories.RoleRepository;
import THJavaBuoi3.THJavaBuoi3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listAll(){
        return userRepository.findAll();
    }
    public void save(User user){
        userRepository.save(user);
    }
    public User get(Long id){
        return userRepository.findById(id).get();
    }
    public void delete(long id){
        userRepository.deleteById(id);
    }
}
