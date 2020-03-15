package km.hw52.microgram.model;

import km.hw52.microgram.util.Generator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

import static java.lang.String.valueOf;

@Data
@Document(collection = "users")
@CompoundIndex(def = "{'email' : 1, 'login' : 1}")
public class User {

    @Id
    private String id;
    private String login;
    private String email;
    private String password;
    private int publicationsCount = 0;
    private int subscribersCount = 0;
    private int subscribtionsCount = 0;

    public static User make() {
        User u = new User();
        String name = Generator.makeName().toLowerCase();
        u.setId(valueOf(Objects.hash(name)));
        u.setLogin(name);
        u.setEmail(Generator.makeEmail() + ".com");
        u.setPassword(Generator.makePassword());
        return u;
    }

    public static User make(String login) {
        User u = new User();
        u.setLogin(login);
        return u;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subscribers='" + subscribersCount + '\'' +
                ", subscribtions='" + (subscribtionsCount) + '\'' +
                ", publications=" + publicationsCount +
                '}';
    }

    // Publications actions -----------------------------
    public void plusPublication() { this.publicationsCount++; }

    public int getPublicationsCoutn() { return this.publicationsCount; }

    // Subscribtions actions -----------------------------

    public void plusSubscribtionsCount() {
        this.subscribtionsCount++;
    }

    public void minusSubscribtionsCount() {
        this.subscribtionsCount--;
    }

    public int getSubscribtionsCount() {
        return this.subscribtionsCount;
    }


    // Subscribers actions -----------------------------

    public void plusSubscribersCount() {
        this.subscribersCount++;
    }

    public void minusSubscribersCount() {
        this.subscribersCount--;
    }

    public int getSubscribersCount() {
       return this.subscribersCount;
    }
}
