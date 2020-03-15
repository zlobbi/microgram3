package km.hw52.microgram.controler;

import km.hw52.microgram.model.User;
import km.hw52.microgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Controller
public class UserController {
    @Autowired
    UserRepository userRepo;

    @GetMapping("/allusers")
    public String getUsers(Model model) {
        var map = StreamSupport.stream(userRepo.findAll().spliterator(), true)
                .collect(Collectors.toList());
        model.addAttribute("users", map);
        return "allusers";
    }

    @GetMapping("/profile/{login}")
    public String getUserByLogin(@PathVariable("login") String login, Model model) {
        User u = userRepo.findBylogin(login);
        model.addAttribute("user", u);
        return "profile";
    }
}
