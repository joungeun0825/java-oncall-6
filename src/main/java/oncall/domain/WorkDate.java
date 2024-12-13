package oncall.domain;

import oncall.domain.constant.Month;
import oncall.domain.constant.Week;

import java.util.List;

public class WorkDate {
    private Month month;
    private Week week;

    public WorkDate(List<String> date){
        this.month = Month.from(date.get(0));
        this.week = Week.from(date.get(1));
    }
}
