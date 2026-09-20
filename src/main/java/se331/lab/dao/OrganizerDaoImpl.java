package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("memory")
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .organizer("animal welfare")
                .build());

        organizerList.add(Organizer.builder()
                .id(456L)
                .organizer("Noice Cooperation")
                .build());

        organizerList.add(Organizer.builder()
                .id(789L)
                .organizer("Carey Wales")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }
    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1 ) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page - 1, pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1 );
        organizerList.add(organizer);
        return organizer;
    }
}