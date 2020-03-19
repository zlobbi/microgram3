package km.hw52.microgram.dto;

import km.hw52.microgram.model.Comment;
import km.hw52.microgram.model.Publication;
import km.hw52.microgram.model.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDTO {

    public static CommentDTO from(Comment comment) {
        return builder()
                .id(comment.getId())
                .commentator(comment.getCommentator())
                .commentFor(comment.getCommentFor())
                .text(comment.getText())
                .date(comment.getDate())
                .build();
    }

    private String id;
    private User commentator;
    private Publication commentFor;
    private String text;
    private LocalDate date;

}
