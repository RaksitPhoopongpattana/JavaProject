package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tasktracking.controllers.editwork.EditForward;
import tasktracking.controllers.editwork.EditGeneral;

import java.io.IOException;

public class ForwardWorkTable {
    private SimpleStringProperty jobname;
    private SimpleStringProperty responsiblePerson;
    private SimpleStringProperty date;
    private SimpleStringProperty timestart;
    private SimpleStringProperty timeend;
    private SimpleStringProperty priority;
    private SimpleStringProperty category;
    private SimpleStringProperty status;
    private Button edit;

    public ForwardWorkTable(ForwardWork forwardWork, EventHandler<ActionEvent>event){
        jobname = new SimpleStringProperty(forwardWork.getJobname());
        responsiblePerson = new SimpleStringProperty(forwardWork.getResponsiblePerson());
        date = new SimpleStringProperty(forwardWork.getDate());
        timestart = new SimpleStringProperty(forwardWork.getTimestart());
        timeend = new SimpleStringProperty(forwardWork.getTimeend());
        priority = new SimpleStringProperty(forwardWork.getPriority());
        category = new SimpleStringProperty(forwardWork.getCategory());
        status = new SimpleStringProperty(forwardWork.getStatus());
        edit = new Button("แก้ไข");

        edit.setOnAction(event);
    }


    public String getJobname() {
        return jobname.get();
    }

    public SimpleStringProperty jobnameProperty() {
        return jobname;
    }

    public String getResponsiblePerson() {
        return responsiblePerson.get();
    }

    public SimpleStringProperty responsiblePersonProperty() {
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
