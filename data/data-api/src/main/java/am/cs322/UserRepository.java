package am.cs322;

import am.cs322.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}
