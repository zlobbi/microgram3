package km.hw52.microgram.repository;

import km.hw52.microgram.model.Subscribtion;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscribtionRepository extends PagingAndSortingRepository<Subscribtion, String> {
    Slice<Subscribtion> findAllBySubscriber_Id(String id);
}
// get subscriber
// get subscribiant

