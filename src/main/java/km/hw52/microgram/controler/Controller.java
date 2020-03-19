package km.hw52.microgram.controler;

import km.hw52.microgram.model.User;
import km.hw52.microgram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final UserRepository userRepo;

    public Controller(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public Iterable<User> rootHandler() {
        return userRepo.findAll();
    }

}
