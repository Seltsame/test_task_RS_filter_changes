package ru.test_rocket.my_test_task.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Subdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subdivision", cascade = CascadeType.MERGE)
    Set<Worker> workerSet;

    @Column(name = "subdivision_name")
    String name;
}
