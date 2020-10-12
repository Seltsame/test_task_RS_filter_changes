package ru.test_rocket.my_test_task.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.test_rocket.my_test_task.model.Subdivision;

import java.util.List;

@Repository
public interface SubdivisionRepository extends PagingAndSortingRepository<Subdivision, Long> {
    List<Subdivision> findAll();
}
