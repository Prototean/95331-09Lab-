package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.dao.OrganizerDao;
import se331.lab.entity.Organizer;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizeService{
    final OrganizerDao organizerDao;
    @Override
    public Integer getOrgSize(){
        return organizerDao.getOrganizeSize();
    }

    @Override
    public List<Organizer> getOrg(Integer pageSize, Integer page) {
        return organizerDao.getOrganizes(pageSize, page);
    }

    @Override
    public Organizer getOrg(Long id ) {
        return organizerDao.getOrganize(id);
    }
}
