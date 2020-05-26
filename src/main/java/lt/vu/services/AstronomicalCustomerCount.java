package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class AstronomicalCustomerCount implements NumberGenerator {

    public int generateCustomerCount() {
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
        }
        int min = 100;

        return ThreadLocalRandom.current().nextInt(min);
    }

}