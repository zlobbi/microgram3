package km.hw52.microgram.controler;

import km.hw52.microgram.model.Publication;
import km.hw52.microgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@org.springframework.stereotype.Controller
public class PublicationController {
    @Autowired
    PublicationRepository publicationRepo;

    @GetMapping("/publications/{userId}")
    public String getPublicationsByUserId(@PathVariable("userId") String userId, Model model) {
        List<Publication> publ = publicationRepo.findAllByUserId(userId);
        model.addAttribute("publications", publ);
        return "publications";
    }

    @GetMapping("/otherpublications/{userId}")
    public String getOtherUsersPublicationsByUserLogin(@PathVariable("userId") String userId, Model model) {
        List<Publication> publ = publicationRepo.findByUser_IdNotContains(userId);
        model.addAttribute("publications", publ);
        return "publications";
    }
}
