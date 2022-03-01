package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;

public class WeeklyWorkCategoryTable {
    private SimpleStringProperty jobname;
    private SimpleStringProperty date;
    private SimpleStringProperty timestart;
    private SimpleStringProperty timeend;
    private SimpleStringProperty priority;
    private SimpleStringProperty status;

    public WeeklyWorkCategoryTable(WeeklyWork weeklyWork){
        jobname = new SimpleStringProperty(weeklyWork.getJobname());
        date = new SimpleStringProperty(weeklyWork.getDate());
        timestart = new SimpleStringProperty(weeklyWork.getTimestart());
        timeend = new SimpleStringProperty(weeklyWork.getTimeend());
        priority = new SimpleStringProperty(weeklyWork.getPriority());
        status = new SimpleStringProperty(weeklyWork.getStatus());
    }

    public String getJobname() {
        return jobname.get();
    }

    public SimpleStringProperty jobnameProperty() {
        return jobname;
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public String getTimestart() {
        return timestart.get();
    }

    public SimpleStringProperty timestartProperty() {
        return timestart;
    }

    public String getTimeend() {
        return timeend.get();
    }

    public SimpleStringProperty timeendProperty() {
        return timeend;
    }

    public String getPriority() {
        return priority.get();
    }

    public SimpleStringProperty priorityProperty() {
        return priority;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }
}
