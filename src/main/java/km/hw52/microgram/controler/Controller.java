package km.hw52.microgram.controler;

import km.hw52.microgram.model.User;
import km.hw52.microgram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserRepository userRepo;

    @GetMapping
    public Iterable<User> rootHandler() {
        return userRepo.findAll();
    }

}
