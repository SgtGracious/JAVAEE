package lt.vu.usecases;

import lombok.Getter;
import lt.vu.decorators.IndexPage;
import lt.vu.entities.Bar;
import lt.vu.entities.Section;
import lt.vu.entities.Worker;
import lt.vu.persistence.jpa.BarsDAO;
import lt.vu.persistence.jpa.SectionsDAO;
import lt.vu.persistence.jpa.WorkersDAO;
import lt.vu.interceptors.LoggedInvocation;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
@ViewScoped
public class PersistenceController implements Serializable {
    @Inject
    private BarsDAO barsDAO;
    @Inject
    private SectionsDAO sectionsDAO;
    @Inject
    private WorkersDAO workersDAO;


    @Getter
    private Bar bar = new Bar();
    @Getter
    private Section section = new Section();
    @Getter
    private Section sectionToAssign = new Section();
    @Getter
    private Worker worker = new Worker();

    @Getter
    private List<Bar> bars;
    @Getter
    private List<Section> sections;
    @Getter
    private List<Worker> workers;

    @PostConstruct
    public void init(){
        this.bars = barsDAO.loadAll();
        this.sections = sectionsDAO.loadAll();
        this.workers = workersDAO.loadAll();

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        if(requestParameters.containsKey("barId"))
        {
            Integer barId = Integer.parseInt(requestParameters.get("barId"));
            this.bar = barsDAO.findOne(barId);
        }
        if(requestParameters.containsKey("workerId"))
        {
            Integer workerId = Integer.parseInt(requestParameters.get("workerId"));
            this.worker = workersDAO.findOne(workerId);
        }
    }

    @Transactional
    public void createNewBar(){
        bar.setId(null);
        barsDAO.persist(bar);
    }

    @LoggedInvocation
    @Transactional
    public void createNewSection(){
        List<Worker> workerList = new ArrayList();

        barsDAO.findOne(bar.getId());
        section.setBar(bar);
        section.setWorkerList(workerList);

        sectionsDAO.persist(section);
    }

    @Transactional
    public void createNewWorker(){
        List<Section> sectionList = new ArrayList();

        worker.setId(null);
        worker.setSectionList(sectionList);

        workersDAO.persist(worker);
    }

    @Transactional
    public void assignSectionToWorker(){
        Section sectionToAssignInstance = sectionsDAO.findOne(sectionToAssign.getId());
        Worker workerToAssign = workersDAO.findOne(worker.getId());

        List<Section> sectionList = workerToAssign.getSectionList();
        sectionList.add(sectionToAssignInstance);

        workerToAssign.setSectionList(sectionList);
    }

}