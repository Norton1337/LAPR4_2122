package eapli.base.customermanagement.domain;
import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerBirth implements ValueObject {
    private String day;
    private String month;
    private String year;

    public CustomerBirth(String day, String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public CustomerBirth(){}


    @Override
    public String toString() {
        return "CustomerBirth{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
