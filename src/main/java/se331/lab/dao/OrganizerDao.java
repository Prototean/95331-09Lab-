package se331.lab.dao;

import se331.lab.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    Integer getOrganizeSize();
    List<Organizer> getOrganizes(Integer pageSize, Integer page);
    Organizer getOrganize(Long id);
}
