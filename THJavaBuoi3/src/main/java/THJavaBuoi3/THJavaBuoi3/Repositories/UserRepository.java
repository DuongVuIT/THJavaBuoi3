package THJavaBuoi3.THJavaBuoi3.Repositories;

import THJavaBuoi3.THJavaBuoi3.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u where u.username = :username")
    public User getUserByUsername (@Param("username")String username);
    @Query("SELECT u FROM User u where u.email = :email ")
    public User getUserByEmail (@Param("email")String email);
}
