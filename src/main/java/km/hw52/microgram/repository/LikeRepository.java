package km.hw52.microgram.repository;

import km.hw52.microgram.model.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, String> {

    List<Like> findAllByLikeForPublication(String likeFor);

    boolean findByLikeByUser_IdAndLikeForPublication_Id(String userId, String publicationId);
}
// get publication date
// get publisher
// get publication liker's
