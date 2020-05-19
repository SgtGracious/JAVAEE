package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SECTION")
@NamedQueries({
        @NamedQuery(name = "Section.findAll", query = "select s from Section as s")
})
@Getter
@Setter
@EqualsAndHashCode(of={"id"})

public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max=50)
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MAXWORKERS", nullable = false)
    private Float maxWorkers;

    @ManyToOne
    @JoinColumn(name = "BAR_ID")
    private Bar bar;

    @ManyToMany(mappedBy = "sectionList")
    private List<Worker> workerList = new ArrayList();

    @Version
    @Column(name="OPT_LOCK_VERSION")
    private Integer version;

    public Section() {
    }

    public Section(String name, Float maxWorkers) {
        this.name = name;
        this.maxWorkers = maxWorkers;
    }
}
