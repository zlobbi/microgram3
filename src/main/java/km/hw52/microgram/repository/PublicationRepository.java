package km.hw52.microgram.repository;

import km.hw52.microgram.model.Publication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicationRepository extends CrudRepository<Publication, String> {
    List<Publication> findAllByUserId(String userId);

    List<Publication> findByUser_IdNotContains(String userId);
}
// get publication date
// get publisher
// get publication liker's
