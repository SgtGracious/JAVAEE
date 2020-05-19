package lt.vu.persistence.jpa;

import lt.vu.entities.Worker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class WorkersDAO {
    @Inject
    private EntityManager em;

    public void persist(Worker worker){
        this.em.persist(worker);
    }

    public Worker findOne(Integer id){
        return this.em.find(Worker.class, id);
    }

    public List<Worker> loadAll(){
        return em.createNamedQuery("Worker.findAll", Worker.class).getResultList();
    }
}