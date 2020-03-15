package km.hw52.microgram.model;

import km.hw52.microgram.util.Generator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Random;

import static java.lang.String.valueOf;

@Data
@Document
public class Comment {
    private static Random r = new Random();

    @Id
    private String id;
    @DBRef
    private User commentator;
    @DBRef
    private Publication commentFor;
    private String text;
    private LocalDate date;

    public static Comment make(User commentator, Publication commentFor, LocalDate publicationDate) {
        int t = LocalDate.now().compareTo(publicationDate);
        String text = Generator.makeDescription();
        Comment c = new Comment();
        String id = valueOf(text.indent(1).hashCode());
        c.setId(id);
        c.setCommentator(commentator);
        c.setCommentFor(commentFor);
        c.setText(text);
        c.setDate(LocalDate.now().minusDays(r.nextInt(t)+1));
        return c;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", commentatorLogin='" + commentator.getLogin() + '\'' +
                ", commentFor='" + commentFor.getImage() + '\'' +
                ", text=" + text + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
