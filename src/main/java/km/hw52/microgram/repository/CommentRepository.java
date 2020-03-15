package km.hw52.microgram.repository;

import km.hw52.microgram.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {
    List<Comment> findAllByCommentForId(String commentForId);
}
// get publication date
// get publisher
// get publication liker's
