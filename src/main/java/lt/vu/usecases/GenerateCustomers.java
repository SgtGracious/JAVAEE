package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.NumberGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
@Named
public class GenerateCustomers implements Serializable {
    @Inject
    NumberGenerator generator;

    private CompletableFuture<Integer> GenerationTask = null;

    @LoggedInvocation
    public String generateCustomerCount() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        GenerationTask = CompletableFuture.supplyAsync(() -> generator.generateCustomerCount());

        return  "jpa-usecase.xhtml?faces-redirect=true";
    }

    public boolean isGenerationRunning() {
        return GenerationTask != null && !GenerationTask.isDone();
    }

    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (GenerationTask == null) {
            return null;
        } else if (isGenerationRunning()) {
            return "Getting the customer count ...";
        }
        return "Customer count: " + GenerationTask.get();
    }
}