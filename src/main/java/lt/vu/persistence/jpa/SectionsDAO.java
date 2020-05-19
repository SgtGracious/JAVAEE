package lt.vu.persistence.jpa;

import lt.vu.entities.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SectionsDAO {
    @Inject
    private EntityManager em;

    public void persist(Section section){
        this.em.persist(section);
    }

    public Section findOne(Integer id){
        return this.em.find(Section.class, id);
    }

    public List<Section> loadAll(){
        return em.createNamedQuery("Section.findAll", Section.class).getResultList();
    }

    public Section update(Section section){
        return em.merge(section);
    }
}