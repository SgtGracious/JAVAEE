package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WORKER")
@NamedQueries({
        @NamedQuery(name= "Worker.findAll", query = "SELECT w FROM Worker w")
})
@Getter
@Setter
@EqualsAndHashCode(of={"id"})

public class Worker implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private Integer id;

    @Column(name="NAME", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name="WORKER_SECTION",
            joinColumns = {@JoinColumn(name="WORKER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="SECTION_ID", referencedColumnName = "ID")})
    private List<Section> sectionList = new ArrayList();

    public Worker(){

    }
}
