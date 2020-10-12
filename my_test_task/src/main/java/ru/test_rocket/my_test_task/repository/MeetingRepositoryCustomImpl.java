package ru.test_rocket.my_test_task.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import ru.test_rocket.my_test_task.dto.MeetingFilterDto;
import ru.test_rocket.my_test_task.model.Meeting;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MeetingRepositoryCustomImpl implements MeetingRepositoryCustom {

    public final EntityManager entityManager;

    public MeetingRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Meeting> getMeetingByFilter(MeetingFilterDto filterDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Meeting> query = criteriaBuilder.createQuery(Meeting.class);
        Root<Meeting> from = query.from(Meeting.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (!StringUtils.isEmpty(filterDto.getTopic())) {
            predicateList.add(criteriaBuilder.like(from.get("topic"), filterDto.getTopic()));
        }

        if (filterDto.getWorkerId() != null) {
            predicateList.add(criteriaBuilder.equal(from.get("workerOwner.id"), filterDto.getWorkerId()));
        }

        if (filterDto.getSubdivisionId() != null) {
            predicateList.add(criteriaBuilder.equal(from.get("subdivision.id"), filterDto.getSubdivisionId()));
        }

        if (filterDto.getStartDate() != null) {
            predicateList.add(criteriaBuilder.greaterThanOrEqualTo(from.get("timeMeeting"), filterDto.getStartDate()));
        }

        if (filterDto.getEndDate() != null) {
            predicateList.add(criteriaBuilder.lessThanOrEqualTo(from.get("timeMeeting"), filterDto.getEndDate()));
        }

        query.where(predicateList.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();

    }


}
