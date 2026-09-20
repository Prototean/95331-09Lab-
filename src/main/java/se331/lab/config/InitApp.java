package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepostiory;
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .organizer("CAMT").build());
        organizerRepository.save(Organizer.builder()
                .organizer("CMU").build());
        organizerRepository.save(Organizer.builder()
                .organizer("Chiang Mai").build());
        organizerRepository.save(Organizer.builder()
                .organizer("Chiang Mai Municipality").build());

        eventRepostiory.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time fore taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .organizer("CAMT").build());
        eventRepostiory.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CAMT Convention hall")
                .date("21th Jan")
                .time("8.00am - 4.00 pm.")
                .petsAllowed(false)
                .organizer("CMU").build());
        eventRepostiory.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petsAllowed(false)
                .organizer("Chiang Mai").build());
        eventRepostiory.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Ching Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petsAllowed(true)
                .organizer("Chiang Mai Municipality").build());
    }

}