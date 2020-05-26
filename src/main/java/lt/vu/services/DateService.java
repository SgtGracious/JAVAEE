package lt.vu.services;

import javax.enterprise.inject.Specializes;

@Specializes
public class DateService extends DateTimeService {

    public String getDate() {
        return java.time.LocalDate.now().toString();
    }
}