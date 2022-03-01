package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;

public class ForwardWorkCategoryTable {
    private SimpleStringProperty jobname;
    private SimpleStringProperty responsiblePerson;
    private SimpleStringProperty date;
    private SimpleStringProperty timestart;
    private SimpleStringProperty timeend;
    private SimpleStringProperty priority;
    private SimpleStringProperty status;

    public ForwardWorkCategoryTable(ForwardWork forwardWork){
        jobname = new SimpleStringProperty(forwardWork.getJobname());
        responsiblePerson = new SimpleStringProperty(forwardWork.getResponsiblePerson());
        date = new SimpleStringProperty(forwardWork.getDate());
        timestart = new SimpleStringProperty(forwardWork.getTimestart());
        timeend = new SimpleStringProperty(forwardWork.getTimeend());
        priority = new SimpleStringProperty(forwardWork.getPriority());
        status = new SimpleStringProperty(forwardWork.getStatus());
    }

    public String getJobname() {
        return jobname.get();
    }

    public SimpleStringProperty jobnameProperty() {
        return jobname;
    }

    public String getResponsiblePerson() {return  responsiblePerson.get();}

    public SimpleStringProperty responsiblePerson() {
        return responsiblePerson;
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
