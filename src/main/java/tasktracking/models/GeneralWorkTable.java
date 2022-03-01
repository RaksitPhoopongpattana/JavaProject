package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;


public class GeneralWorkTable {
    private SimpleStringProperty jobname;
    private SimpleStringProperty date;
    private SimpleStringProperty timestart;
    private SimpleStringProperty timeend;
    private SimpleStringProperty priority;
    private SimpleStringProperty category;
    private SimpleStringProperty status;
    private Button edit;

    public GeneralWorkTable(GeneralWork generalWork, EventHandler<ActionEvent>event){
        jobname = new SimpleStringProperty(generalWork.getJobname());
        date = new SimpleStringProperty(generalWork.getDate());
        timestart = new SimpleStringProperty(generalWork.getTimestart());
        timeend = new SimpleStringProperty(generalWork.getTimeend());
        priority = new SimpleStringProperty(generalWork.getPriority());
        category = new SimpleStringProperty(generalWork.getCategory());
        status = new SimpleStringProperty(generalWork.getStatus());
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
