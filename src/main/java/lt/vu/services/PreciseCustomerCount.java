package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class PreciseCustomerCount implements NumberGenerator {
    @Override
    public int generateCustomerCount() {
        return ThreadLocalRandom.current().nextInt(10);
    }
}