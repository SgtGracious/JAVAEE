package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BAR")
@NamedQueries({
        @NamedQuery(name = "Bar.findAll", query = "SELECT b FROM Bar b")
})
@Getter
@Setter
@EqualsAndHashCode(of={"id"})

public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable =  false)
    private String name;

    @OneToMany(mappedBy = "bar")
    private List<Section> productList = new ArrayList();

    public Bar() {

    }
}
