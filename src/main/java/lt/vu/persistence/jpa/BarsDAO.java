package lt.vu.persistence.jpa;

import lt.vu.entities.Bar;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BarsDAO {
    @Inject
    private EntityManager em;

    public void persist(Bar bar){
        this.em.persist(bar);
    }

    public List<Bar> loadAll(){
        return em.createNamedQuery("Bar.findAll", Bar.class).getResultList();
    }

    public Bar findOne(Integer id) { return em.find(Bar.class, id); }
}