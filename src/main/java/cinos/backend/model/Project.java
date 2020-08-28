package cinos.backend.model;

import lombok.Data;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")
@Data
public class Project {
    @Id
    @SequenceGenerator(name = "project_id_seq", sequenceName = "project_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private Integer forks;
    private Integer nMembers;
    private String github;
    private String name;

    @ManyToOne
    @JoinColumn(name="developer_id")
    private Developer responsible;
    private String description;
}
