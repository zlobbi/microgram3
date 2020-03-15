package km.hw52.microgram.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Random;

import static java.lang.String.valueOf;

@Data
@Document
@CompoundIndex(def = "{'subscriber' : 1, 'subscribiant' : 1}")
public class Subscribtion {

    @Id
    private String id;
    @DBRef
    private User subscriber;
    @DBRef
    private User subscribiant;
    private LocalDate date;

    private static Random r = new Random();

    public static Subscribtion make(User subscriber, User subscribiant) {
        Subscribtion s = new Subscribtion();
        s.setId(valueOf((subscriber.getId()+subscribiant.getId()).hashCode()));
        s.setSubscriber(subscriber);
        s.setSubscribiant(subscribiant);
        s.setDate(LocalDate.now().minusDays(r.nextInt(23)));
        return s;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "id='" + id + '\'' +
                ", subscriberLogin='" + subscriber.getLogin() + '\'' +
                ", subscribiantLogin='" + subscribiant.getLogin() + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
