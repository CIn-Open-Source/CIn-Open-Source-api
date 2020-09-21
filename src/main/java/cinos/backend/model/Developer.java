package cinos.backend.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "developer")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developer")
public class Developer {
    @Id
    @SequenceGenerator(name = "developer_id_seq", sequenceName = "developer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "developer_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String name;
    private String github;
    private String linkedin;
    private String twitter;
    private String private_key;
}
