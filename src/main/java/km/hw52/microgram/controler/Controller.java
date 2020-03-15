package km.hw52.microgram.controler;

import km.hw52.microgram.model.Comment;
import km.hw52.microgram.model.Like;
import km.hw52.microgram.model.Publication;
import km.hw52.microgram.model.User;
import km.hw52.microgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    UserRepository userRepo;
    @Autowired
    PublicationRepository publicationRepo;
    @Autowired
    SubscribtionRepository subscribtionRepo;
    @Autowired
    CommentRepository commentRepo;
    @Autowired
    LikeRepository likeRepo;

    @GetMapping
    public String rootHandler(Model model) {
        var map = StreamSupport.stream(userRepo.findAll().spliterator(), true)
                .collect(Collectors.toList());
        model.addAttribute("users", map);
        return "index";
    }

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

    @GetMapping("/comments/{commentFor}")
    public String getCommentsForPubl(@PathVariable("commentFor") String commentFor, Model model) {
        List<Comment> comments = commentRepo.findAllByCommentForId(commentFor);
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping("/likes/{likeFor}")
    public String getLikesForPubl(@PathVariable("likeFor") String likeFor, Model model) {
        List<Like> likes = likeRepo.findAllByLikeForPublication(likeFor);
        model.addAttribute("likes", likes);
        return "likes";
    }

    @GetMapping("/profile/{login}")
    public String getUserByLogin(@PathVariable("login") String login, Model model) {
        User u = userRepo.findBylogin(login);
        model.addAttribute("user", u);
        return "profile";
    }
}
