package se331.lab.service;

import se331.lab.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrgSize();
    List<Organizer > getOrg(Integer pageSize, Integer page);
    Organizer getOrg (Long id);
}
