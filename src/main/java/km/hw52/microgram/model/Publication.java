package km.hw52.microgram.model;

import km.hw52.microgram.util.Generator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

import static java.lang.String.valueOf;

@Data
@Document
public class Publication {
    @Id
    private String id;
    @DBRef
    private User user;
    private String image;
    private String description;
    private LocalDate date;
    private int likesCount;
    private int commentsCount;

    private static Random r = new Random();

    public static Publication make(User user) {
        Publication p = new Publication();
        String image = Generator.makeName();
        p.setId(valueOf(Objects.hash(image)));
        p.setImage(image.toLowerCase() + ".jpg");
        p.setUser(user);
        p.setDescription(Generator.makeDescription());
        p.setDate(LocalDate.now().minusDays(r.nextInt(20)+2));
        return p;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id='" + id + '\'' +
                ", userLogin='" + user.getLogin() + '\'' +
                ", image='" + image + '\'' +
                ", likes='" + (likesCount) + '\'' +
                ", comments='" + (commentsCount) + '\'' +
                ", description=" + description + '\'' +
                ", date=" + date.toString() +
                '}';
    }

    public void plusLikesCount() { this.likesCount++; }

    public void minusLikesCount() { this.likesCount--; }

    public void plusCommentsCount() { this.commentsCount++; }

    public void minusCommentsCount() { this.commentsCount--; }
}
