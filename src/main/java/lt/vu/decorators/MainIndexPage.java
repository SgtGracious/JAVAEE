package lt.vu.decorators;

import javax.enterprise.inject.Default;

@Default
public class MainIndexPage implements IndexPage {

    @Override
    public String welcome() {
        return "The date and time are: !date Welcome to your favorite bars";
    }
}