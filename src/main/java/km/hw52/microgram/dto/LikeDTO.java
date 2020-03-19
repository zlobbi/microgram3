package km.hw52.microgram.dto;

import km.hw52.microgram.model.Comment;
import km.hw52.microgram.model.Like;
import km.hw52.microgram.model.Publication;
import km.hw52.microgram.model.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LikeDTO {

    public static LikeDTO from(Like like) {
        return builder()
                .id(like.getId())
                .likeFor(like.getLikeForPublication())
                .likeBy(like.getLikeByUser())
                .date(like.getDate())
                .build();
    }

    private String id;
    private Publication likeFor;
    private User likeBy;
    private LocalDate date;

}
