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
public class CommentController {
    @Autowired
    CommentRepository commentRepo;

    @GetMapping("/comments/{commentFor}")
    public String getCommentsForPubl(@PathVariable("commentFor") String commentFor, Model model) {
        List<Comment> comments = commentRepo.findAllByCommentForId(commentFor);
        model.addAttribute("comments", comments);
        return "comments";
    }
}
