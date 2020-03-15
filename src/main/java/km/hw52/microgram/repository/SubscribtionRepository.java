package km.hw52.microgram.repository;

import km.hw52.microgram.model.Subscribtion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscribtionRepository extends CrudRepository<Subscribtion, String> {
    List<Subscribtion> findAllBySubscriber_Id(String id);
}
// get subscriber
// get subscribiant

