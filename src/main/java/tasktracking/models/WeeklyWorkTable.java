package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class WeeklyWorkTable {
    private SimpleStringProperty jobname;
    private SimpleStringProperty date;
    private SimpleStringProperty timestart;
    private SimpleStringProperty timeend;
    private SimpleStringProperty priority;
    private SimpleStringProperty category;
    private SimpleStringProperty status;
    private Button edit;

    public WeeklyWorkTable(WeeklyWork weeklyWork, EventHandler<ActionEvent>event){
        jobname = new SimpleStringProperty(weeklyWork.getJobname());
        date = new SimpleStringProperty(weeklyWork.getDate());
        timestart = new SimpleStringProperty(weeklyWork.getTimestart());
        timeend = new SimpleStringProperty(weeklyWork.getTimeend());
        priority = new SimpleStringProperty(weeklyWork.getPriority());
        category = new SimpleStringProperty(weeklyWork.getCategory());
        status = new SimpleStringProperty(weeklyWork.getStatus());
        edit = new Button("แก้ไข");

        edit.setOnAction(event);
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

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public Button getEdit() {
        return edit;
    }
}
