package km.hw52.microgram.repository;

import km.hw52.microgram.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findBylogin(String login);

    User findByEmail(String email);

    User existsByEmail(String email);
}
// add searching user by name
// verify user existence by email
// get comments for publication
// get user subscriptions count
// get user subscribers count
