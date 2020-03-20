package km.hw52.microgram.dto;

import km.hw52.microgram.model.Subscribtion;
import km.hw52.microgram.model.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscribtionDTO {

    public static SubscribtionDTO from(Subscribtion subscribtion) {
        return builder()
                .id(subscribtion.getId())
                .subscriber(subscribtion.getSubscriber())
                .subscribiant(subscribtion.getSubscribiant())
                .date(subscribtion.getDate())
                .build();
    }

    private String id;
    private User subscriber;
    private User subscribiant;
    private LocalDate date;

}
