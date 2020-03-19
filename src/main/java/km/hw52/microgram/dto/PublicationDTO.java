package km.hw52.microgram.dto;

import km.hw52.microgram.model.Publication;
import km.hw52.microgram.model.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PublicationDTO {

    public static PublicationDTO from(Publication publication) {
        return builder()
                .id(publication.getId())
                .user(publication.getUser())
                .image(publication.getImage())
                .description(publication.getDescription())
                .date(publication.getDate())
                .likesCount(publication.getLikesCount())
                .commentsCount(publication.getCommentsCount())
                .build();
    }

    private String id;
    private User user;
    private String image;
    private String description;
    private LocalDate date;
    private int likesCount;
    private int commentsCount;

}
