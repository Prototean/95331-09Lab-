package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerImpl implements OrganizerDao {

    List<Organizer> organizeList;

    @PostConstruct

    public void init() {
        organizeList = new ArrayList<>();
        organizeList.add(Organizer.builder()
                .id(123L)
                .organizer("Kat Laydee")
                .build());

        organizeList.add(Organizer.builder()
                .id(456L)
                .organizer("Fern Pollin")
                .build());

        organizeList.add(Organizer.builder()
                .id(789L)
                .organizer("Carey Wales")
                .build());

        organizeList.add(Organizer.builder()
                .id(1001L)
                .organizer("Dawng Dahd")
                .build());

        organizeList.add(Organizer.builder()
                .id(1002L)
                .organizer("Kahn Opiner")
                .build());

        organizeList.add(Organizer.builder()
                .id(1003L)
                .organizer("Broody Kill")
                .build());
    }

    @Override
    public Integer getOrganizeSize() {
        return organizeList.size();
    }

    @Override
    public List<Organizer> getOrganizes(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizeList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1 ) * pageSize;
        return organizeList.subList(firstIndex, Math.min(firstIndex + pageSize, organizeList.size()));
    }

    @Override
    public Organizer getOrganize(Long id) {
        return organizeList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
