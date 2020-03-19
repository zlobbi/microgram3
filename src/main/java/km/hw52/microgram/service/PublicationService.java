package km.hw52.microgram.service;

import km.hw52.microgram.dto.LikeDTO;
import km.hw52.microgram.dto.PublicationDTO;
import km.hw52.microgram.repository.LikeRepository;
import km.hw52.microgram.repository.PublicationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepo;

    public PublicationService(PublicationRepository publicationRepo) {
        this.publicationRepo = publicationRepo;
    }

    public Slice<PublicationDTO> findAllPublications(Pageable pageable) {
        var slice = publicationRepo.findAll(pageable);
        return slice.map(PublicationDTO::from);
    }

    public Slice<PublicationDTO> findAllByUserId(String userId, Pageable pageable) {
        var slice = publicationRepo.findAllByUserId(userId, pageable);
        return slice.map(PublicationDTO::from);
    }

    public Slice<PublicationDTO> findOtherPublicationsByUserId(String userId, Pageable pageable) {
        var slice = publicationRepo.findByUserIdNotContains(userId, pageable);
        return slice.map(PublicationDTO::from);
    }
}
