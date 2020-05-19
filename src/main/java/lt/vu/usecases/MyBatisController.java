package lt.vu.usecases;

import lt.vu.mybatis.dao.BarMapper;
import lt.vu.mybatis.dao.SectionMapper;
import lt.vu.mybatis.dao.WorkerMapper;
import lt.vu.mybatis.dao.WorkerSectionMapper;
import lombok.Getter;
import lt.vu.mybatis.model.Bar;
import lt.vu.mybatis.model.Section;
import lt.vu.mybatis.model.Worker;
import lt.vu.mybatis.model.WorkerSection;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.spi.Producer;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class MyBatisController{
    @Getter
    private Bar bar = new Bar();
    @Getter
    private Section section = new Section();
    @Getter
    private Section sectionToAssign = new Section();
    @Getter
    private Worker worker = new Worker();
    @Getter
    private WorkerSection workerSection = new WorkerSection();

    @Getter
    private List<Bar> bars;
    @Getter
    private List<Section> sections;
    @Getter
    private List<Worker> workers;

    @Inject
    private BarMapper barMapper;
    @Inject
    private SectionMapper sectionMapper;
    @Inject
    private WorkerMapper workerMapper;
    @Inject
    private WorkerSectionMapper workerSectionMapper;

    @PostConstruct
    public void init(){
        this.bars = barMapper.selectAll();
        this.sections = sectionMapper.selectAll();
        this.workers = workerMapper.selectAll();
    }

    @Transactional
    public void createNewSection(){
        section.setBarId(bar.getId());
        sectionMapper.insert(section);
    }

    @Transactional
    public void createNewBar(){
        barMapper.insert(bar);
    }

    @Transactional
    public void createNewWorker(){
        workerMapper.insert(worker);
    }

    @Transactional
    public Bar getBarById(Integer id) {
        return barMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void assignSectionToWorker(){
        workerSection.setSectionId(sectionToAssign.getId());
        workerSection.setWorkerId(worker.getId());
        workerSectionMapper.insert(workerSection);
    }

    @Transactional
    public List<Worker> getWorkerSection(Integer sectionId){
        List<Worker> workerList = new ArrayList<Worker>();
        List<WorkerSection> workerSection = workerSectionMapper.selectAll();
        for (WorkerSection ws : workerSection){
            if(ws.getSectionId() == sectionId){
                workerList.add(workerMapper.selectByPrimaryKey(ws.getWorkerId()));
            }
        }

        return workerList;
    }
}