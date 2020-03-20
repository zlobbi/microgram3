package km.hw52.microgram.controler;

import km.hw52.microgram.annotations.ApiPageable;
import km.hw52.microgram.dto.SubscribtionDTO;
import km.hw52.microgram.repository.PublicationRepository;
import km.hw52.microgram.repository.SubscribtionRepository;
import km.hw52.microgram.service.PublicationService;
import km.hw52.microgram.service.SubscribtionService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/subscribtions")
public class SubscribtionController {
    private final PublicationService publicationService;
    private final SubscribtionService subscribtionService;

    public SubscribtionController(PublicationService publicationService, SubscribtionService subscribtionService) {
        this.publicationService = publicationService;
        this.subscribtionService = subscribtionService;
    }

    @ApiPageable
    @GetMapping
    public Slice<SubscribtionDTO> getAllSubscritbtions(@ApiIgnore Pageable pageable) {
        return subscribtionService.findAllSubscribtions(pageable);
    }

    @GetMapping("/{userId}")
    public String getPublicationsByUserId(@PathVariable("userId") String userId, Model model) {
//        List<Subscribtion> subs = subscribtionRepo.findAllBySubscriber_Id(userId);
//        List<Publication> publ = new ArrayList<>();
//        for(Subscribtion s : subs) {
//            publ = StreamSupport.stream(publicationRepo.findAllByUserId(s.getSubscribiant().getId()).spliterator(), true )
//                    .collect(Collectors.toList());
//        }
//        model.addAttribute("publications", publ);
        return "uifollow";
    }
}
