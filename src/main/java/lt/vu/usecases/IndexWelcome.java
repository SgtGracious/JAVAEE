package lt.vu.usecases;

import lt.vu.decorators.IndexPage;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;

@Model
@RequestScoped
public class IndexWelcome implements Serializable {
    @Inject
    private IndexPage indexPage;

    public String welcome() {
        return indexPage.welcome();
    }
}
