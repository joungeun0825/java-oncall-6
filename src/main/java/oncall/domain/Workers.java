package oncall.domain;

public class Workers {
    private DayOnWorkers dayOnWorkers;
    private DayOffWorkers dayOffWorkers;

    public Workers(DayOnWorkers dayOnWorkers, DayOffWorkers dayOffWorkers){
        this.dayOnWorkers = dayOnWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }
}
