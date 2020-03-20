package km.hw52.microgram.service;

import km.hw52.microgram.dto.SubscribtionDTO;
import km.hw52.microgram.repository.SubscribtionRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class SubscribtionService {
    private final SubscribtionRepository subscribtionRepo;

    public SubscribtionService(SubscribtionRepository subscribtionRepo) {
        this.subscribtionRepo = subscribtionRepo;
    }

    public Slice<SubscribtionDTO> findAllSubscribtions(Pageable pageable) {
        var slice = subscribtionRepo.findAll(pageable);
        return slice.map(SubscribtionDTO::from);
    }

//    public Slice<SubscribtionDTO> findAllSubscribersByUserId(String userId, Pageable pageable) {
//        var slice = subscribtionRepo.findAllByUserId(userId, pageable);
//        return slice.map(PublicationDTO::from);
//    }
//
//    public Slice<PublicationDTO> findOtherPublicationsByUserId(String userId, Pageable pageable) {
//        var slice = publicationRepo.findByUserIdNotContains(userId, pageable);
//        return slice.map(PublicationDTO::from);
//    }
}
