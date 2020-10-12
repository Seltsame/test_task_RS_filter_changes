package ru.test_rocket.my_test_task.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.test_rocket.my_test_task.model.Meeting;

@Repository
public interface MeetingRepository extends PagingAndSortingRepository<Meeting, Long> {
}
