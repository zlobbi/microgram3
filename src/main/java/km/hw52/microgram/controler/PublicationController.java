package km.hw52.microgram.controler;

import km.hw52.microgram.annotations.ApiPageable;
import km.hw52.microgram.dto.PublicationDTO;
import km.hw52.microgram.model.Publication;
import km.hw52.microgram.repository.*;
import km.hw52.microgram.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@RestController
@RequestMapping("/publications")
public class PublicationController {
    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @ApiPageable
    @GetMapping
    public Slice<PublicationDTO> getAllPublications(@ApiIgnore Pageable pageable) {
        return publicationService.findAllPublications(pageable);
    }

    @GetMapping("/{userId}")
    public Slice<PublicationDTO> getPublicationsByUserId(@PathVariable("userId") String userId, @ApiIgnore Pageable pageable) {
        return publicationService.findAllByUserId(userId, pageable);
    }

    @GetMapping("/other/{userId}")
    public Slice<PublicationDTO> getOtherUsersPublicationsByUserEmail(@PathVariable("userId") String userId, @ApiIgnore Pageable pageable) {
        return publicationService.findOtherPublicationsByUserId(userId, pageable);
    }
}
