package lt.vu.decorators;

import lt.vu.services.DateTimeService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class MainIndexPageDecorator implements IndexPage{

    @Inject
    @Delegate
    @Any
    MainIndexPage indexPage;

    @Inject
    private DateTimeService dateTimeService;

    @Override
    public String welcome() {
        return indexPage.welcome().replace("!date", dateTimeService.getDate());
    }
}