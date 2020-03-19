package km.hw52.microgram.controler;

import km.hw52.microgram.annotations.ApiPageable;
import km.hw52.microgram.dto.CommentDTO;
import km.hw52.microgram.service.CommentService;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiPageable
    @GetMapping
    public Slice<CommentDTO> getAllComments(@ApiIgnore Pageable pageable) {
        return commentService.findAllComments(pageable);
    }

    @GetMapping("/{commentFor}")
    public Slice<CommentDTO> getAllCommentsForPublicationById(String id, @ApiIgnore Pageable pageable) {
        return commentService.findAllCommentsForPublication(id, pageable);
    }
}
