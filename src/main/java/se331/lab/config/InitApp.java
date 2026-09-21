package se331.lab.config;

import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;

import java.util.List;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepostiory;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
        Event tempEvent;
        tempEvent = eventRepostiory.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time fore taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepostiory.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CAMT Convention hall")
                .date("21th Jan")
                .time("8.00am - 4.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepostiory.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepostiory.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Ching Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petsAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        List<Event> events = eventRepostiory.findAll();
        Event event1 = events.get(0);
        Event event2 = events.get(1);
        Event event3 = events.get(2);
        Event event4 = events.get(3);

        Participant par1,par2,par3,par4,par5;
        par1 = participantRepository.save(Participant.builder()
                .name("Thanachai Srisawat")
                .telNo("081-111-1111")
                .build());
        par2 = participantRepository.save(Participant.builder()
                .name("Nattapong Wongchai")
                .telNo("082-222-2222")
                .build());
        par3 = participantRepository.save(Participant.builder()
                .name("Suda Chaiyaporn")
                .telNo("083-333-3333")
                .build());
        par4 = participantRepository.save(Participant.builder()
                .name("Malee Jaidee")
                .telNo("084-444-4444")
                .build());
        par5 = participantRepository.save(Participant.builder()
                .name("Anan Boonmee")
                .telNo("085-555-5555")
                .build());

        par1.getEventHistories().addAll(List.of(event1, event2, event3));
        par2.getEventHistories().addAll(List.of(event2, event3, event4));
        par3.getEventHistories().addAll(List.of(event1, event3, event4));
        par4.getEventHistories().addAll(List.of(event1, event2));
        par5.getEventHistories().addAll(List.of(event1, event2, event4));
    }

}