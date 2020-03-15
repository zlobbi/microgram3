package km.hw52.microgram.repository;

import km.hw52.microgram.model.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, String> {

    List<Like> findAllByLikeForPublication(String likeFor);
}
// get publication date
// get publisher
// get publication liker's
