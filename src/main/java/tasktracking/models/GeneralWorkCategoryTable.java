package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class GeneralWorkCategoryTable {
    private SimpleStringProperty jobname;
    private SimpleStringProperty date;
    private SimpleStringProperty timestart;
    private SimpleStringProperty timeend;
    private SimpleStringProperty priority;
    private SimpleStringProperty status;

    public GeneralWorkCategoryTable(GeneralWork generalWork){
        jobname = new SimpleStringProperty(generalWork.getJobname());
        date = new SimpleStringProperty(generalWork.getDate());
        timestart = new SimpleStringProperty(generalWork.getTimestart());
        timeend = new SimpleStringProperty(generalWork.getTimeend());
        priority = new SimpleStringProperty(generalWork.getPriority());
        status = new SimpleStringProperty(generalWork.getStatus());
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
