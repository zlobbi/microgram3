package km.hw52.microgram.repository;

import km.hw52.microgram.model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
    Slice<Comment> findAllByCommentForId(String commentForId, Pageable pageable);
}
// get publication date
// get publisher
// get publication liker's
