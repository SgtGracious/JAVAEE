package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Section;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.jpa.SectionsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Model
@Getter @Setter
public class UpdateSections implements Serializable {

    private Section section;

    @Inject
    private SectionsDAO sectionsDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer sectionID = Integer.parseInt(requestParameters.get("sectionID"));

        this.section = sectionsDAO.findOne(sectionID);
    }

    @Transactional
    @LoggedInvocation
    public String updateSection(){
        try{
            sectionsDAO.update(this.section);
        } catch (OptimisticLockException e){

            return "/sectionDetails.xhtml?faces-redirect=true&sectionID=" + this.section.getId() + "&error=optimistic-lock-exception";
        }
        return "jpa-usecase.xhtml?&faces-redirect=true";
    }
}