package ru.test_rocket.my_test_task.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDateTime timeMeeting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id", foreignKey = @ForeignKey(name = "worker_to_meeting"))
    Worker workerOwner;

    @Column(name = "meeting_topic")
    String topic;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id", foreignKey = @ForeignKey(name = "meeting_to_worker"))
    List<Worker> workerList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subdivision_id", foreignKey = @ForeignKey(name = "meeting_to_subdivision"))
    Subdivision subdivision;
}
