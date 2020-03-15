package km.hw52.microgram.controler;

import km.hw52.microgram.model.Like;
import km.hw52.microgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.stereotype.Controller
public class LikeController {
    @Autowired
    LikeRepository likeRepo;

    @GetMapping("/likes/{likeFor}")
    public String getLikesForPubl(@PathVariable("likeFor") String likeFor, Model model) {
        List<Like> likes = likeRepo.findAllByLikeForPublication(likeFor);
        model.addAttribute("likes", likes);
        return "likes";
    }

    @GetMapping("/like/{byId}/{forId}")
    public String doLike(@PathVariable("byId") String by, @PathVariable("forId") String forId) {
        if(!likeRepo.findByLikeByUser_IdAndLikeForPublication_Id(by, forId)) {
            // action
        }
        // than redirect to publication view
        return "";
    }
}
