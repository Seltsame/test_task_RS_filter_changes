package ru.test_rocket.my_test_task.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "worker_name")
    String name;

    @Column(name = "birth_day")
    LocalDate birthDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id", foreignKey = @ForeignKey(name = "worker_to_subdivision"))
    Subdivision subdivision;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "meeting_id", foreignKey = @ForeignKey(name = "worker_to_meeting"))
    List<Meeting> meetingList;
}
