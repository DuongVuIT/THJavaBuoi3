package THJavaBuoi3.THJavaBuoi3;

import THJavaBuoi3.THJavaBuoi3.Models.Book;
import THJavaBuoi3.THJavaBuoi3.Models.Category;
import THJavaBuoi3.THJavaBuoi3.Models.Role;
import THJavaBuoi3.THJavaBuoi3.Models.User;
import THJavaBuoi3.THJavaBuoi3.Repositories.BookRepository;
import THJavaBuoi3.THJavaBuoi3.Repositories.CategoryRepository;
import THJavaBuoi3.THJavaBuoi3.Repositories.RoleRepository;
import THJavaBuoi3.THJavaBuoi3.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan("THJavaBuoi3.THJavaBuoi3.Security")
public class FillData {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void testCreateUse(){
        Category categoryCNTT = new Category();
        categoryCNTT.setName("Cong Nghe Thong Tin");
        categoryRepository.save(categoryCNTT);
        Category categoryEng = new Category();
        categoryEng.setName("Tieng Anh");
        categoryRepository.save(categoryEng);

        Book bookCNTT1 = new Book();
        bookCNTT1.setTitle("LAP TRINH WEB SPRING MVC");
        bookCNTT1.setAuthor("ANH NGUYEN");
        bookCNTT1.setPrice(50000L);
        bookCNTT1.setCategory(categoryCNTT);
        bookRepository.save(bookCNTT1);

        Book bookCNTT2 = new Book();
        bookCNTT2.setTitle("LAP TRINH WEB SPRING MVC 2");
        bookCNTT2.setAuthor("ANH NGUYEN");
        bookCNTT2.setPrice(51000L);
        bookCNTT2.setCategory(categoryCNTT);
        bookRepository.save(bookCNTT2);

        Book bookCNTT3 = new Book();
        bookCNTT3.setTitle("LAP TRINH WEB SPRING MVC 3");
        bookCNTT3.setAuthor("ANH NGUYEN");
        bookCNTT3.setPrice(52000L);
        bookCNTT3.setCategory(categoryCNTT);
        bookRepository.save(bookCNTT3);

        Book bookEng1 = new Book();
        bookEng1.setTitle("IELTS");
        bookEng1.setAuthor("CAMBRIDGE");
        bookEng1.setPrice(54000L);
        bookEng1.setCategory(categoryEng);
        bookRepository.save(bookEng1);

        Role roleUser = new Role();
        roleUser.setName("USER");
        roleRepository.save(roleUser);

        Role roleCreater = new Role();
        roleCreater.setName("CREATE");
        roleRepository.save(roleCreater);

        Role roleEditor = new Role();
        roleEditor.setName("EDITOR");
        roleRepository.save(roleEditor);

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleRepository.save(roleAdmin);

        User user1 = new User();
        user1.setUsername("user1");
        user1.setEmail("user1@gmail.com");
        user1.setEnabled(true);
        user1.setPassword(passwordEncoder.encode("123456"));
        user1.addRoles(roleUser);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setEmail("user2@gmail.com");
        user2.setEnabled(true);
        user2.setPassword(passwordEncoder.encode("123456"));
        user2.addRoles(roleUser);
        userRepository.save(user2);

        User create1 = new User();
        create1.setUsername("create1");
        create1.setEmail("create1@gmail.com");
        create1.setEnabled(true);
        create1.setPassword(passwordEncoder.encode("123456"));
        create1.addRoles(roleCreater);
        userRepository.save(create1);

        User create2 = new User();
        create2.setUsername("create2");
        create2.setEmail("create1@gmail.com");
        create2.setEnabled(true);
        create2.setPassword(passwordEncoder.encode("123456"));
        create2.addRoles(roleCreater);
        userRepository.save(create2);

        User editor1 = new User();
        editor1.setUsername("editor1");
        editor1.setEmail("editor1@gmail.com");
        editor1.setEnabled(true);
        editor1.setPassword(passwordEncoder.encode("123456"));
        editor1.addRoles(roleEditor);
        userRepository.save(editor1);

        User editor2 = new User();
        editor2.setUsername("editor2");
        editor2.setEmail("editor2@gmail.com");
        editor2.setEnabled(true);
        editor2.setPassword(passwordEncoder.encode("123456"));
        editor2.addRoles(roleEditor);
        userRepository.save(editor2);

        User admin1 = new User();
        admin1.setUsername("admin1");
        admin1.setEmail("editor2@gmail.com");
        admin1.setEnabled(true);
        admin1.setPassword(passwordEncoder.encode("123456"));
        admin1.addRoles(roleAdmin);
        userRepository.save(admin1);


        User admin2 = new User();
        admin2.setUsername("admin2");
        admin2.setEmail("admin2@gmail.com");
        admin2.setEnabled(true);
        admin2.setPassword(passwordEncoder.encode("123456"));
        admin2.addRoles(roleAdmin);
        userRepository.save(admin2);


    }
}
